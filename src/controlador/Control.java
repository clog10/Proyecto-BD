/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Clientes;
import modelo.conectate;

/**
 *
 * @author Roberto Carlos
 */
public class Control {
    conectate con;
    
    public Control(){
        con = new conectate();
    }
    
    public void ingresaDatosCliente(Clientes c){
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
   /* public void NuevoCliente(int idcliente, String nombre, String apellido1, String apellido2, String rfc, String correo){
       try {            
           try (PreparedStatement pstm = con.getConnection().prepareStatement("insert into " + 
                        "cliente(idcliente, nombre, ap1, ap2, rfc, correo) " +
                        " values(?,?,?,?,?,?)")) {
               pstm.setInt(1, idcliente);
               pstm.setString(2, nombre);
               pstm.setString(3, apellido1);
               pstm.setString(4, apellido2);                        
               pstm.setString(5, rfc);      
               pstm.setString(6, correo); 
               pstm.execute();
           }            
         }catch(SQLException e){
         System.out.println(e);
      }
   }*/
    
    
    public Object [][] getDatos(){
      int registros = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idcliente) as total FROM cliente ");
          try (ResultSet res = pstm.executeQuery()) {
              res.next();
              registros = res.getInt("total");
          }
      }catch(SQLException e){
         System.out.println(e);
      }    
       
      Object[][] data = new String[registros][6];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " idcliente, nombre, ap1, ap2, rfc, correo" +
            " FROM cliente" +
            " ORDER BY idcliente ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idcli = res.getString("idcliente");
            String nom = res.getString("nombre");
            String ap1 = res.getString("ap1");
            String ap2 = res.getString("ap2");
            String rfc = res.getString("rfc");
            String corre = res.getString("correo");
            data[i][0] = idcli;            
            data[i][1] = nom;            
            data[i][2] = ap1;            
            data[i][3] = ap2;  
            data[i][4] = rfc; 
            data[i][5] = corre; 
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
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







