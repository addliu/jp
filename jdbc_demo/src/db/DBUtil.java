package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

	public static Connection getConnection() {
		return conn;
	}
}
