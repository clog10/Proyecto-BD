
package modelo;

/**
 * @author mac
 */

public class Estatus {
    private int idstatus;
    private String tipo;

    public Estatus(int idstatus, String tipo) {
        this.idstatus = idstatus;
        this.tipo = tipo;
    }

    public Estatus() {
    }

    
    
    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "" + idstatus + "," + tipo;
    }
    
    
    
}
