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

/**
 *
 * @author User
 */
public class PetugasDao {
    public static void insert(Connection con, Petugas petugas) throws SQLException{
        String sql = "insert into t_petugas values(?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, petugas.getKodePetugas());
        ps.setString(2, petugas.getNama());
        ps.setString(3, petugas.getAlamat());
        ps.setString(4, petugas.getJekel());
        ps.setString(5, petugas.getNo_hp());
        ps.executeUpdate();
    }
    public static void update(Connection con, Petugas petugas) throws SQLException{
        String sql = "update t_petugas set nama=?, alamat=?, jekel=?, no_hp=? "
                + "where kode_petugas=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, petugas.getNama());
        ps.setString(2, petugas.getAlamat());
        ps.setString(3, petugas.getJekel());
        ps.setString(4, petugas.getNo_hp());
        ps.setString(5, petugas.getKodePetugas());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Petugas petugas) throws SQLException{
        String sql = "delete from t_petugas where kode_petugas=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, petugas.getKodePetugas());
        ps.executeUpdate();
    }
    public static Petugas getPetugas(Connection con, String kode_petugas) throws SQLException{
        String sql = "Select * from t_petugas where kode_petugas=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_petugas);
        Petugas petugas = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            petugas = new Petugas();
            petugas.setKodePetugas(rs.getString(1));
            petugas.setNama(rs.getString(2));
            petugas.setAlamat(rs.getString(3));
            petugas.setJekel(rs.getString(4));
            petugas.setNo_hp(rs.getString(5));
        }
        return petugas;
    }
}
