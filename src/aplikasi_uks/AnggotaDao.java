/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_uks;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class AnggotaDao {
     public static void main(String[] args) {
        try {
            Koneksi k = new Koneksi();
            Anggota anggota = new Anggota();
            anggota.setKodeanggota("A002");
            anggota.setNama("Aul");
            anggota.setAlamat("Bukittinggi");
            anggota.setJekel("L");
            AnggotaDao.insert(k.getKoneksi(), anggota);
            JOptionPane.showMessageDialog(null, "Insert Ok");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage()); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error "+ex.getMessage()); 
        }
    }
    public static void insert(Connection con, Anggota anggota) throws SQLException{
        String sql = "insert into t_pasien values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKodeanggota());
        ps.setString(2, anggota.getNama());
        ps.setString(3, anggota.getStatus());
        ps.setInt(4, anggota.getNis_Nip());
        ps.setString(5, anggota.getTempat());
        ps.setString(6, anggota.getTgl());
        ps.setString(7, anggota.getJekel());
        ps.setString(8, anggota.getNo());
        ps.setString(9, anggota.getAlamat());
        ps.setString(10, anggota.getGol());
        ps.setString(11, anggota.getAlergi());
        ps.executeUpdate();
    }
    public static void update(Connection con, Anggota anggota) throws SQLException{
        String sql = "update t_pasien set nama=?, status=?, nis_nip=?, tempat=?, tgl=?, jekel=?, no=?, alamat=?, gol=?, alergi=? "
                + "where kode_pasien=?";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, anggota.getNama());
        ps.setString(2, anggota.getStatus());
        ps.setInt(3, anggota.getNis_Nip());
        ps.setString(4, anggota.getTempat());
        ps.setString(5, anggota.getTgl());
        ps.setString(6, anggota.getJekel());
        ps.setString(7, anggota.getNo());
        ps.setString(8, anggota.getAlamat());
        ps.setString(9, anggota.getGol());
        ps.setString(10, anggota.getAlergi());
        ps.setString(11, anggota.getKodeanggota());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Anggota anggota) throws SQLException{
        String sql = "delete from t_pasien where kode_pasien=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, anggota.getKodeanggota());
        ps.executeUpdate();
    }
    
    public static Anggota getAnggota(Connection con, String kodeanggota) throws SQLException{
        String sql = "Select * from t_pasien where kode_pasien=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        Anggota anggota = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            anggota = new Anggota();
            anggota.setKodeanggota(rs.getString(1));
            anggota.setNama(rs.getString(2));
            anggota.setStatus(rs.getString(3));
            anggota.setNis_Nip(rs.getInt(4));
            anggota.setTempat(rs.getString(5));
            anggota.setTgl(rs.getString(6));
            anggota.setJekel(rs.getString(7));
            anggota.setNo(rs.getString(8));
            anggota.setAlamat(rs.getString(9));
            anggota.setGol(rs.getString(10));
            anggota.setAlergi(rs.getString(11));
        }
        return anggota;
    }
}
