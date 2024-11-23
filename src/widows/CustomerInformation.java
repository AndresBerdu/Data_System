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
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class CustomerInformation extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    int idCliente_Update = 0;
    public static int id_equipment = 0;
    String user = "";

    /**
     * Creates new form CustomerInformation
     */
    public CustomerInformation() {
        initComponents();
        user = Login.user;
        idCliente_Update = ManageCustomers.idCliente_update;

        setSize(630, 450);
        setResizable(false);
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
                    "SELECT * FROM customers WHERE id_customer = '" + idCliente_Update + "'"
            );
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                setTitle("Customer Informatio " + rs.getString("customer_name") + " - Session as " + user);
                jLabel_title.setText("Customer Information " + rs.getString("customer_name"));

                txt_name.setText(rs.getString("customer_name"));
                txt_email.setText(rs.getString("customer_email"));
                txt_phone.setText(rs.getString("customer_phone"));
                txt_address.setText(rs.getString("customer_address"));
                txt_lastModify.setText(rs.getString("last_modify"));
            }

            cn.close();
        } catch (SQLException e) {
            System.err.println("Error loading user " + e);
            JOptionPane.showInternalMessageDialog(null, "Error loading user, contact admin.");
        }

        try {
            Connection cn = Conexion.connect();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT id_equipment, equipment_type, brand, status FROM equipments "
                    + "WHERE id_customer = '" + idCliente_Update + "'"
            );
            ResultSet rs = pst.executeQuery();

            jTable_equipment = new JTable(model);
            jScrollPane_equipment.setViewportView(jTable_equipment);

            model.addColumn("ID Equipment");
            model.addColumn("Type Equipment");
            model.addColumn("Brand Equipment");
            model.addColumn("Status Equipment");

            while (rs.next()) {
                Object[] row = new Object[4];

                for (int i = 0; i < 4; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);

            }
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error when filling the equipment table." + e);
        }

        jTable_equipment.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int row_point = jTable_equipment.rowAtPoint(e.getPoint());
                int column_point = 0;

                if (row_point > -1) {
                    id_equipment = (int) (model.getValueAt(row_point, column_point));
                    EquipmentInformation equipmentInformation = new EquipmentInformation();
                    equipmentInformation.setVisible(true);
                }
            }
        });
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

        jScrollPane_equipment = new javax.swing.JScrollPane();
        jTable_equipment = new javax.swing.JTable();
        jLabel_title = new javax.swing.JLabel();
        jLabel_name = new javax.swing.JLabel();
        jLabel_email = new javax.swing.JLabel();
        jLabel_phone = new javax.swing.JLabel();
        jLabel_address = new javax.swing.JLabel();
        jLabel_lastModify = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        txt_lastModify = new javax.swing.JTextField();
        jButton_Register = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_PrintReport = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_equipment.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_equipment.setViewportView(jTable_equipment);

        getContentPane().add(jScrollPane_equipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        jLabel_title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("Customer Information");
        getContentPane().add(jLabel_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_name.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_name.setText("Name:");
        getContentPane().add(jLabel_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_email.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_email.setText("Email:");
        getContentPane().add(jLabel_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_phone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_phone.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_phone.setText("Name:");
        getContentPane().add(jLabel_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_address.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_address.setText("Address:");
        getContentPane().add(jLabel_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_lastModify.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel_lastModify.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_lastModify.setText("Last Modify By:");
        getContentPane().add(jLabel_lastModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txt_name.setBackground(new java.awt.Color(153, 153, 255));
        txt_name.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_name.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_email.setBackground(new java.awt.Color(153, 153, 255));
        txt_email.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_phone.setBackground(new java.awt.Color(153, 153, 255));
        txt_phone.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_phone.setForeground(new java.awt.Color(255, 255, 255));
        txt_phone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_phone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_address.setBackground(new java.awt.Color(153, 153, 255));
        txt_address.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_address.setForeground(new java.awt.Color(255, 255, 255));
        txt_address.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_address.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txt_lastModify.setBackground(new java.awt.Color(153, 153, 255));
        txt_lastModify.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_lastModify.setForeground(new java.awt.Color(255, 255, 255));
        txt_lastModify.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_lastModify.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_lastModify.setEnabled(false);
        getContentPane().add(txt_lastModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

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
        getContentPane().add(jButton_Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 210, 35));

        jButton_Update.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Update.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Update.setText("Update Customer");
        jButton_Update.setBorder(null);
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 210, 35));

        jButton_PrintReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton_PrintReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PrintReportActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_PrintReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 120, 100));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegisterActionPerformed
        RegisterEquipment registerEquipment = new RegisterEquipment();
        registerEquipment.setVisible(true);
    }//GEN-LAST:event_jButton_RegisterActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
        int validation = 0;
        String name;
        String email;
        String phone;
        String address;

        name = txt_name.getText().trim();
        email = txt_email.getText().trim();
        phone = txt_phone.getText().trim();
        address = txt_address.getText().trim();

        if (name.equals("")) {
            txt_name.setBackground(Color.red);
            validation++;
        }

        if (email.equals("")) {
            txt_email.setBackground(Color.red);
            validation++;
        }

        if (phone.equals("")) {
            txt_phone.setBackground(Color.red);
            validation++;
        }

        if (address.equals("")) {
            txt_address.setBackground(Color.red);
            validation++;
        }

        if (validation == 0) {
            try {
                Connection cn = Conexion.connect();
                PreparedStatement pst = cn.prepareStatement(
                        "UPDATE customers SET customer_name=?, customer_email=?, customer_phone=?, customer_address=?, last_modify=?"
                        + "WHERE id_customer = '" + idCliente_Update + "'"
                );

                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, phone);
                pst.setString(4, address);
                pst.setString(5, user);

                pst.executeUpdate();
                cn.close();

                Clear();

                txt_name.setBackground(Color.green);
                txt_email.setBackground(Color.green);
                txt_phone.setBackground(Color.green);
                txt_address.setBackground(Color.green);
                txt_lastModify.setText(user);

                JOptionPane.showMessageDialog(null, "Update Successful");
                this.dispose();
            } catch (SQLException e) {
                System.err.println("Error registering customer " + e);
                JOptionPane.showMessageDialog(null, "Error registering customer, contact with admin.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must fill in all the fields.");
        }


    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_PrintReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PrintReportActionPerformed
        Document document = new Document();

        try {
            String path = System.getProperty("user.home");
            PdfWriter.getInstance(document, new FileOutputStream(path + "/Desktop/" + txt_name.getText().trim() + ".pdf"));

            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            paragraph.add("Customer Information. \n \n");
            paragraph.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            document.open();
            document.add(paragraph);

            PdfPTable customerTable = new PdfPTable(5);
            customerTable.addCell("ID ");
            customerTable.addCell("Name");
            customerTable.addCell("Email");
            customerTable.addCell("Phone");
            customerTable.addCell("Address");

            try {
                Connection cn = Conexion.connect();
                PreparedStatement pst = cn.prepareStatement(
                        "SELECT * FROM customers WHERE id_customer = '" + idCliente_Update + "'"
                );
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    do {
                        customerTable.addCell(rs.getString(1));
                        customerTable.addCell(rs.getString(2));
                        customerTable.addCell(rs.getString(3));
                        customerTable.addCell(rs.getString(4));
                        customerTable.addCell(rs.getString(5));
                    } while (rs.next());

                    document.add(customerTable);
                }

                Paragraph paragraph2 = new Paragraph();
                paragraph2.setAlignment(paragraph2.ALIGN_CENTER);
                paragraph2.add("\n\n Equipments Registerd. \n\n");
                paragraph2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                document.add(paragraph2);

                PdfPTable equipmentTable = new PdfPTable(4);
                equipmentTable.addCell("ID Equipment");
                equipmentTable.addCell("Type");
                equipmentTable.addCell("Brand");
                equipmentTable.addCell("Status");

                try {
                    Connection cn2 = Conexion.connect();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "SELECT id_equipment, equipment_type, brand, status FROM equipments WHERE id_customer = "
                            + "'" + idCliente_Update + "'"
                    );
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        do {
                            equipmentTable.addCell(rs2.getString(1));
                            equipmentTable.addCell(rs2.getString(2));
                            equipmentTable.addCell(rs2.getString(3));
                            equipmentTable.addCell(rs2.getString(4));
                        } while (rs2.next());

                        document.add(equipmentTable);
                    }
                } catch (SQLException e) {
                    System.err.println("Error loading equipmenst");
                }
            } catch (SQLException e) {
                System.err.println("Error getting customer data " + e);
            }
            
            document.close();
            JOptionPane.showMessageDialog(null, "Report Create Successful");
        } catch (DocumentException | IOException e) {
            System.out.println("Error in PDF or Path Image " + e);
            JOptionPane.showMessageDialog(null, "Error generating pdf, contact with admin.");
        }
    }//GEN-LAST:event_jButton_PrintReportActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_PrintReport;
    private javax.swing.JButton jButton_Register;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_address;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JLabel jLabel_lastModify;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_phone;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JScrollPane jScrollPane_equipment;
    private javax.swing.JTable jTable_equipment;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_lastModify;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables

    public void Clear() {
        txt_name.setText("");
        txt_email.setText("");
        txt_phone.setText("");
        txt_address.setText("");
    }
}
