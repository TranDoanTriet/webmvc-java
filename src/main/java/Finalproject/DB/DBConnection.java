package Finalproject.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/keyboard_shops";
	private static final String USER = "root";
	private static final String PASSWORD = "Triet@270600";
	public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
        }        return connection;
    }
}