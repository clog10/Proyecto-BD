/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mac
 */
public class Productos {
    private int idproducto;
    private int idmodelo;
    private String descripcion;
    private double p_venta_publico;
    private int productos_disponibles;
    private int descuento;
    private int idstatus;
    

    public Productos() {
    }
    
    public Productos(int idproducto, int idmodelo, double p_venta_publico, 
                     String descripcion,int productos_disponibles, int descuento, int idstatus) {
        this.idproducto = idproducto;
        this.idmodelo = idmodelo;
        this.descripcion=descripcion;
        this.p_venta_publico = p_venta_publico;
        this.productos_disponibles = productos_disponibles;
        this.descuento = descuento;
        this.idstatus = idstatus;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    public double getP_venta_publico() {
        return p_venta_publico;
    }

    public void setP_venta_publico(double p_venta_publico) {
        this.p_venta_publico = p_venta_publico;
    }

    public int getProductos_disponibles() {
        return productos_disponibles;
    }

    public void setProductos_disponibles(int productos_disponibles) {
        this.productos_disponibles = productos_disponibles;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  "" + idproducto + "," + idmodelo + "," + descripcion + "," + p_venta_publico + "," + productos_disponibles + "," + descuento + "," + idstatus ;
    }
    
    
    
    
}
