package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conectate;

/**
 * @author Clog_10
 */
public class Consultas {

    conectate con;

    public Consultas() {
        con = new conectate();
    }

    public String [] consulta1() {
        /*
        1.-Cuantas bolsas existen de color amarillo
	select c.idcolor as Id_Color, c.color, count(c.idcolor) as Cantidad_productos
	from colores c
    inner join modelo mo on c.idcolor=mo.idcolor
    group by c.idcolor
	having c.idcolor=1;
         */
        String[] data = new String[3];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " c.idcolor , c.color, count(c.idcolor) as Cantidad_productos" +
            " FROM colores c" +
            " inner join modelo mo on c.idcolor=mo.idcolor"+
            " group by c.idcolor having c.idcolor=2; ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idcolor = res.getString("c.idcolor");
            String color = res.getString("c.color");
            String count = res.getString("Cantidad_productos");
            data[0] = idcolor;            
            data[1] = color;
            data[2] = count;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta2() {
        /*
        2.-Cuantas bolsas disponibles hay
	select es.tipo as Estatus, count(p.idstatus) as Cantidad_disponibles
	from estatus es
	inner join producto p on es.idstatus=p.idstatus
	group by es.idstatus
	having es.tipo like 'disponible';
         */
        String[] data = new String[2];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " es.tipo as Estatus , count(p.idstatus) as Cantidad_disponibles" +
            " FROM estatus es" +
            " inner join producto p on es.idstatus=p.idstatus"+
            " group by es.idstatus having es.tipo like 'disponible'; ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idcolor = res.getString("Estatus");
            String color = res.getString("Cantidad_disponibles");
            data[0] = idcolor;            
            data[1] = color;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta3() {
        /*
        3.-El modelo de id 4 que medidas tiene 
	select m.idmodelo, me.ancho,me.alto, me.fondo 
	from modelo m
    inner join medidas me on m.idmedidas= me.idmedida
	group by m.idmodelo
	having m.idmodelo='4';
         */
        String[] data = new String[4];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            " m.idmodelo , me.ancho, me.alto, me.fondo" +
            " FROM modelo m" +
            " inner join medidas me on m.idmedidas= me.idmedida"+
            " group by m.idmodelo having m.idmodelo='4';");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idmodelo = res.getString("m.idmodelo");
            String ancho = res.getString("me.ancho");
            String alto = res.getString("me.alto");
            String fondo = res.getString("me.fondo");
            data[0] = idmodelo;            
            data[1] = ancho;
            data[2] = alto;
            data[3] = fondo;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta4() {
        /*
        4.- Cuales productos tiene material sintetico
proyectar el id del producto, idmodelo
	select ma.tipo as Tipo_Material, p.idproducto, p.idmodelo
    from producto p
    inner join modelo mo on p.idmodelo=mo.idmodelo
    inner join material ma on mo.idmaterial=ma.idmaterial
    group by p.idproducto, p.idmodelo
    having ma.tipo='sintetico';
         */
        String[] data = new String[3];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "ma.tipo as Tipo_Material, p.idproducto, p.idmodelo" +
            " FROM producto p" +
            " inner join modelo mo on p.idmodelo=mo.idmodelo"+
            " inner join material ma on mo.idmaterial=ma.idmaterial"+
            " group by p.idproducto, p.idmodelo having ma.tipo='sintetico';");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String tipoMate = res.getString("Tipo_Material");
            String idProduc = res.getString("p.idproducto");
            String idMode = res.getString("p.idmodelo");
            data[0] = tipoMate;            
            data[1] = idProduc;
            data[2] = idMode;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta5() {
        /*
        5.-Cual es la bolsa de menor precio  
proyectar idmodelo, precio 
    select idmodelo, precio    
    from modelo 
    order by precio asc
    limit 1;
         */
        String[] data = new String[2];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "idmodelo, precio" +
            " FROM modelo" +
            " order by precio asc"+
            " limit 1;");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idMod = res.getString("idmodelo");
            String Prrecio = res.getString("precio");
            data[0] = idMod;            
            data[1] = Prrecio;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta6() {
        /*
        6. cual es la bolsa con mayor precio 
proyectar los primeros 3

select idmodelo, precio    
    from modelo 
    order by precio desc
    limit 3;
         */
        String[] data = new String[2];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "idmodelo, precio" +
            " FROM modelo" +
            " order by precio desc"+
            " limit 1;");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idMod = res.getString("idmodelo");
            String Prrecio = res.getString("precio");
            data[0] = idMod;            
            data[1] = Prrecio;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta7() {
        /*
        7.- Cuantos productos compro el cliente carlos 
proyectar nombre, idcliente y cantidad  

select c.idcliente, c.nombre, c.ap1, c.ap2, sum(d.cantidadproductos)
from cliente c
inner join encabezado_venta en on c.idcliente=en.idcliente
inner join detalle_venta d on d.idencabezado =en.idencabezado_venta
group by c.idcliente, c.nombre, c.ap1, c.ap2
having c.nombre='Diana';
         */
        String[] data = new String[5];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "c.idcliente, c.nombre, c.ap1, c.ap2, sum(d.cantidadproductos) as cantidadproductos" +
            " FROM cliente c" +
            " inner join encabezado_venta en on c.idcliente=en.idcliente"+
            " inner join detalle_venta d on d.idencabezado =en.idencabezado_venta"+
            " group by c.idcliente, c.nombre, c.ap1, c.ap2"+
            " having c.nombre='Diana';");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idCli = res.getString("c.idcliente");
            String nombre = res.getString("c.nombre");
            String ap1 = res.getString("c.ap1");
            String ap2 = res.getString("c.ap2");
            String cant = res.getString("cantidadproductos");
            data[0] = idCli;            
            data[1] = nombre;
            data[2] = ap1;
            data[3] = ap2;
            data[4] = cant;
            i++;
            System.out.println("aqui ando");
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta8() {
        /*
        8.-cuantos productos tienen herraje de plata
proyectar el id modelo, tipo herraje, cantidad

select m.idmodelo, he.tipo as Tipo, count(m.idherraje) Cantidad_Herraje
from modelo m
inner join herraje he on m.idherraje=he.idherraje
group by m.idmodelo
having he.tipo='plata';
         */
        String[] data = new String[3];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "m.idmodelo, he.tipo as Tipo, count(m.idherraje) as Cantidad" +
            " FROM modelo m" +
            " inner join herraje he on m.idherraje=he.idherraje"+
            " group by m.idmodelo"+
            " having he.tipo='plata';");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idCli = res.getString("m.idmodelo");
            String nombre = res.getString("Tipo");
            String ap1 = res.getString("Cantidad");
            data[0] = idCli;            
            data[1] = nombre;
            data[2] = ap1;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta9() {
        /*
        9.- CUAL ES LA BOLSA MAS PEQUEÑA (ALTURA MAS PEQUEÑA) 
PROYECTAR EL ID DEL MODELO, MEDIDAS, ID ESTATUS
	select mo.idmodelo,me.ancho, me.alto, me.fondo, es.tipo
    from modelo mo
    inner join medidas me on mo.idmedidas=me.idmedida
    inner join producto pro on mo.idmodelo=pro.idmodelo
    inner join estatus es on pro.idstatus=es.idstatus
    order by  alto asc
    limit 1;    
         */
        String[] data = new String[5];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "mo.idmodelo, me.ancho, me.alto, me.fondo, es.tipo" +
            " FROM modelo mo" +
            " inner join medidas me on mo.idmedidas=me.idmedida"+
            " inner join producto pro on mo.idmodelo=pro.idmodelo"+
            " inner join estatus es on pro.idstatus=es.idstatus"+
            " order by  alto asc limit 1; ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idCli = res.getString("mo.idmodelo");
            String nombre = res.getString("me.ancho");
            String ap1 = res.getString("me.alto");
            String ap2 = res.getString("me.fondo");
            String cant = res.getString("es.tipo");
            data[0] = idCli;            
            data[1] = nombre;
            data[2] = ap1;
            data[3] = ap2;
            data[4] = cant;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

    public String[] consulta10() {
        /*
        10.- Cantidad de productos vendidos proyectar el estatus, la cantidad 

select es.tipo as Estatus, count(p.idstatus) as Cantidad
	from estatus es
	inner join producto p on es.idstatus=p.idstatus
	group by es.idstatus
	having es.tipo like 'vendido';
        
        select es.tipo as Estatus, sum(p.productos_disponibles) as Cantidad
	from estatus es
	inner join producto p on es.idstatus=p.idstatus
	group by es.tipo
	having es.tipo like 'disponible';
         */
        String[] data = new String[2];
        try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
            "es.tipo as Estatus, sum(p.productos_disponibles) as Cantidad" +
            " FROM estatus es" +
            " inner join producto p on es.idstatus=p.idstatus"+
            " group by es.tipo"+
            " having es.tipo like 'disponible'; ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String idCli = res.getString("Estatus");
            String nombre = res.getString("Cantidad");
            data[0] = idCli;            
            data[1] = nombre;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
    }

}

