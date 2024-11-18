package class_systems;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    //Local conexion
    public static Connection connect() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/db_ds", "root", "");
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in local conexion\n" + e);
        }
        
        return (null);
    }
}
