
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Color;
import modelo.Estatus;
import modelo.Modelos;
import modelo.Productos;
import modelo.conectate;

/**
 *
 * @author Clog_10
 */
public class ProductoDB {
    conectate con;

    public ProductoDB() {
        con = new conectate();
    }
    
     public void ingresaDatosProducto(Productos c){
        try{
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO producto (idproducto, idmodelo, p_venta_publico, productos_disponibles, descuento, idstatus,descripcion)"
                    + "VALUES(?,?,?,?,?,?,?)");
            pstm.setInt(1, c.getIdproducto());
            pstm.setInt(2, c.getIdmodelo());
            pstm.setDouble(3, c.getP_venta_publico());
            pstm.setInt(4, c.getProductos_disponibles());
            pstm.setInt(5, c.getDescuento());
            pstm.setInt(6, c.getIdstatus());
            pstm.setString(7, c.getDescripcion());
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();
            
        }catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL PRODUCTO");
        }
    }
    
    
public void deleteProducto(int cod){  
            try {                
                PreparedStatement pstm = con.getConnection().prepareStatement("delete from producto where idproducto = ?");            
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
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idproducto) as total FROM producto ");
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
            " idproducto, idmodelo, p_venta_publico, productos_disponibles, descuento, idstatus,descripcion" +
            " FROM producto" +
            " ORDER BY idproducto ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idpro = res.getString("idproducto");
            String idmod = res.getString("idmodelo");
            String pven = res.getString("p_venta_publico");
            String produc = res.getString("productos_disponibles");
            String desc = res.getString("descuento");
            String idsta = res.getString("idstatus");
            String descrip = res.getString("descripcion");    
            data[i][0] = idpro;            
            data[i][1] = idmod;            
            data[i][2] = pven;            
            data[i][3] = produc;  
            data[i][4] = desc; 
            data[i][5] = idsta; 
            data[i][6]=descrip;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
    
    public void updateProducto(int id, int idmodelo, double precio, int productos, int descuento, int idstatus,String descripcion){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("update producto " +
            "set idproducto = ? ," +
            "idmodelo = ? ," +
            "p_venta_publico = ? ," +                    
            "productos_disponibles = ? ," +   
            "descuento = ? ," +   
            "idstatus = ? ," + 
            "descripcion=? "+        
            "where idproducto = ? ");            
            pstm.setInt(1, id);
            pstm.setInt(2, idmodelo);
            pstm.setDouble(3, precio);
            pstm.setInt(4, productos);
            pstm.setInt(5, descuento);
            pstm.setInt(6, idstatus);
            pstm.setString(7,descripcion); 
            pstm.setInt(8, id);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
    
    public List<Estatus> listEstatus() {

        List<Estatus> mat = new ArrayList<Estatus>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from estatus;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Estatus l= new Estatus();   
                l.setIdstatus(rs.getInt("idstatus"));
                l.setTipo(rs.getString("tipo"));

                mat.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (status)" + exception);
        }
        return mat; 
    }
    
    public List<Modelos> listModelos() {

        List<Modelos> mod = new ArrayList<Modelos>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from modelo;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Modelos l = new Modelos(); 
                l.setIdmodelo(rs.getInt("idmodelo"));
                l.setImagen(rs.getString("imagen"));
                l.setIdcolor(rs.getInt("idcolor"));
                l.setIdmaterial(rs.getInt("idmaterial"));
                l.setIdmedidas(rs.getInt("idmedidas"));
                l.setIdherrajes(rs.getInt("idherraje"));
                l.setPrecio(rs.getDouble("precio"));
                mod.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (modelo)" + exception);
        }
        return mod;
    }
}

















