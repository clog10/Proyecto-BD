
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Medida;
import modelo.conectate;

/**
 *
 * @author Clog_10
 */
public class MedidasDB {
        conectate con;

    public MedidasDB() {
        con = new conectate();
    }
        
         public void ingresaDatosMedidas(Medida m){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO medidas (idmedida, ancho, alto, fondo)"
                    + "VALUES(?,?,?,?)");
            pstm.setInt(1, m.getIdmedida());
            pstm.setInt(2, m.getAncho());
            pstm.setInt(3, m.getAlto());
            pstm.setInt(4, m.getFondo());
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();
            
        }catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DE LAS MEDIDAS");
        }
    }
    
    
public void deleteMedidas(int cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from medidas where idmedida = ?");            
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idmedida) as total FROM medidas ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][4];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " idmedida, ancho, alto, fondo" +
            " FROM medidas" +
            " ORDER BY idmedida ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idmedi = res.getString("idmedida");
            String ancho = res.getString("ancho");
            String alto = res.getString("alto");
            String fondo = res.getString("fondo");
            data[i][0] = idmedi;            
            data[i][1] = ancho;            
            data[i][2] = alto;            
            data[i][3] = fondo;   
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    public void updateMedidas(int id, int ancho, int alto, int fondo){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update medidas " +
            "set idmedida = ? ," +
            "ancho = ? ," +
            "alto = ? ," +                    
            "fondo = ? " +      
            "where idmedida = ? ");            
            pstm.setInt(1, id);
            pstm.setInt(2, ancho);
            pstm.setInt(3, alto);
            pstm.setInt(4, fondo);
            pstm.setInt(5, id);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
}






