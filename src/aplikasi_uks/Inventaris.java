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
public class Inventaris {
    private String kode_inventaris;
    private String tgl;
    private String nama;
    private String jml;
    private String sumber;
    private String ket;
    
    public String getKodeInventaris(){
        return kode_inventaris;
    }
    
    public void setKodeInventaris(String kode_inventaris){
        this.kode_inventaris = kode_inventaris;
    }
    
    public String getTgl(){
        return tgl;
    }
    
    public void setTgl(String tgl){
        this.tgl = tgl;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getJml(){
        return jml;
    }
    
    public void setJml(String jml){
        this.jml = jml;
    }
    
    public String getSumber(){
        return sumber;
    }
    
    public void setSumber(String sumber){
        this.sumber = sumber;
    }
    
    public String getKet(){
        return ket;
    }
    
    public void setKet(String ket){
        this.ket = ket;
    }
    
}
