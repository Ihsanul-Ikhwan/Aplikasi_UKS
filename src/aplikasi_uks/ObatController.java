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
public class ObatController {
    FormObat view;
    //FormLaporanObat formLaporanObat;
    Obat obat;   //model
    Connection con;
    
     public ObatController(FormObat view) {
        try {
            this.view = view;
            Koneksi k= new Koneksi();
            con = k.getKoneksi();
            clearForm();
            viewTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public ObatController(FormLaporanBuku formLaporanBuku) {
        this.formLaporanBuku = formLaporanBuku;
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
        view.getTxtKode().setText("");
        view.getTxtNama().setText("");
        view.getTxtSatuan().setText("");
        view.getTxtStok().setText("");
    }
    
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelObat().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_stokobat");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClickTabel() {
        try {
            String kode = view.getTabelObat().getValueAt(view.getTabelObat().getSelectedRow(), 0).toString();
            obat = ObatDao.getObat(con, kode);
            if (obat != null) {
                view.getTxtKode().setText(obat.getKodeObat());
                view.getTxtNama().setText(obat.getNama());
                view.getTxtSatuan().setText(obat.getSatuan());
                view.getTxtStok().setText(obat.getStok());
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Data Tidak Ada");
                clearForm();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public void previewBuku() {
        HashMap parameter = new HashMap();
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/buku.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void previewBukuTahunTerbit() {
        HashMap parameter = new HashMap();
        parameter.put("tahunterbit", formLaporanBuku.getCboTahun().getSelectedItem().toString());
        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport("report/buku_TahunTerbit.jasper", parameter, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            System.out.print(ex.toString());
            //Logger.getLogger(formlaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public void insert(){
        obat = new Obat();
        obat.setKodeObat(view.getTxtKode().getText());
        obat.setNama(view.getTxtNama().getText());
        obat.setSatuan(view.getTxtSatuan().getText());
        obat.setStok(view.getTxtStok().getText());
        
        try {
            ObatDao.insert(con, obat);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        obat = new Obat();
        obat.setKodeObat(view.getTxtKode().getText());
        obat.setNama(view.getTxtNama().getText());
        obat.setSatuan(view.getTxtSatuan().getText());
        obat.setStok(view.getTxtStok().getText());
        
        try {
            ObatDao.update(con, obat);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        try {
            ObatDao.delete(con, obat);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
