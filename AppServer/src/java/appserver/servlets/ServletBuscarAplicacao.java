/*
 * ServletGerenciarAplicacao.java
 *
 * Created on 30 de Julho de 2007, 17:44
 */

package appserver.servlets;

import appserver.modelo.AplicacaoJavaCard;
import appserver.modelo.controle.AplicacaoJavaCardDAO;
import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Tiago
 * @version
 */
public class ServletBuscarAplicacao extends HttpServlet
{
   /** Processes requests for  HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      // Obtenção dos parâmetros
      String consulta = (String) request.getParameter("consulta");
      List resultado;
      
      if (consulta != null && consulta.equals("") == false)
         resultado = AplicacaoJavaCardDAO.listByNome(consulta);
      else
         resultado = AplicacaoJavaCardDAO.listAll();
      
      // Inicialização da resposta.
      StringBuilder stringXML = new StringBuilder();
      
      // Escrita no buffer.
      stringXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      stringXML.append("<list>\n");
      
      for (Object appObj: resultado)
      {
         AplicacaoJavaCard app = (AplicacaoJavaCard) appObj;

         stringXML.append("\t<item id=\"");
         stringXML.append(Long.toString(app.getId()));
         stringXML.append("\" nome=\"");
         stringXML.append(app.getNome());
         stringXML.append("\">");
         stringXML.append(app.getDescricao());
         stringXML.append("</item>\n");
      }
      stringXML.append("</list>\n");

      // Escrita na resposta.
      response.setContentType("text/xml");
      response.setHeader("Cache-Control", "no-cache");
      PrintWriter out = response.getWriter();

      out.append(stringXML.toString());
      out.close();
         
   }
   
}
