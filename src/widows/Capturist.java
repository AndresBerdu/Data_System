/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package widows;

import java.sql.*;
import class_systems.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author andre
 */
public class Capturist extends javax.swing.JFrame {

    String user;
    String user_name;
    int session_user;

    /**
     * Creates new form Capturist
     */
    public Capturist() {
        initComponents();
        user = Login.user;
        session_user = Admin.session_user;

        setSize(550, 300);
        setResizable(false);
        setTitle("Capturist - Session as " + user);
        setLocationRelativeTo(null);

        if (session_user == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

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
                    "SELECT user_name FROM users WHERE username = '" + user + "'"
            );
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                user_name = rs.getString("user_name");
                jLabel1_username.setText("Welcome " + user_name);
            }
        } catch (SQLException e) {
            System.err.println("Error in querying the name of the capturista. " + e);
        }
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

        jLabel1_username = new javax.swing.JLabel();
        jButton_RegisterCustomer = new javax.swing.JButton();
        jButton_ManageCustomer = new javax.swing.JButton();
        jButton_Print = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1_username.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1_username.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1_username.setText("jLabel1");
        getContentPane().add(jLabel1_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_RegisterCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jButton_RegisterCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegisterCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegisterCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_ManageCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        jButton_ManageCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ManageCustomerActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ManageCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jButton_Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        getContentPane().add(jButton_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Register Customer");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 120, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Customers");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 120, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Print Cutomers");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 120, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegisterCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterCustomerActionPerformed
        RegisterCustomers registerCustomers = new RegisterCustomers();
        registerCustomers.setVisible(true);
    }//GEN-LAST:event_jButton_RegisterCustomerActionPerformed

    private void jButton_ManageCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ManageCustomerActionPerformed
       ManageCustomers manageCustomers = new ManageCustomers();
       manageCustomers.setVisible(true);
    }//GEN-LAST:event_jButton_ManageCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(Capturist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ManageCustomer;
    private javax.swing.JButton jButton_Print;
    private javax.swing.JButton jButton_RegisterCustomer;
    private javax.swing.JLabel jLabel1_username;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
