
package appserver.util ;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * @netbeans.hibernate.util
 */
public class HibernateUtil {
    private static Log log = LogFactory.getLog(HibernateUtil.class);
    
    private static SessionFactory sessionFactory;
    
    private static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                // load all beans
                InputStream is = HibernateUtil.class.getResourceAsStream("hibernateBeans.lst");
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line ;
                while ((line = reader.readLine()) != null) {
                    configuration.addResource(line);
                }
                Properties properties = new Properties();
                properties.load(HibernateUtil.class.getResourceAsStream("hibernate.properties"));
                configuration.setProperties(properties);
                sessionFactory =  configuration.buildSessionFactory();
            }
            
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
        return  sessionFactory;
    }
    
    public static final ThreadLocal session = new ThreadLocal();
    
    
    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s == null) {
            s = getSessionFactory().openSession();
            session.set(s);
        }
        return s;
    }
    
    
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null)
            s.close();
    }

}