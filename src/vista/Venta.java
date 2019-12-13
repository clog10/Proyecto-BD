package vista;

import com.jtattoo.plaf.fast.FastLookAndFeel;
import java.util.Properties;
import javax.swing.UIManager;
import ModeloDB.VentaDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.Detalle_venta;
import modelo.Encabezado_venta;
import modelo.Productos;

/**
 * @author Clog_10
 */

public class Venta extends javax.swing.JFrame {

    VentaDB vvv;
    Encabezado_venta enc;
    Detalle_venta dv;

    Object[][] dtPer;
    Object[][] dtPer2;
    int fila = -1;
   // int fila2=-1;

    public Venta() {
        initComponents();
        vvv = new VentaDB();
        updateTablaEncabezado();
        updateTablaDetalle();
        cargaCombo();
        cargaCombo2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIDVENTA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCOSTO = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCANTPRODUCT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIDDETALLE = new javax.swing.JTextField();
        jButtonEliminar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jButtonModificar = new javax.swing.JButton();
        jButtonAgregar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDESCRIP = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCOSTTOTAL = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta"));

        jLabel1.setText("idventa");

        jLabel2.setText("Productos");

        jLabel3.setText("Costo");

        jTextFieldCOSTO.setEditable(false);

        jLabel4.setText("Cantidad de Productos");

        jLabel6.setText("Cliente");

        jLabel7.setText("fecha");

        jLabel8.setText("id detalle");

        jButtonEliminar.setText("Eliminar Detalle");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel9.setText("Descripción");

        jTextFieldDESCRIP.setEditable(false);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Costo total");

        jTextFieldCOSTTOTAL.setEditable(false);

        jButton1.setText("Elimina Encabezado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonModificar)
                .addGap(156, 156, 156)
                .addComponent(jButtonEliminar)
                .addGap(131, 131, 131)
                .addComponent(jButton1)
                .addGap(174, 174, 174))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldIDVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(59, 59, 59)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldCOSTO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(jButtonAgregar))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDESCRIP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(jTextFieldIDDETALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(38, 38, 38)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(28, 28, 28)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCOSTTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTextFieldCANTPRODUCT, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldIDVENTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldCANTPRODUCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldCOSTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldIDDETALLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCOSTTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldDESCRIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        if (fila > -1) {
            //int codigo = String.valueOf(jTable1.getValueAt(fila, 0));    
            System.out.println("dentro");
            int id = Integer.parseInt((String) jTable2.getValueAt(fila, 1));
           // int detalle = Integer.parseInt((String) jTable1.getValueAt(fila, 2));
            vvv.deleteVenta(id);
            //vvv.deleteDetalle(detalle);
            updateTablaEncabezado();
            updateTablaDetalle();
            fila = -1;
        }

    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here: 274 111 9613
        int idproducto = 0;
        int idcliente = 0;
        double costoTotal = 0;
        String descripcion = "";
        double costo = 0.0;
        int venta = Integer.parseInt(jTextFieldIDVENTA.getText());
        //double costo=Double.parseDouble(jTextField3.getText());
        int cantidad = Integer.parseInt(jTextFieldCANTPRODUCT.getText());

        int detalle = Integer.parseInt(jTextFieldIDDETALLE.getText());
        SimpleDateFormat da = new SimpleDateFormat("dd-MM-yyyy");
        String d = da.format(jDateChooser1.getDate());
        String prr = (String) jComboBox2.getSelectedItem();
        String[] textElements = prr.split(",");
        for (int i = 0; i < textElements.length; i++) {
            idproducto = Integer.parseInt(textElements[0]);

        }
        String prr2 = (String) jComboBox1.getSelectedItem();
        String[] textElements2 = prr2.split(",");
        for (int i = 0; i < textElements2.length; i++) {
            idcliente = Integer.parseInt(textElements2[0]);
        }
        costo = Double.parseDouble(jTextFieldCOSTO.getText());
        costoTotal = costo * cantidad;
        enc = new Encabezado_venta(venta, idcliente, d);
        dv = new Detalle_venta(detalle, costoTotal, cantidad,venta,idproducto);

        try {
            this.vvv.ingresaDatosVenta(enc);
            this.vvv.ingresaDatosDetalle(dv);
        } catch (ParseException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateTablaDetalle();
        updateTablaEncabezado();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        int idproducto = 0;
        String descripcion = "";
        double costo = 0.0;
        try {
            int cantidad = Integer.parseInt(jTextFieldCANTPRODUCT.getText());
            String prr = (String) jComboBox2.getSelectedItem();
            String[] textElements = prr.split(",");
            for (int i = 0; i < textElements.length; i++) {
                idproducto = Integer.parseInt(textElements[0]);
                descripcion = textElements[2];
                costo = Double.parseDouble(textElements[3]);
                
            }
            jTextFieldDESCRIP.setText(descripcion);
            double costoTotal = costo * cantidad;
            jTextFieldCOSTO.setText("" + costo);
            jTextFieldCOSTTOTAL.setText("" + costoTotal);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        
        double costo = 0.0;
        double costoTotal = 0.0;
        int idproducto = 0;
        int detalle = Integer.parseInt(jTextFieldIDDETALLE.getText());
        int cantidad = Integer.parseInt(jTextFieldCANTPRODUCT.getText());
        costo = Double.parseDouble(jTextFieldCOSTO.getText());
        costoTotal = costo * cantidad;
        int venta = Integer.parseInt(jTextFieldIDVENTA.getText());
        String prr = (String) jComboBox2.getSelectedItem();
        String[] textElements = prr.split(",");
        for (int i = 0; i < textElements.length; i++) {
            idproducto = Integer.parseInt(textElements[0]);

        }
        vvv.updateVenta(detalle, costoTotal, cantidad,venta,idproducto);
        updateTablaDetalle();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fila = jTable1.rowAtPoint(evt.getPoint());                 
        if (fila > -1){                          
             jTextFieldIDVENTA.setText(String.valueOf(jTable1.getValueAt(fila, 0)));
             jDateChooser1.setDateFormatString(String.valueOf(jTable1.getValueAt(fila, 1)));
             jTextFieldCANTPRODUCT.setText(String.valueOf(jTable2.getValueAt(fila, 5)));
             jTextFieldCOSTO.setText(String.valueOf(jTable2.getValueAt(fila, 4)));
             jTextFieldDESCRIP.setText(String.valueOf(jTable2.getValueAt(fila, 3)));
             jTextFieldIDDETALLE.setText(String.valueOf(jTable2.getValueAt(fila, 1)));
             jTextFieldCOSTTOTAL.setText(String.valueOf(jTable2.getValueAt(fila, 6)));
         }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        fila = jTable2.rowAtPoint(evt.getPoint()); 
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if (fila > -1) {
            //int codigo = String.valueOf(jTable1.getValueAt(fila, 0));    
            System.out.println("dentro");
            int id = Integer.parseInt((String) jTable1.getValueAt(fila, 0));
           // int detalle = Integer.parseInt((String) jTable1.getValueAt(fila, 2));
            vvv.deleteEncabezado(id);
            //vvv.deleteDetalle(detalle);
            updateTablaEncabezado();
            updateTablaDetalle();
            fila = -1;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargaCombo() {
        ArrayList<Clientes> c = (ArrayList<Clientes>) vvv.listClientes();
        for (Clientes ccc : c) {
            jComboBox1.addItem(ccc.toString());
        }
    }

    public void cargaCombo2() {
        ArrayList<Productos> c = (ArrayList<Productos>) vvv.listProductos();
        for (Productos ccc : c) {
            jComboBox2.addItem(ccc.toString());
        }
    }

    private void updateTablaEncabezado() {
        String[] columNames = {"id Encabezado", "Fecha", "id Cliente","nombre","apellido 1","apellido 2","rfc","correo"};
        // se utiliza la funcion
        dtPer = vvv.getDatosEncabezado();
        //System.out.println(vvv.getDatosEncabezado());
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtPer, columNames);
        jTable1.setModel(datos);
    }
    
    private void updateTablaDetalle() {
        String[] columNames = {"id Encabezado", "id Detalle", "id Producto", "Descripcion", "Precio producto", "Cantidad de Productos", "Costo total"};
        // se utiliza la funcion
        dtPer2 = vvv.getDatosDetalle();
        //System.out.println(vvv.getDatos());
        // se colocan los datos en la tabla
        DefaultTableModel datos = new DefaultTableModel(dtPer2, columNames);
        jTable2.setModel(datos);
    }

    public static void main(String args[]) {
        try {
            Properties props = new Properties();
            FastLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (Exception e) {

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextFieldCANTPRODUCT;
    private javax.swing.JTextField jTextFieldCOSTO;
    private javax.swing.JTextField jTextFieldCOSTTOTAL;
    private javax.swing.JTextField jTextFieldDESCRIP;
    private javax.swing.JTextField jTextFieldIDDETALLE;
    private javax.swing.JTextField jTextFieldIDVENTA;
    // End of variables declaration//GEN-END:variables
}
