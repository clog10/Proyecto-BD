/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*; 

public class conectate { 
   static String bd = "proyectofintaller"; 
   static String login = "root"; 
   static String password = "RA16161255"; 
   static String url = "jdbc:mysql://localhost/"+bd; 
 
   private Connection conn = null; 
    
   public conectate() { 
      try{          
         Class.forName("com.mysql.jdbc.Driver");          
         conn = DriverManager.getConnection(url,login,password); 
         if (conn!=null){ 
            System.out.println("Conexión a base de datos "+bd+". listo"); 
         } 
      }catch(SQLException e){ 
         System.out.println(e); 
      }catch(ClassNotFoundException e){ 
         System.out.println(e); 
      } 
   } 
    
   public Connection getConnection(){ 
      return conn; 
   } 
 
   public void desconectar(){ 
      conn = null; 
   } 
}


