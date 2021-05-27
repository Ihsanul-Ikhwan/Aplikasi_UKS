/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class UserController {
    FormLogin view;
    FormRegister viewR;
    User user;
    UserDao userdao;
    Connection con;
    
    public UserController(FormLogin view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            isiCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UserController(FormRegister view) {
        try {
            this.viewR = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            isiComboAkses();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearView(){
        view.getTxtUsername().setText("");
        view.getTxtPassword().setText("");
    }
    public void clearViewR(){
        viewR.getTxtUsername().setText("");
        viewR.getTxtPassword1().setText("");
        viewR.getTxtPassword2().setText("");
    }
    public void isiCombo(){
        view.getCboHa().removeAllItems();
        view.getCboHa().addItem("-");
        view.getCboHa().addItem("admin");
        view.getCboHa().addItem("petugas");
    }
    public void isiComboAkses(){
        viewR.getCboAkses().removeAllItems();
        viewR.getCboAkses().addItem("admin");
        viewR.getCboAkses().addItem("petugas");
    }
    public boolean onClickBtnLogin(){
        try{
            String username = view.getTxtUsername().getText();
            user = userdao.getUser(con,username);
            String password = view.getTxtPassword().getText();
            user = userdao.getUser(con,password);
            if(view.getCboHa().getSelectedItem().equals("admin")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormAdmin f = new FormAdmin();
                f.setVisible(true);
                f.toFront();
            }else if(view.getCboHa().getSelectedItem().equals("petugas")){
                javax.swing.JOptionPane.showMessageDialog(view, "Login Berhasil");
                FormPetugas f = new FormPetugas();
                f.setVisible(true);
                f.toFront();
            }else{
                JOptionPane.showMessageDialog(view, "Username dan password salah !!!");
            }
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NullPointerException ex){
            JOptionPane.showMessageDialog(view, "Username dan password salah !!!");
            clearView();
        }
        return false;
    }
    
    public String getPasswordAttempt(){
        if(viewR.getTxtPassword1().getText().equals("")){
            return "0";
        }else if(viewR.getTxtPassword1().getText().length() < 5){
            return "-1";
        }else if(!viewR.getTxtPassword1().getText().equals(viewR.getTxtPassword2().getText())){
            return "1";
        }else{
            return viewR.getTxtPassword1().getText();
        }
    }
    public boolean usernameCheck(){
        try{
            String username = viewR.getTxtUsername().getText();
            user = userdao.getUser(con,username);
            if(user == null) return true;
        }catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void onClickBtnCreate(){
        if(getPasswordAttempt() == "0"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password tidak boleh kosong!");
        }else if(getPasswordAttempt() == "-1"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password minimal 5 Karakter!");
        }else if(getPasswordAttempt() == "1"){
            javax.swing.JOptionPane.showMessageDialog(viewR, "Password tidak sama!");
        }else{
            user = new User();
            user.setUsername(viewR.getTxtUsername().getText());
            user.setPassword(getPasswordAttempt());
            user.setAkses(viewR.getCboAkses().getSelectedItem().toString());
            try {
                UserDao.insert(con, user);
                JOptionPane.showMessageDialog(viewR, "Berhasil Register");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(viewR, "Error e "+ex.getMessage()); 
            }
        }
    } 
}
