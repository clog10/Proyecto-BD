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
public class Color {
    private int idcolor;
    private String color;

    public Color(int idcolor, String color) {
        this.idcolor = idcolor;
        this.color = color;
    }

    public Color() {
    }

    
   
    public int getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(int idcolor) {
        this.idcolor = idcolor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  "" + idcolor + "," + color;
    }
    
    
    
}
