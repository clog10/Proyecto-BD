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
public class Herraje {
    private int idherraje;
    private String tipo;

    public Herraje(int idherraje, String tipo) {
        this.idherraje = idherraje;
        this.tipo = tipo;
    }

    public int getIdherraje() {
        return idherraje;
    }

    public void setIdherraje(int idherraje) {
        this.idherraje = idherraje;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
