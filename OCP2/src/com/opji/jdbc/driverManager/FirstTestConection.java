package com.opji.jdbc.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstTestConection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:derby://localhost:1521/BookSellerDB";
		// JDBC URL
		String user = "bookguy"; // BookSellerDB user name
		String pwd = "$3lleR"; // BookSellerDB password
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
		
	}

}
