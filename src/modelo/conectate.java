/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*; 

public class conectate { 
   static String bd = "dbproyecto"; 
   static String login = "root"; 
   static String password = "123456"; 
   static String url = "jdbc:mysql://localhost/"+bd; 
 
   private Connection conn = null; 
    
   public conectate() { 
      try{          
         Class.forName("com.mysql.cj.jdbc.Driver");          
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

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
   
   
}






