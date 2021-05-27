/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class AnggotaController {
    FormAnggota view;
    /*FormLaporanAnggota formLaporanAnggota;*/
    Anggota anggota;   //model
    Connection con;

    public AnggotaController(FormAnggota view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            isiComboJekel();
            isiComboDarah();
            viewTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* public AnggotaController(FormLaporanAnggota formLaporanAnggota) {
        this.formLaporanAnggota = formLaporanAnggota;
        Koneksi k = new Koneksi();
        try {
            con = k.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void clearForm(){
        view.getTxtKodeAnggota().setText("");
        view.getTxtNamaAnggota().setText("");
        view.getTxtStatus().setText("");
        view.getTxtNis_Nip().setText("");
        view.getTxtTempat().setText("");
        view.getTxtTgl().setText("");
        view.getTxtNo().setText("");
        view.getTxtAlamat().setText("");
        view.getTxtAlergi().setText("");
        view.getTxtAlamat().setText("");
    }
    
    public void isiComboJekel(){
        view.getCboJekel().removeAllItems();
        view.getCboJekel().addItem("-");
        view.getCboJekel().addItem("L");
        view.getCboJekel().addItem("P");
    }
    
    public void isiComboDarah(){
        view.getCboGol().removeAllItems();
        view.getCboGol().addItem("-");
        view.getCboGol().addItem("A");
        view.getCboGol().addItem("B");
        view.getCboGol().addItem("AB");
        view.getCboGol().addItem("O");
    }
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelAnggota().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_pasien");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClickTabel() {
        try {
            String kode = view.getTabelAnggota().getValueAt(view.getTabelAnggota().getSelectedRow(), 0).toString();
            anggota = AnggotaDao.getAnggota(con, kode);
            if (anggota != null) {
                view.getTxtKodeAnggota().setText(anggota.getKodeanggota());
                view.getTxtNamaAnggota().setText(anggota.getNama());
                view.getTxtStatus().setText(anggota.getStatus());
                view.getTxtNis_Nip().setText(""+anggota.getNis_Nip());
                view.getTxtTempat().setText(anggota.getTempat());
                view.getTxtTgl().setText(anggota.getTgl());
                view.getCboJekel().setSelectedItem(anggota.getJekel());
                view.getTxtNo().setText(anggota.getNo());
                view.getTxtAlamat().setText(anggota.getAlamat());
                view.getCboGol().setSelectedItem(anggota.getGol());
                view.getTxtAlergi().setText(anggota.getAlergi());
        
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   /* public void previewAnggota() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/anggota.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewAnggotaJekel() {
        HashMap parameter = new HashMap();
        parameter.put("jekel", formLaporanAnggota.getCboJekel().getSelectedItem().toString());
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/anggota_jekel.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }*/
    
    public void insert(){
        anggota = new Anggota();
        anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
        anggota.setNama(view.getTxtNamaAnggota().getText());
        anggota.setStatus(view.getTxtStatus().getText());
        anggota.setNis_Nip(Integer.parseInt(view.getTxtNis_Nip().getText()));
        anggota.setTempat(view.getTxtTempat().getText());
        anggota.setTgl(view.getTxtTgl().getText());
        anggota.setJekel(view.getCboJekel().getSelectedItem().toString());
        anggota.setNo(view.getTxtNo().getText());
        anggota.setAlamat(view.getTxtAlamat().getText());
        anggota.setGol(view.getCboGol().getSelectedItem().toString());
        anggota.setAlergi(view.getTxtAlergi().getText());
         
        try {
            AnggotaDao.insert(con, anggota);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        anggota = new Anggota();
        anggota.setKodeanggota(view.getTxtKodeAnggota().getText());
        anggota.setNama(view.getTxtNamaAnggota().getText());
        anggota.setStatus(view.getTxtStatus().getText());
        anggota.setNis_Nip(Integer.parseInt(view.getTxtNis_Nip().getText()));
        anggota.setTempat(view.getTxtTempat().getText());
        anggota.setTgl(view.getTxtTgl().getText());
        anggota.setJekel(view.getCboJekel().getSelectedItem().toString());
        anggota.setNo(view.getTxtNo().getText());
        anggota.setAlamat(view.getTxtAlamat().getText());
        anggota.setGol(view.getCboGol().getSelectedItem().toString());
        anggota.setAlergi(view.getTxtAlergi().getText());
        
        try {
            AnggotaDao.update(con, anggota);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        try {
            AnggotaDao.delete(con, anggota);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
