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
public class InventarisDao {
     public static void insert(Connection con, Inventaris inventaris) throws SQLException{
        String sql = "insert into t_inventaris values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inventaris.getKodeInventaris());
        ps.setString(2, inventaris.getTgl());
        ps.setString(3, inventaris.getNama());
        ps.setString(4, inventaris.getJml());
        ps.setString(5, inventaris.getSumber());
        ps.setString(6, inventaris.getKet());
        ps.executeUpdate();
    }
    public static void update(Connection con, Inventaris inventaris) throws SQLException{
        String sql = "update t_inventaris set tgl=?, nama=?, jml=?, sumber=?, keterangan=? "
                + "where kode_inventaris=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inventaris.getTgl());
        ps.setString(2, inventaris.getNama());
        ps.setString(3, inventaris.getJml());
        ps.setString(4, inventaris.getSumber());
        ps.setString(5, inventaris.getKet());
        ps.setString(6, inventaris.getKodeInventaris());
        ps.executeUpdate();
    }
    public static void delete(Connection con, Inventaris inventaris) throws SQLException{
        String sql = "delete from t_inventaris where kode_inventaris=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, inventaris.getKodeInventaris());
        ps.executeUpdate();
    }
    public static Inventaris getInventaris(Connection con, String kode_inventaris) throws SQLException{
        String sql = "Select * from t_inventaris where kode_inventaris=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode_inventaris);
        Inventaris inventaris = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            inventaris = new Inventaris();
            inventaris.setKodeInventaris(rs.getString(1));
            inventaris.setTgl(rs.getString(2));
            inventaris.setNama(rs.getString(3));
            inventaris.setJml(rs.getString(4));
            inventaris.setSumber(rs.getString(5));
            inventaris.setKet(rs.getString(6));
        }
        return inventaris;
    }
}
