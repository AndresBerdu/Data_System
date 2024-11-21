/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package widows;

import java.sql.*;
import class_systems.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author andre
 */
public class RegisterEquipment extends javax.swing.JFrame {

    int idCustomer_update = 0;
    String user = "";
    String nameCustomer = "";

    /**
     * Creates new form RegisterEquipment
     */
    public RegisterEquipment() {
        initComponents();
        user = Login.user;
        idCustomer_update = ManageCustomers.idCliente_update;

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
                    "SELECT customer_name FROM customers WHERE id_customer = '" + idCustomer_update + "'"
            );
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nameCustomer = rs.getString("customer_name");
            }
        } catch (SQLException e) {
            System.err.println("Error querying customer " + e);
        }

        setSize(630, 445);
        setResizable(false);
        setTitle("Registere new equipment as " + nameCustomer);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        txt_customerName.setText(nameCustomer);
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

        jLabel_title = new javax.swing.JLabel();
        jLabel_name = new javax.swing.JLabel();
        jLabel_name1 = new javax.swing.JLabel();
        jLabel_name2 = new javax.swing.JLabel();
        jLabel_name3 = new javax.swing.JLabel();
        jLabel_name4 = new javax.swing.JLabel();
        jLabel_name5 = new javax.swing.JLabel();
        txt_customerName = new javax.swing.JTextField();
        txt_model = new javax.swing.JTextField();
        txt_numberSerie = new javax.swing.JTextField();
        cmb_typeEquipment = new javax.swing.JComboBox<>();
        cmb_brands = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_Observations = new javax.swing.JTextPane();
        jButton_Register = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("Register Equipment");
        getContentPane().add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name.setText("Customer Name:");
        getContentPane().add(jLabel_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_name1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name1.setText("Type Equipment:");
        getContentPane().add(jLabel_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_name2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name2.setText("Brand:");
        getContentPane().add(jLabel_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_name3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name3.setText("Model:");
        getContentPane().add(jLabel_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_name4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name4.setText("Number Serie:");
        getContentPane().add(jLabel_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_name5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name5.setText("Report Damage:");
        getContentPane().add(jLabel_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txt_customerName.setBackground(new java.awt.Color(153, 153, 255));
        txt_customerName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_customerName.setForeground(new java.awt.Color(255, 255, 255));
        txt_customerName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_customerName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_model.setBackground(new java.awt.Color(153, 153, 255));
        txt_model.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_model.setForeground(new java.awt.Color(255, 255, 255));
        txt_model.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_model.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_numberSerie.setBackground(new java.awt.Color(153, 153, 255));
        txt_numberSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_numberSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_numberSerie.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_numberSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numberSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        cmb_typeEquipment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Print", "Multifunction" }));
        getContentPane().add(cmb_typeEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        cmb_brands.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "AlienWare", "Apple", "Asus", "Brother", "Dell", "HP", "Lenovo" }));
        getContentPane().add(cmb_brands, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 210, -1));

        jScrollPane1.setViewportView(jTextPane_Observations);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

        jButton_Register.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Register.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Register.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Register.setText("Register Equipment");
        jButton_Register.setBorder(null);
        jButton_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterActionPerformed

    }//GEN-LAST:event_jButton_RegisterActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_brands;
    private javax.swing.JComboBox<String> cmb_typeEquipment;
    private javax.swing.JButton jButton_Register;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_name1;
    private javax.swing.JLabel jLabel_name2;
    private javax.swing.JLabel jLabel_name3;
    private javax.swing.JLabel jLabel_name4;
    private javax.swing.JLabel jLabel_name5;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane_Observations;
    private javax.swing.JTextField txt_customerName;
    private javax.swing.JTextField txt_model;
    private javax.swing.JTextField txt_numberSerie;
    // End of variables declaration//GEN-END:variables
}