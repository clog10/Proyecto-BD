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

    public void consulta1() {
        /*
        1.-Cuantas bolsas existen de color amarillo
	select c.idcolor as Id_Color, c.color, count(c.idcolor) as Cantidad_productos
	from colores c
    inner join modelo mo on c.idcolor=mo.idcolor
    group by c.idcolor
	having c.idcolor=1;
         */
    }

    public void consulta2() {
        /*
        2.-Cuantas bolsas disponibles hay
	select es.tipo as Estatus, count(p.idstatus) as Cantidad_disponibles
	from estatus es
	inner join producto p on es.idstatus=p.idstatus
	group by es.idstatus
	having es.tipo like 'disponible';
         */
    }

    public void consulta3() {
        /*
        3.-El modelo de id 4 que medidas tiene 
	select m.idmodelo, me.ancho,me.alto, me.fondo 
	from modelo m
    inner join medidas me on m.idmedidas= me.idmedida
	group by m.idmodelo
	having m.idmodelo='4';
         */
    }

    public void consulta4() {
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
    }

    public void consulta5() {
        /*
        5.-Cual es la bolsa de menor precio  
proyectar idmodelo, precio 
    select idmodelo, precio    
    from modelo 
    order by precio asc
    limit 1;
         */
    }

    public void consulta6() {
        /*
        6. cual es la bolsa con mayor precio 
proyectar los primeros 3

select idmodelo, precio    
    from modelo 
    order by precio desc
    limit 3;
         */
    }

    public void consulta7() {
        /*
        7.- Cuantos productos compro el cliente carlos 
proyectar nombre, idcliente y cantidad  

select c.idcliente, c.nombre, c.ap1, c.ap2, d.cantidadproductos
from cliente c
inner join encabezado_venta en on c.idcliente=en.idcliente
inner join detalle_venta d on en.detalle_venta =d.iddetalle
group by c.idcliente, c.nombre, c.ap1, c.ap2, d.cantidadproductos
having c.nombre='carlos';
         */
    }

    public void consulta8() {
        /*
        8.-cuantos productos tienen herraje de plata
proyectar el id modelo, tipo herraje, cantidad

select m.idmodelo, he.tipo as Tipo, count(m.idherraje) Cantidad_Herraje
from modelo m
inner join herraje he on m.idherraje=he.idherraje
group by m.idmodelo
having he.tipo='plata';
         */
    }

    public void consulta9() {
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
    }

    public void consulta10() {
        /*
        10.- Cantidad de productos vendidos proyectar el estatus, la cantidad 

select es.tipo as Estatus, count(p.idstatus) as Cantidad
	from estatus es
	inner join producto p on es.idstatus=p.idstatus
	group by es.idstatus
	having es.tipo like 'vendido';
         */
    }

}

