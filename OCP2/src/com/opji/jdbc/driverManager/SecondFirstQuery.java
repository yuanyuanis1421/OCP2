package com.opji.jdbc.driverManager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import static java.lang.System.out;
public class SecondFirstQuery {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sakila";
	private static final String USER = "root";
	private static final String PASSWORD = "surfberria";
	
	public static void main(String ...args) throws SQLException{
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		Statement statement = conn.createStatement();
		String query = "select * from actor limit 10";
		ResultSet resultSet = statement.executeQuery(query);
		int numRows;
		while(resultSet.next()){
			System.out.print(resultSet.getInt("actor_id")+" ");
			System.out.print(resultSet.getString("first_name")+" ");
			System.out.print(resultSet.getString("last_name")+" ");
			System.out.println(resultSet.getTimestamp("last_update")+" ");
			String q = "UPDATE Book SET UnitPrice=8.95 WHERE UnitPrice < 8.95 AND Format='Hardcover'";
			numRows = statement.executeUpdate(q);
		}
		
		boolean status = statement.execute("");  // True if there is a ResultSet
		if (status) {                       // True
		  
		} else {                            // False
		  numRows = statement.getUpdateCount();  // Get the update count
		  if (numRows == -1) {              // If -1, thereare no results
		    out.println("No results");
		  } else {                          // else, print the number of
		                                    // rows affected
		    out.println(numRows + " rows affected.");
		  }
		}
		
	}
	

}
