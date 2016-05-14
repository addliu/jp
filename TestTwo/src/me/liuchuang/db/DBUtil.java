package me.liuchuang.db;

/**
 * Created by liuchuang on 16-5-13.
 */

import java.sql.*;

public class DBUtil {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/j2ee";
    public static final String NAME = "root";
    public static final String PASSWORD = "root";
    public static Connection conn;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}

