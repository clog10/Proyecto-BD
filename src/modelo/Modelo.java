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
public class Modelo {
    private int idmodelo;
    private String imagen;
    private int idcolor;
    private int idmaterial;
    private int idmedidas;
    private int idherrajes;
    private double precio;

    public Modelo(int idmodelo, String imagen, int idcolor, int idmaterial, int idmedidas, int idherrajes, double precio) {
        this.idmodelo = idmodelo;
        this.imagen = imagen;
        this.idcolor = idcolor;
        this.idmaterial = idmaterial;
        this.idmedidas = idmedidas;
        this.idherrajes = idherrajes;
        this.precio = precio;
    }

    public int getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(int idmodelo) {
        this.idmodelo = idmodelo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public int getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(int idmaterial) {
        this.idmaterial = idmaterial;
    }

    public int getIdmedidas() {
        return idmedidas;
    }

    public void setIdmedidas(int idmedidas) {
        this.idmedidas = idmedidas;
    }

    public int getIdherrajes() {
        return idherrajes;
    }

    public void setIdherrajes(int idherrajes) {
        this.idherrajes = idherrajes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
