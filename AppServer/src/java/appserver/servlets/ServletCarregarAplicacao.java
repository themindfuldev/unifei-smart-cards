/*
 * ServletGerenciarAplicacao.java
 *
 * Created on 30 de Julho de 2007, 17:44
 */

package appserver.servlets;

import appserver.modelo.AplicacaoJavaCard;
import appserver.modelo.controle.AplicacaoJavaCardDAO;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Tiago
 * @version
 */
public class ServletCarregarAplicacao extends HttpServlet
{
   /** Processes requests for  HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      // Obtenção dos parâmetros
      Long id = Long.parseLong((String)request.getParameter("id"));
      
      // Busca e Remove
      AplicacaoJavaCard aplicacao = AplicacaoJavaCardDAO.queryById(id); 
      
      
      // Inicialização da resposta.
      StringBuilder stringXML = new StringBuilder();
      
      // Escrita no buffer.
      stringXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      stringXML.append("<application>");
      
      for (byte b: aplicacao.getArquivo())
         stringXML.append(Character.toString((char)b));
      stringXML.append("</application>\n");

      // Escrita na resposta.
      response.setContentType("text/xml");
      response.setHeader("Cache-Control", "no-cache");
      PrintWriter out = response.getWriter();

      out.append(stringXML.toString());
      out.close();
   }
   
}
