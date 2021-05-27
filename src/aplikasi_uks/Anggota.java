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
public class Anggota {
    private String kodeanggota;
    private String nama;
    private String status;
    private int nis_nip;
    private String tempat;
    private String tgl;
    private String jekel;
    private String no;
    private String alamat;
    private String gol;
    private String alergi;
    
    
    public String getKodeanggota() {
        return kodeanggota;
    }

    public void setKodeanggota(String kodeanggota) {
        this.kodeanggota = kodeanggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getNis_Nip() {
        return nis_nip;
    }
    
    public void setNis_Nip(int nis_nip) {
        this.nis_nip = nis_nip;
    }
    
    public String getTempat(){
        return tempat;
    }
    
    public void setTempat(String tempat){
        this.tempat = tempat;
    }
    
    public String getTgl(){
        return tgl;
    }
    
    public void setTgl(String tgl){
        this.tgl = tgl;
    }
    
     public String getJekel() {
        return jekel;
    }

    public void setJekel(String jekel) {
        this.jekel = jekel;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public String getNo(){
        return no;
    }
    
    public void setNo(String no){
        this.no = no;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getGol(){
        return gol;
    }
    
    public void setGol(String gol){
        this.gol = gol;
    }
    
    public String getAlergi(){
        return alergi;
    }
    
    public void setAlergi(String alergi){
        this.alergi = alergi;
    }

}
