/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package widows;

import java.sql.*;
import class_systems.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class ManageEquipments extends javax.swing.JFrame {

    String user;
    public static int idEquipment_update;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form ManageCustomers
     */
    public ManageEquipments() {
        initComponents();
        user = Login.user;

        setSize(630, 380);
        setResizable(false);
        setTitle("Registered Customers - Session as " + user);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icon = new ImageIcon(wallpaper.getImage().getScaledInstance(
                jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(),
                Image.SCALE_DEFAULT)
        );
        jLabel_Wallpaper.setIcon(icon);
        this.repaint();

        try {
            Connection cn = Conexion.connect();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT id_equipment, equipment_type, brand, status FROM equipments"
            );
            ResultSet rs = pst.executeQuery();

            jTable_equipments = new JTable(model);
            jScrollPane_equipments.setViewportView(jTable_equipments);

            model.addColumn(" ");
            model.addColumn("Type");
            model.addColumn("Brand");
            model.addColumn("Status");

            while (rs.next()) {
                Object[] row = new Object[4];

                for (int i = 0; i < 4; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error filling out the table.");
        }
        getTableDates();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane_equipments = new javax.swing.JScrollPane();
        jTable_equipments = new javax.swing.JTable();
        cmb_status = new javax.swing.JComboBox<>();
        jButton_show = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipments Registered");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jTable_equipments.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_equipments.setViewportView(jTable_equipments);

        getContentPane().add(jScrollPane_equipments, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        cmb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "New Admission", "No Fixed", "In Review", "Fixed", "Delivered" }));
        getContentPane().add(cmb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 150, -1));

        jButton_show.setBackground(new java.awt.Color(153, 153, 255));
        jButton_show.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_show.setForeground(new java.awt.Color(255, 255, 255));
        jButton_show.setText("Show");
        jButton_show.setBorder(null);
        jButton_show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_showActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_showActionPerformed
        String selection = cmb_status.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);
        model.setColumnCount(0);

        try {
            Connection cn = Conexion.connect();

            if (selection.equalsIgnoreCase("All")) {
                query = "SELECT id_equipment, equipment_type, brand, status FROM equipments";
            } else {
                query = "SELECT id_equipment, equipment_type, brand, status FROM equipments WHERE status "
                        + "= '" + selection + "'";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            jTable_equipments = new JTable(model);
            jScrollPane_equipments.setViewportView(jTable_equipments);

            model.addColumn(" ");
            model.addColumn("Type");
            model.addColumn("Brand");
            model.addColumn("Status");

            while (rs.next()) {
                Object[] row = new Object[4];

                for (int i = 0; i < 4; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error when querying equipments. " + e);
        }

        getTableDates();
    }//GEN-LAST:event_jButton_showActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageEquipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageEquipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageEquipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageEquipments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageEquipments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_status;
    private javax.swing.JButton jButton_show;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JScrollPane jScrollPane_equipments;
    private javax.swing.JTable jTable_equipments;
    // End of variables declaration//GEN-END:variables

    public void getTableDates() {
        jTable_equipments.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int row_point = jTable_equipments.rowAtPoint(e.getPoint());
                int column_point = 0;

                if (row_point > -1) {
                    idEquipment_update = (int) (model.getValueAt(row_point, column_point));
                    EquipmentInformationTechnical equipmentInformationTechnical = new EquipmentInformationTechnical();
                    equipmentInformationTechnical.setVisible(true);
                }
            }
        });
    }
}
