/*
 * ServletEnviarAplicacao.java
 *
 * Created on 25 de Julho de 2007, 19:55
 */

package appserver.servlets;

import appserver.modelo.AplicacaoJavaCard;
import appserver.modelo.controle.AplicacaoJavaCardDAO;
import appserver.util.ServletManager;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.hibernate.HibernateException;

/**
 *
 * @author Tiago
 * @version
 */
public class ServletAdicionarAplicacao extends HttpServlet
{
   /** Processes requests for  HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      // Obtenção dos parâmetros
      String nome = "";
      String descricao = "";
      
      try
      {
         // Verifica se há um request de upload de arquivo.
         boolean isMultipart = ServletFileUpload.isMultipartContent(request);
         
         // Validação dos parâmetros
         if (isMultipart == false)
         {
            ServletManager.dispatchException("Invalid servlet parameters.", response);
            return;
         }
         
         // Prepara o manipulador de uploads.
         FileItemFactory factory = new DiskFileItemFactory();
         ServletFileUpload upload = new ServletFileUpload(factory);
         
         // Interpreta a requisição.
         List items = upload.parseRequest(request);
         
         // Constrói a mensagem resposta.
         byte[] arquivoCAP = null;
         boolean carregou = false;
         int i=0;
         
         Iterator it = items.iterator();
         while (it.hasNext() && carregou == false)
         {
            FileItem fitem = (FileItem) it.next();
            if (fitem.isFormField())
            {
               if (fitem.getFieldName().equals("nome"))
                  nome = fitem.getString();
               else if (fitem.getFieldName().equals("descricao"))
                  descricao = fitem.getString();
            }
            else
            {
               // Obtém o stream de entrada
               ArrayList<Byte> lista = new ArrayList<Byte>();
               InputStream is = fitem.getInputStream();
               int leitura;
               
               while ((leitura = is.read()) != -1)
                  lista.add((byte) leitura);
               
               // Cria um array de bytes
               arquivoCAP = new byte[lista.size()];
               
               for (byte b: lista)
                  arquivoCAP[i++] = b;
               
               carregou = true;
            }
         }
         
         // Persiste aplicação
         AplicacaoJavaCard aplicacao = new AplicacaoJavaCard();
         aplicacao.setArquivo(arquivoCAP);
         aplicacao.setNome(nome);
         aplicacao.setDescricao(descricao);
         
         try
         {         
            AplicacaoJavaCardDAO.saveAplicacaoJavaCard(aplicacao);
         } catch (HibernateException ex)
         {
            ex.printStackTrace();
         }
         
         // Retorna OK
         //response.setStatus(HttpServletResponse.SC_OK);
         
         // Escreve um documento HTML com textarea (para o dojo).
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
         out.println("<html><body>");
         out.println("<textarea>");
         out.println("ok");
         out.println("</textarea>");
         out.println("</body></html>");
         out.close();
      }
      catch (FileUploadException ex)
      {
         ServletManager.dispatchException(ex.getMessage(), response);
      }
   }
}
