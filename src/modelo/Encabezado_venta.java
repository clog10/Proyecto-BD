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
    private String fecha;

    public Encabezado_venta(int idencabezado_venta, int idcliente, String fecha) {
        this.idencabezado_venta = idencabezado_venta;
        this.idcliente = idcliente;
        this.fecha = fecha;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
 
}
