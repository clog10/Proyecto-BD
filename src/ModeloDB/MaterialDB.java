
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Material;
import modelo.conectate;

/**
 *
 * @author Clog_10
 */
public class MaterialDB {
        conectate con;

    public MaterialDB() {
        con = new conectate();
    }
        
     public void ingresaDatosMaterial(Material m){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO material (idmaterial, tipo)"
                    + "VALUES(?,?)");
            pstm.setInt(1, m.getIdmaterial());
            pstm.setString(2, m.getTipo());
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();
            
        }catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL MATERIAL");
        }
    }
    
    
public void deleteMaterial(int cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from material where idmaterial = ?");            
                pstm.setInt(1, cod);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

    
    
    public Object [][] getDatos(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idmaterial) as total FROM material ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " idmaterial, tipo" +
            " FROM material" +
            " ORDER BY idmaterial ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idmate = res.getString("idmaterial");
            String tipo = res.getString("tipo");
            data[i][0] = idmate;            
            data[i][1] = tipo;             
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    public void updateMaterial(int id,String tipo){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update material " +
            "set idmaterial = ? ," +
            "tipo = ? " +  
            "where idmaterial = ? ");            
            pstm.setInt(1, id);
            pstm.setString(2, tipo);
            pstm.setInt(3, id);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
}






