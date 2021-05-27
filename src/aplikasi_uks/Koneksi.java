/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Koneksi {
    private String url = "jdbc:mysql://localhost/uks";
    private String uname="root";
    private String passw="";
    
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, uname, passw);
        
    }
    
    public static void main(String[] args) {
        try {
            Koneksi k = new Koneksi();
            k.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi Sukses"); 
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage()); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage()); 
        }
    }
}
