package repository;

import java.sql.Connection;
import java.sql.DriverManager;

abstract class Repository {
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/Epers_Ej1?user=root&password=root");
	}	
	
}
