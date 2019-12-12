
package modelo;

/**
 *
 * @author mac
 */

public class Medida {
    private int idmedida;
    private int ancho;
    private int alto;
    private int fondo;

    public Medida(int idmedida, int ancho, int alto, int fondo) {
        this.idmedida = idmedida;
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
    }

    public Medida() {
    }
    

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    @Override
    public String toString() {
        return "" + idmedida + "," + ancho + "," + alto + "," + fondo;
    }
    
    
    
}
