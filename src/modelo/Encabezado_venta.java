/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;


/**
 *
 * @author mac
 */
public class Encabezado_venta {
    private int idencabezado_venta;
    private int idcliente;
    private Date fecha;
    private int detalle_venta;

    public Encabezado_venta(int idencabezado_venta, int idcliente, Date fecha, int detalle_venta) {
        this.idencabezado_venta = idencabezado_venta;
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.detalle_venta = detalle_venta;
    }

    public int getIdencabezado_venta() {
        return idencabezado_venta;
    }

    public void setIdencabezado_venta(int idencabezado_venta) {
        this.idencabezado_venta = idencabezado_venta;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDetalle_venta() {
        return detalle_venta;
    }

    public void setDetalle_venta(int detalle_venta) {
        this.detalle_venta = detalle_venta;
    }
    
}
