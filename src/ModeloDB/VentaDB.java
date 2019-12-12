package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Clientes;
import modelo.conectate;
import modelo.Detalle_venta;
import modelo.Encabezado_venta;
import modelo.Productos;

/**
 *
 * @author Clog_10
 */
public class VentaDB {

    conectate con;

    public VentaDB() {
        con = new conectate();
    }

    public void ingresaDatosVenta(Encabezado_venta e) throws ParseException {
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date fe = null;
        java.sql.Date fecha2 = null;
        try {

            fe = fecha.parse(e.getFecha());
            fecha2 = new java.sql.Date(fe.getTime());

            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO encabezado_venta (idencabezado_venta, idcliente, fecha)"
                    + "VALUES(?,?,?)");
            pstm.setInt(1, e.getIdencabezado_venta());
            pstm.setInt(2, e.getIdcliente());
            pstm.setDate(3, fecha2);
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();

        } catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL Encabezado");
        }
    }

    public void ingresaDatosDetalle(Detalle_venta e) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO detalle_venta (iddetalle, costo_total, cantidadproductos,idencabezado,idproducto)"
                    + "VALUES(?,?,?,?,?)");
            pstm.setInt(1, e.getIddetalle());
           
            pstm.setDouble(2, e.getCosto_total());
            pstm.setInt(3, e.getCantidadproductos());
            pstm.setInt(4, e.getEncabezado()); 
            
             pstm.setInt(5, e.getIdproducto());
            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();

        } catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL detalle");
        }
    }

    public Object[][] getDatosEncabezado() {
        //DateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idencabezado_venta) as total FROM encabezado_venta ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][8];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("  select * from encabezado_venta,cliente where encabezado_venta.idcliente=cliente.idcliente; ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String idenc = res.getString("idencabezado_venta");
                String fecha = res.getDate("fecha").toString();
                data[i][0] = idenc;
                data[i][1] = fecha;
                String idcli = res.getString("idcliente");
                String nombre = res.getString("nombre");
                String ap1 = res.getString("ap1");
                String ap2 = res.getString("ap2");
                String rfc = res.getString("rfc");
                String correo = res.getString("correo");
                data[i][2] = idcli;
                data[i][3] = nombre;
                data[i][4] = ap1;
                data[i][5] = ap2;
                data[i][6] = rfc;
                data[i][7] = correo;

                i++;

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] getDatosDetalle() {
        //DateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");

        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(iddetalle) as total FROM detalle_venta ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][8];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement(" select * from detalle_venta, producto where detalle_venta.idproducto=producto.idproducto;  ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String idenc = res.getString("idencabezado");
                String detalle = res.getString("iddetalle");
                String producto = res.getString("idproducto");
                data[i][0] = idenc;
                data[i][1] = detalle;
                data[i][2] = producto;
                String desc = res.getString("descripcion");
                String precio = res.getString("p_venta_publico");
                String cant = res.getString("cantidadproductos");
                String costo = res.getString("costo_total");
                data[i][4] = desc;
                data[i][5] = precio;
                data[i][6] = cant;
                data[i][7] = costo;

                i++;

            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void updateVenta(String id, String nombre, String ap1, String ap2, String rfc, String correo) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update cliente "
                    + "set idcliente = ? ,"
                    + "nombre = ? ,"
                    + "ap1 = ? ,"
                    + "ap2 = ? "
                    + "rfc = ? "
                    + "correo = ? "
                    + "where idcliente = ? ");
            pstm.setString(1, id);
            pstm.setString(2, nombre);
            pstm.setString(3, ap1);
            pstm.setString(4, ap2);
            pstm.setString(5, rfc);
            pstm.setString(6, correo);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
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
    public void deleteVenta(int cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("DELETE en, det FROM encabezado_venta AS en INNER JOIN detalle_venta AS det WHERE det.iddetalle=en.detalle_venta AND en.idencabezado_venta = ?");
            pstm.setInt(1, cod);
            pstm.execute();
            pstm.close();
            System.out.println("Encabezado eliminado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    /*public void deleteDetalle(int cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from detalle_venta where iddetalle = ?");
            pstm.setInt(1, cod);
            pstm.execute();
            pstm.close();
                    System.out.println("detalle eliminado");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }*/

    public List<Clientes> listClientes() {

        List<Clientes> clientes = new ArrayList<Clientes>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from cliente;");
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
            System.err.println("Error al CARGAR DATOS (Cliente)" + exception);
        }
        return clientes;
    }
    
    public List<Productos> listProductos() {

        List<Productos> productos = new ArrayList<Productos>();

        try {
            PreparedStatement ps = con.getConnection().prepareStatement("Select * from producto;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Productos l= new Productos();
                l.setIdproducto(rs.getInt("idproducto"));
                l.setIdmodelo(rs.getInt("idmodelo"));
                l.setDescripcion(rs.getString("descripcion"));
                l.setP_venta_publico(rs.getDouble("p_venta_publico"));
                l.setProductos_disponibles(rs.getInt("productos_disponibles"));
                l.setDescuento(rs.getInt("descuento"));
                l.setIdstatus(rs.getInt("idstatus"));
                
                productos.add(l);
            }

        } catch (SQLException exception) {
            System.err.println("Error al CARGAR DATOS (Productos)" + exception);
        }
        return productos;
    }
}












