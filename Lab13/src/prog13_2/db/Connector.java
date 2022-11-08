package prog13_2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static final String DB_URL = "jdbc:mysql//localhost:3306/FPP_DB";
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(DB_URL, "root", "");
		
		System.out.println("Connected to the FPP_DB database...");
		
		return connection;
	}
}
