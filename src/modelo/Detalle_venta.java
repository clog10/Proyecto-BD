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
public class Detalle_venta {
    private int iddetalle;
    private int idproducto;
    private double costo_total;
    private int cantidadproductos;
    private int encabezado;

    public Detalle_venta(int iddetalle, double costo_total, int cantidadproductos,int encabezado, int idproducto) {
        this.iddetalle = iddetalle;
        this.idproducto = idproducto;
        this.costo_total = costo_total;
        this.cantidadproductos = cantidadproductos;
        this.encabezado=encabezado;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    public int getCantidadproductos() {
        return cantidadproductos;
    }

    public void setCantidadproductos(int cantidadproductos) {
        this.cantidadproductos = cantidadproductos;
    }

    public int getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(int encabezado) {
        this.encabezado = encabezado;
    }
    
    
}
