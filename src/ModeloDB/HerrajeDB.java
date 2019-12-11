
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Herrajes;
import modelo.conectate;

/**
 *
 * @author Clog_10
 */
public class HerrajeDB {
        conectate con;

    public HerrajeDB() {
        con = new conectate();
    }
        
       public void ingresaDatosHerraje(Herrajes c) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO herraje (idherraje, tipo)"
                    + "VALUES(?,?)");
            pstm.setInt(1, c.getIdherraje());
            pstm.setString(2, c.getTipo());

            //int count = pstm.executeUpdate();
            //System.out.println("Se han insertado: " + count);
            pstm.close();

        } catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL HERRAJE");
        }
    }

    public void deleteHerraje(int cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from herraje where idherraje = ?");
            pstm.setInt(1, cod);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Object[][] getDatos() {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idherraje) as total FROM herraje ");
            try (ResultSet res = pstm.executeQuery()) {
                res.next();
                registros = res.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[][] data = new String[registros][2];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT "
                    + " idherraje, tipo"
                    + " FROM herraje"
                    + " ORDER BY idherraje ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String idherraje = res.getString("idherraje");
                String tipo = res.getString("tipo");
                data[i][0] = idherraje;
                data[i][1] = tipo;

                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void updateHerraje(int id, String tipo) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update herraje "
                    + "set idherraje = ? ,"
                    + "tipo = ? "
                    + "where idherraje = ? ");
            pstm.setInt(1, id);
            pstm.setString(2, tipo);
            pstm.setInt(3, id);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}









