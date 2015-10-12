package com.opji.jdbc.ExceptionsYWarnings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClossingConnections {

	public static void main(String ...args){
		Connection conn = null;
		String url = null, user = null, password = null; // These are populated somewhere else
		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
			// ... process the results
			// ...
			if (rs != null && stmt != null) {
				rs.close(); // Attempt to close the ResultSet
				stmt.close(); // Attempt to close the Statement
			}
		} catch (SQLException se) {
			System.out.println("SQLException: " + se);
		} finally {
			try {
				if (conn != null) {
					conn.close(); // Close the Connection
				}
			}	 catch (SQLException sec) {	
				System.out.println("Exception closing connection!");
			}
		}
		
	}
	
	private static void cerrandoConTryWithResources(){
		
		String url = null, user = null, password = null; // These are populated somewhere else
		try(Connection conn = DriverManager.getConnection(url, user, password);
				Statement statement = conn.createStatement()){
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
