/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;

/**
 *
 * @author User
 */
public class Obat {
    private String kode_obat;
    private String nama;
    private String satuan;
    private String stok;
    
    public String getKodeObat(){
        return kode_obat;
    }
    
    public void setKodeObat(String kode_obat){
    this.kode_obat = kode_obat;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getSatuan(){
        return satuan;
    }
    
    public void setSatuan(String satuan){
        this.satuan = satuan;
    }
    
    public String getStok(){
        return stok;
    }
    
    public void setStok(String stok){
        this.stok = stok;
    }
}
