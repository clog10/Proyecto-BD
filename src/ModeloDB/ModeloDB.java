
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Color;
import modelo.Herrajes;
import modelo.Material;
import modelo.Medida;
import modelo.Modelos;
import modelo.conectate;
import vista.Colores;

/**
 *
 * @author Clog_10
 */
public class ModeloDB {
    conectate con;

    public ModeloDB() {
        con = new conectate();
    }
    
     public void ingresaDatosModelo(Modelos m){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO modelo (idmodelo, imagen, idcolor, idmaterial, idmedidas, idherraje, precio)"
                    + "VALUES(?,?,?,?,?,?,?)");
            pstm.setInt(1, m.getIdmodelo());
            pstm.setString(2, m.getImagen());
            pstm.setInt(3, m.getIdcolor());
            pstm.setInt(4, m.getIdmaterial());
            pstm.setInt(5, m.getIdmedidas());
            pstm.setInt(6, m.getIdherrajes());
            pstm.setDouble(7, m.getPrecio());
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();
            
        }catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL MODELO");
        }
    }
    
    
public void deleteModelo(int cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from modelo where idmodelo = ?");            
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idmodelo) as total FROM modelo ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][7];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " idmodelo, imagen, idcolor, idmaterial, idmedidas, idherraje, precio" +
            " FROM modelo" +
            " ORDER BY idmodelo ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idmo = res.getString("idmodelo");
            String ima = res.getString("imagen");
            String idcol = res.getString("idcolor");
            String idmate = res.getString("idmaterial");
            String idmedi = res.getString("idmedidas");
            String idherr = res.getString("idherraje");
            String precio = res.getString("precio");
            data[i][0] = idmo;            
            data[i][1] = ima;            
            data[i][2] = idcol;            
            data[i][3] = idmate;  
            data[i][4] = idmedi; 
            data[i][5] = idherr; 
            data[i][6] = precio;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    public void updateModelo(int id,String imagen, int idcol, int idmate, int idmedi, int idherr, double precio){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update modelo " +
            "set idmodelo = ? ," +
            "imagen = ? ," +
            "idcolor = ? ," +                    
            "idmaterial = ? ," +   
            "idmedidas = ? ," +   
            "idherraje = ? ," +   
            "precio = ? " + 
            "where idmodelo = ? ");            
            pstm.setInt(1, id);
            pstm.setString(2, imagen);
            pstm.setInt(3, idcol);
            pstm.setInt(4, idmate);
            pstm.setInt(5, idmedi);
            pstm.setInt(6, idherr);
            pstm.setDouble(7, precio);
            pstm.setInt(8, id);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
    
    public List<Color> listColores() {

        List<Color> color = new ArrayList<Color>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from colores;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Color l= new Color(); 
                l.setIdcolor(rs.getInt("idcolor"));
                l.setColor(rs.getString("color"));

                color.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (colores)" + exception);
        }
        return color;
    }
    
    public List<Material> listMateriales() {

        List<Material> mat = new ArrayList<Material>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from material;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Material l= new Material();  
                l.setIdmaterial(rs.getInt("idmaterial"));
                l.setTipo(rs.getString("tipo"));

                mat.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (materiales)" + exception);
        }
        return mat; 
    }
    
    public List<Medida> listMedidas() {

        List<Medida> mat = new ArrayList<Medida>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from medidas;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Medida l= new Medida();  
                l.setIdmedida(rs.getInt("idmedida"));
                l.setAncho(rs.getInt("ancho"));
                l.setAlto(rs.getInt("alto"));
                l.setFondo(rs.getInt("fondo")); 

                mat.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (medidas)" + exception);
        }
        return mat; 
    }
    
    public List<Herrajes> listHerrajes() {

        List<Herrajes> mat = new ArrayList<Herrajes>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from herraje;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Herrajes l= new Herrajes();  
                l.setIdherraje(rs.getInt("idherraje"));
                l.setTipo(rs.getString("tipo"));

                mat.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (herrajes)" + exception);
        }
        return mat; 
    }
    
}














