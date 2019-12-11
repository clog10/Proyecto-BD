
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Clientes;
import modelo.conectate;
import modelo.Detalle_venta;
import modelo.Encabezado_venta;
/**
 *
 * @author Clog_10
 */
public class VentaDB {
 conectate con;

    public VentaDB() {
        con = new conectate();
    }
    
        /* public void ingresaDatosCliente(Detalle_venta c,Encabezado_venta e){
            try{
                PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO cliente (idcliente, nombre, ap1, ap2, rfc, correo)"
                        + "VALUES(?,?,?,?,?,?)");
                pstm.setInt(1, c.getIdcliente());
                pstm.setString(2, c.getNombre());
                pstm.setString(3, c.getApellido1());
                pstm.setString(4, c.getApellido2());
                pstm.setString(5, c.getRfc());
                pstm.setString(6, c.getCorreo());
                int count = pstm.executeUpdate();
                System.out.println("Se han insertado: " + count);
                pstm.close();

            }catch (Exception ex) {
                System.out.println("ERROR AL INTRODUCIR DATOS DEL CLIENTE");
            }
        }

     /*   
    public void deleteCliente(int cod){  
                try {                
                    PreparedStatement pstm = con.getConnection().prepareStatement("delete from cliente where idcliente = ?");            
                    pstm.setInt(1, cod);                   
                    pstm.execute();
                    pstm.close();            
                }catch(SQLException e){
                System.out.println(e);
                }            
       }

        */

        public Object [][] getDatos(){
            //DateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");

          int registros = 0;
          //obtenemos la cantidad de registros existentes en la tabla
          try{         
             PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idencabezado_venta) as total FROM encabezado_venta ");
              try (ResultSet res = pstm.executeQuery()) {
                  res.next();
                  registros = res.getInt("total");
              }
          }catch(SQLException e){
             System.out.println(e);
          }    

          Object[][] data = new String[registros][12];  
        //realizamos la consulta sql y llenamos los datos en "Object"
          try{    
             PreparedStatement pstm = con.getConnection().prepareStatement("    select * from proyectotbase.encabezado_venta,proyectotbase.detalle_venta,proyectotbase.cliente where encabezado_venta.detalle_venta=detalle_venta.iddetalle &&\n" +
"			proyectotbase.encabezado_venta.idcliente=proyectotbase.cliente.idcliente; ");
             ResultSet res = pstm.executeQuery();
             int i = 0;
             while(res.next()){
                String idenc = res.getString("idencabezado_venta");
                String fecha = res.getDate("fecha").toString();
                String detalle = res.getString("detalle_venta");
                data[i][0] = idenc;                       
                data[i][1] = fecha;            
                data[i][2] = detalle; 
                  String idproducto=res.getString("idproducto");
                   String costo=res.getString("costo_total");
                    String cant=res.getString("cantidadproductos");            
                data[i][3] = idproducto;            
                data[i][4] = costo;            
                data[i][5] = cant; 
                
                String idcli=res.getString("idcliente");
                String nombre=res.getString("nombre");
                String ap1= res.getString("ap1");
                String ap2=res.getString("ap2");
                String rfc=res.getString("rfc");
                String correo=res.getString("correo");
                data[i][6] = idcli;            
                data[i][7] = nombre;            
                data[i][8] = ap1; 
                data[i][9] = ap2;            
                data[i][10] = rfc;            
                data[i][11] = correo; 
                
               i++;

             }
             res.close();
              }catch(SQLException e){
             System.out.println(e);
        }
        return data;
     }

        public void updateCliente(String id,String nombre, String ap1, String ap2, String rfc,String correo){
           try {            
                PreparedStatement pstm = con.getConnection().prepareStatement("update cliente " +
                "set idcliente = ? ," +
                "nombre = ? ," +
                "ap1 = ? ," +                    
                "ap2 = ? " +   
                "rfc = ? " +   
                "correo = ? " +   
                "where idcliente = ? ");            
                pstm.setString(1, id);
                pstm.setString(2, nombre);
                pstm.setString(3, ap1);
                pstm.setString(4, ap2);
                pstm.setString(5, rfc);
                pstm.setString(6, correo);
                pstm.execute();
                pstm.close();            
             }catch(SQLException e){
             System.out.println(e);
          }
       }
        /*consultas 
        select * from proyectotbase.encabezado_venta,proyectotbase.detalle_venta,proyectotbase.cliente,proyectotbase.producto
    where encabezado_venta.detalle_venta=detalle_venta.iddetalle &&
			proyectotbase.encabezado_venta.idcliente=proyectotbase.cliente.idcliente&&
            proyectotbase.detalle_venta.idproducto=proyectotbase.producto.idproducto;
    
    delete encabezado_venta,detalle_venta from encabezado_venta
    join encabezado_venta on encabezado_venta.detalle_venta= detalle_venta.iddetalle
    where encabezado_venta.detalle_venta=9;*/

        public void deleteVenta(int cod){  
                try {                
                    PreparedStatement pstm = con.getConnection().prepareStatement("delete from encabezado_venta,detalle_venta where detalle_venta,detalleventa.iddetalle=?");            
                    pstm.setInt(1, cod);                   
                    pstm.execute();
                    pstm.close();            
                }catch(SQLException e){
                System.out.println(e);
                }            
       }
        
        public List<Clientes> listClientes() {

        String consultaSQL="Select * from cliente;";
        
        List<Clientes> clientes = new ArrayList<Clientes>();

        try {
          PreparedStatement  ps = con.getConnection().prepareStatement("Select * from cliente;");
          ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Clientes l = new Clientes();
                l.setIdcliente(rs.getInt("idcliente"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido1(rs.getString("ap1"));
                l.setApellido2(rs.getString("ap2"));
                l.setRfc(rs.getString("rfc"));
                l.setCorreo(rs.getString("correo"));
                clientes.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (Libro)" + exception);
        }
        return clientes;
    }
}






