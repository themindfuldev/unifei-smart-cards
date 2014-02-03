/*
 * CardListenerApplet.java
 *
 * Created on 17 de Novembro de 2006, 08:39
 */

package applet;

import java.applet.*;
import java.io.*;
import java.security.AccessControlException;


public class CardClientApplet extends Applet
{
   /**
    * Inicializador de componentes.
    */
   public String carregaArquivo(String arquivoStr)
   {
      String resposta = null;
      File arquivo = null, arquivoSaida = null;
      
      // Criacao do arquivo.
      try
      {
         arquivo = File.createTempFile("script", ".txt");
         FileWriter fw = new FileWriter(arquivo);
         fw.write(arquivoStr);
         fw.close();
         
         arquivoSaida = File.createTempFile("saida", ".txt");
         
         // Processamento do script
         com.sun.javacard.apdutool.Main.main(new String[]{"-o", arquivoSaida.getAbsolutePath(), arquivo.getAbsolutePath()});
      }
      catch(AccessControlException ex)
      {        
         if (ex.getPermission().getName().startsWith("exitVM"))
         {                 
            try
            {            
               // Saida
               BufferedReader br = new BufferedReader(new FileReader(arquivoSaida));
               StringBuilder sb = new StringBuilder();               
               
               while (br.ready() == true)
                  sb.append(br.readLine()+"\n");
               
               resposta = sb.toString();
               br.close();

               arquivoSaida.delete();
               arquivo.delete();
            } catch (Exception ex2)
            {
               resposta = ex2.getMessage();
               ex2.printStackTrace();
            }
         }
         else
         {
            resposta = ex.getMessage();
            ex.printStackTrace();
         }         
      }
      catch(Exception ex)
      {
         resposta = ex.getMessage();
         ex.printStackTrace();
      }
      
      return resposta;
   }   
  
   public static void main(String[] args)
   {
      
   }   
   
}