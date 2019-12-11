
package ModeloDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estatus;
import modelo.conectate;

/**
 *
 * @author Clog_10
 */
public class EstatusDB {
        conectate con;

    public EstatusDB() {
        con = new conectate();
    }
        
      public void ingresaDatosEstatus(Estatus c) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO estatus (idstatus, tipo)"
                    + "VALUES(?,?)");
            pstm.setInt(1, c.getIdstatus());
            pstm.setString(2, c.getTipo());

            //int count = pstm.executeUpdate();
            //System.out.println("Se han insertado: " + count);
            pstm.close();

        } catch (Exception ex) {
            System.out.println("ERROR AL INTRODUCIR DATOS DEL Estatus");
        }
    }

    public void deleteStatus(int cod) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("delete from estatus where idstatus = ?");
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
            PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(idstatus) as total FROM estatus ");
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
                    + " idstatus, tipo"
                    + " FROM estatus"
                    + " ORDER BY idstatus ");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                String idstatus = res.getString("idstatus");
                String tipo = res.getString("tipo");
                data[i][0] = idstatus;
                data[i][1] = tipo;

                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public void updateStatus(int id, String status) {
        try {
            PreparedStatement pstm = con.getConnection().prepareStatement("update estatus "
                    + "set idstatus = ? ,"
                    + "tipo = ? ,"
                    + "where idstatus = ? ");
            pstm.setInt(1, id);
            pstm.setString(2, status);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}














