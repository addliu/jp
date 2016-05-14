package test;
import db.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liuchuang on 25/02/16.
 */
public class DBUtilTest {
    public static void main(String[] argv) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from Card";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", name:" + rs.getString("owner"));
        }
        sql = "select * from CreditCard";
        ptmt = conn.prepareStatement(sql);
        rs = ptmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("id") + ", name:" + rs.getString("owner"));
        }
    }
}
