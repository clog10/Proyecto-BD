package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Color;
import modelo.conectate;

/**
 * @author Clog_10
 */
public class ColoresDB {

    conectate con;

    public ColoresDB() {
        con = new conectate();
    }

    public void ingresaDatosColor(Color c) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO colores (idcolor, color)"
                    + "VALUES(?,?)");
            pstm.setInt(1, c.getIdcolor());
            pstm.setString(2, c.getColor());

            int count = pstm.executeUpdate();
            System.out.println("Se han insertado: " + count);
            pstm.close();

        } catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL COLOR");
        }
    }

    public void deleteColor(int cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from colores where idcolor = ?");
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
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idcolor) as total FROM colores ");
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
                    + " idcolor, color"
                    + " FROM colores"
                    + " ORDER BY idcolor ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String idcolor = res.getString("idcolor");
                String color = res.getString("color");
                data[i][0] = idcolor;
                data[i][1] = color;

                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void updateColor(int id, String color) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update colores "
                    + "set idcolor = ? ,"
                    + "color = ? "
                    + "where idcolor = ? ");
            pstm.setInt(1, id);
            pstm.setString(2, color);
            pstm.setInt(3, id);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}





