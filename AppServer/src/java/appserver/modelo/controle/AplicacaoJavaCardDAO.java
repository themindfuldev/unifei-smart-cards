package appserver.modelo.controle;

import appserver.modelo.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *  @netbeans.hibernate.facade beanClass=appserver.modelo.AplicacaoJavaCard
 */
public class AplicacaoJavaCardDAO
{
   
   public static void saveAplicacaoJavaCard(AplicacaoJavaCard aplicacaoJavaCard) throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Transaction tx = session.beginTransaction();
      session.save(aplicacaoJavaCard);
      tx.commit();
      appserver.util.HibernateUtil.closeSession();
   }
   
   public static void removeAplicacaoJavaCard(AplicacaoJavaCard aplicacaoJavaCard) throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Transaction tx = session.beginTransaction();
      session.delete(aplicacaoJavaCard);
      tx.commit();
      appserver.util.HibernateUtil.closeSession();
   }
   
   public static AplicacaoJavaCard queryByNome(String nome) throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Query query = session.createQuery(
              " select aplicacaoJavaCard " +
              " from  " +
              " AplicacaoJavaCard as aplicacaoJavaCard " +
              "  where  " +
              " aplicacaoJavaCard.nome =  " + nome);
      
      return (appserver.modelo.AplicacaoJavaCard) query.uniqueResult();
   }
   
   public static AplicacaoJavaCard queryById(Long id) throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Query query = session.createQuery(
              " select aplicacaoJavaCard " +
              " from  " +
              " AplicacaoJavaCard as aplicacaoJavaCard " +
              "  where  " +
              " aplicacaoJavaCard.id =  " + id);
      
      return (appserver.modelo.AplicacaoJavaCard) query.uniqueResult();
   }
   
   public static List listAll() throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Query query = session.createQuery(
              " select aplicacaoJavaCard " +
              " from  " +
              " AplicacaoJavaCard as aplicacaoJavaCard ");
      
      return query.list();
   }
   
   public static List listByNome(String nome) throws HibernateException
   {
      Session session = appserver.util.HibernateUtil.currentSession();
      Query query = session.createQuery(
              " select aplicacaoJavaCard " +
              " from  " +
              " AplicacaoJavaCard as aplicacaoJavaCard " +
              " where  " +
              " aplicacaoJavaCard.nome like ?");
      query.setString(0, "%"+nome+"%");
      
      return query.list();
   }
   
}
