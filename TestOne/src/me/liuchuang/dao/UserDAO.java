package me.liuchuang.dao;

/**
 * Created by liuchuang on 16-5-13.
 */

import java.sql.*;
import java.util.*;

import me.liuchuang.beans.User;
import me.liuchuang.db.DBUtil;

public class UserDAO {

    // Add user to users table.
    public void addUser(User user) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "" + "INSERT INTO users" + "(id, username, password)"
                + "VALUES(null, ?, ?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, user.getUsername());
        ptmt.setString(2, user.getPassword());
        ptmt.execute();
    }

    // Delete a user from users table.
    public void deleteUser(Integer id) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM users WHERE id=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }

    // Update a user in users table.
    public void update(User u) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "" + " UPDATE users " + " SET username=?, password=? "
                 + " WHERE id=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, u.getUsername());
        ptmt.setString(2, u.getPassword());
        ptmt.setString(3, u.getId());
        ptmt.execute();
    }

    // Search user by username.
    public boolean findUser(String username) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM users WHERE username=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, username);
        ResultSet rs = ptmt.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("username"));
            return true;
        } else {
            return false;
        }
    }

    // Search a user with given id.
    public User getUser(Integer id) throws Exception {
        Connection conn = DBUtil.getConnection();
        User u = null;
        String sql = "SELECT * FROM users WHERE id=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs =  ptmt.executeQuery();
        if(rs.next()) {
            u = setUser(rs);
            if (u == null)
                return null;
        }
        return u;
    }

    // Search a user with user name.
    public User getUser(String username) throws Exception {
        Connection conn = DBUtil.getConnection();
        User u = null;
        String sql = "SELECT * FROM users WHERE username=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, username);
        ResultSet rs =  ptmt.executeQuery();

        u = setUser(rs);
        return u;
    }

    // Search all user in users table.
    public List<User> query() throws Exception{
        List<User> result = new ArrayList<User>();
        Connection conn = DBUtil.getConnection();
        String sql = " SELECT * FROM users";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        User u = null;
        while (rs.next()) {
            u = new User();
            u = setUser(rs);
            result.add(u);
        }
        return result;
    }

    // Set user's information.
    private User setUser(ResultSet rs) throws SQLException {
        User u = new User();
//        if (!rs.isAfterLast()) {
            u.setId(rs.getString("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
//        }
        return u;
    }
}
