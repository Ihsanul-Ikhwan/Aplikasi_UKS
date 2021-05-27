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
public class Petugas {
    private String kode_petugas;
    private String nama;
    private String alamat;
    private String jekel;
    private String no_hp;
    
    public String getKodePetugas(){
        return kode_petugas;
    }
    
    public void setKodePetugas(String kode_petugas){
        this.kode_petugas = kode_petugas;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    
    public void setAlamat(String alamat){
        this.alamat =alamat;
    }
    
    public String getJekel(){
        return jekel;
    }
    
    public void setJekel(String jekel){
        this.jekel = jekel;
    }
    
    public String getNo_hp(){
        return no_hp;
    }
    
    public void setNo_hp(String no_hp){
        this.no_hp = no_hp;
    }
}
