/*
 * ServletExibirResposta.java
 *
 * Created on 17 de Agosto de 2007, 15:53
 */

package appserver.servlets;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Tiago
 * @version
 */
public class ServletExibirResposta extends HttpServlet
{
   
   /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      String resposta = request.getParameter("resposta");
      
      // Verifica parâmetros.
      if (resposta == null)
         resposta = "Um erro ocorreu. Favor tentar novamente";
      
      resposta = resposta.replaceAll("\r\n", "<br>");
      
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Application Server - Exibir Resposta</title>");
      out.println("<link rel=\"stylesheet\" href=\"css/appserver.css\" type=\"text/css\">");
      out.println("</head>");
      out.println("<body>");
      out.println("<h2>Application Server</h2>");
      out.println("<h3>Exibir Resposta<hr></h3>");
      out.println("<p class=\"resposta\">" + resposta + "</p>");
      out.println("<hr>");
      out.println("</body>");      
      out.println("</html>");      
      
      out.close();
   }
   
   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      processRequest(request, response);
   }
   
   /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
   {
      processRequest(request, response);
   }
   
   /** Returns a short description of the servlet.
    */
   public String getServletInfo()
   {
      return "Short description";
   }
   // </editor-fold>
}
