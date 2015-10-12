package com.opji.jdbc.ExceptionsYWarnings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public class SQLWarnings {
	private static final String user ="root";
	private static final String url ="jdbc:mysql://localhost:3306/sakila";
	private static final String password ="surfberria";
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			String sql = "select * from actor";
			
			ResultSet resultSet = stmt.executeQuery(sql);
			new SQLWarning("sadasdasd");
			SQLWarning warnings = conn.getWarnings();
			SQLException warnings2 = stmt.getWarnings();
			
			
			System.out.println("warnings1: " + warnings);
			System.out.println("warnings2: " + warnings2);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
