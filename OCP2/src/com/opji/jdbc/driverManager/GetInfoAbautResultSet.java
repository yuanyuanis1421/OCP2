package com.opji.jdbc.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

public class GetInfoAbautResultSet {
	
	private static final String user ="root";
	private static final String url ="jdbc:mysql://localhost:3306/sakila";
	private static final String password ="surfberria";

	public static void main(String[] args) throws SQLException{
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement statement = con.createStatement();
			
			String sql = "select * from address limit 256";
			ResultSet resultSet = statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			
			int i =resultSetMetaData.getColumnCount();
			
			System.out.println("CoulumnCount" + i);
			
			for (int j = 1; j < i; j++) {
				System.out.println("ColumnName: "+resultSetMetaData.getColumnName(j));
				System.out.println("TableName: "+resultSetMetaData.getTableName(j));
				System.out.println("ColumnDisplaySize: "+resultSetMetaData.getColumnDisplaySize(j));
				
			}
		

	}	

	

}
