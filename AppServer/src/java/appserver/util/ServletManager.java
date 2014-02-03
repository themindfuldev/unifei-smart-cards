/*
 * ServletManager.java
 *
 * Created on 14 de Fevereiro de 2007, 10:07
 */

package appserver.util;

import java.io.*;
import javax.servlet.http.*;

/**
 * Fornece métodos para suportar e padronizar serviços dos servlets.
 *
 * @author Tiago Romero Garcia
 * @version 0.1.9
 */
public class ServletManager
{  
   /**
    * Despacha uma mensagem de exceção a ser tratada por um servlet, e se não
    * for possível, por javascript no cliente.
    *
    * @param message    Mensagem de exceção
    * @param response   Response do servlet atual
    */
   public static void dispatchException(String message, HttpServletResponse response)
   {
      response.reset();
      try
      {
         response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
      }
      catch (IOException ex)
      {
         response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      }
   }
   
}
