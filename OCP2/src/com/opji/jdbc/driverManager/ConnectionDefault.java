package com.opji.jdbc.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDefault {
	
	private static final String user ="root";
	private static final String url ="jdbc:mysql://localhost:3306/sakila";
	private static final String password ="surfberria";
	
	private static ConnectionDefault CONNECTION_DEFAULT ;
	private Connection connection;
	
	private ConnectionDefault(){
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			this.connection = conn;
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public static Connection getConnectionDeafault(){
		if(CONNECTION_DEFAULT == null){
			CONNECTION_DEFAULT = new ConnectionDefault();
		}
		return CONNECTION_DEFAULT.connection;
	}
	public static void printResultSet(){
		
	}
}