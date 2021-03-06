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
public class UserDao {
     public static void insert(Connection con, User user) throws SQLException{
        String sql = "insert into t_user values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getAkses());
        ps.executeUpdate();
    }
    public static void update(Connection con, User user) throws SQLException{
        String sql = "update t_user set username=?, password=?, akses=? "
                + "where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getAkses());
        ps.executeUpdate();
    }
    public static void delete(Connection con, User user) throws SQLException{
        String sql = "delete from t_user where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.executeUpdate();
    }
    public static User getUser(Connection con, String username) throws SQLException{
        String sql = "Select * from t_user where username=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        User user = null;
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            user = new User();
            user.setUsername(rs.getString(1));
            user.setPassword(rs.getString(2));
            user.setAkses(rs.getString(3));
        }
        return user;
    }
}
