package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static final String URL = "jdbc:mysql://127.0.0.1:3306/Godness";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	private static Connection conn;

	static {
		try {
			// Import database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get connect
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {

		// control database
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name, age from goddess_demo");

		while (rs.next()) {
			System.out.println(rs.getString("user_name") + ", " + rs.getInt("age"));
		}
	}

	public static Connection getConnection() {
		return conn;
	}
}
