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
public class ObatDao {
     public static void insert(Connection con, Obat obat) throws SQLException{
        String sql = "insert into t_stokobat values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obat.getKodeObat());
        ps.setString(2, obat.getNama());
        ps.setString(3, obat.getSatuan());
        ps.setString(4, obat.getStok());
        ps.executeUpdate();
    }
    public static void update(Connection con, Obat obat) throws SQLException{
        String sql = "update t_stokobat set nama=?, satuan=?, stok=? "
                + "where kode_obat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obat.getNama());
        ps.setString(2, obat.getSatuan());
        ps.setString(3, obat.getStok());
        ps.setString(4, obat.getKodeObat());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Obat obat) throws SQLException{
        String sql = "delete from t_stokobat where kode_obat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obat.getKodeObat());
        ps.executeUpdate();
    }
    public static Obat getObat(Connection con, String kode_obat) throws SQLException{
        String sql = "Select * from t_stokobat where kode_obat=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_obat);
        Obat obat = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            obat = new Obat();
            obat.setKodeObat(rs.getString(1));
            obat.setNama(rs.getString(2));
            obat.setSatuan(rs.getString(3));
            obat.setStok(rs.getString(4));
        }
        return obat;
    }
}