/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class InventarisController {
    FormInventaris view;
    //FormLaporanObat formLaporanObat;
    Inventaris inventaris;   //model
    Connection con;
    
     public InventarisController(FormInventaris view) {
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
        view.getTxtKod().setText("");
        view.getTxtTgl().setText("");
        view.getTxtNam().setText("");
        view.getTxtJml().setText("");
        view.getTxtSumber().setText("");
        view.getTxtKet().setText("");
    }
    
    
    public void viewTable(){
        try {
            DefaultTableModel tabelModel =
                    (DefaultTableModel) view.getTabelInventaris().getModel();
            tabelModel.setRowCount(0);
            ResultSet rs = con.createStatement().executeQuery("select * from t_inventaris");
            while(rs.next()){
                Object[] data={
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
                };
                tabelModel.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ObatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onClickTabel() {
        try {
            String kode = view.getTabelInventaris().getValueAt(view.getTabelInventaris().getSelectedRow(), 0).toString();
            inventaris = InventarisDao.getInventaris(con, kode);
            if (inventaris != null) {
                view.getTxtKod().setText(inventaris.getKodeInventaris());
                view.getTxtTgl().setText(inventaris.getTgl());
                view.getTxtNam().setText(inventaris.getNama());
                view.getTxtJml().setText(inventaris.getJml());
                view.getTxtSumber().setText(inventaris.getSumber());
                view.getTxtKet().setText(inventaris.getKet());
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
        inventaris = new Inventaris();
        inventaris.setKodeInventaris(view.getTxtKod().getText());
        inventaris.setTgl(view.getTxtTgl().getText());
        inventaris.setNama(view.getTxtNam().getText());
        inventaris.setJml(view.getTxtJml().getText());
        inventaris.setSumber(view.getTxtSumber().getText());
        inventaris.setKet(view.getTxtKet().getText());
        
        try {
            InventarisDao.insert(con, inventaris);
            JOptionPane.showMessageDialog(view, "Entri Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error "+ex.getMessage()); 
        }
    }
    
    public void update() {
        inventaris = new Inventaris();
        inventaris.setKodeInventaris(view.getTxtKod().getText());
        inventaris.setTgl(view.getTxtTgl().getText());
        inventaris.setNama(view.getTxtNam().getText());
        inventaris.setJml(view.getTxtJml().getText());
        inventaris.setSumber(view.getTxtSumber().getText());
        inventaris.setKet(view.getTxtKet().getText());
        
        try {
            InventarisDao.update(con, inventaris);
            JOptionPane.showMessageDialog(view, "Update Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
    
    public void delete(){
        try {
            InventarisDao.delete(con, inventaris);
            JOptionPane.showMessageDialog(view, "Delete Data Ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Error " + ex.getMessage());
        }
    }
}
