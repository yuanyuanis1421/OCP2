package com.opji.jdbc.Statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.util.GregorianCalendar;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class CallableStatementTest {
	
	public static void main(String ...args) throws SQLException{
		
		String getBooksInDateRange = "{call getBooksDateRange(?, ?, ?)}";
		Connection connection = ConnectionDefault.getConnectionDeafault();
		Date from = new Date(new GregorianCalendar(1948, 2, 6).getTimeInMillis());
		Date to = new Date(new GregorianCalendar(2010, 5, 9).getTimeInMillis());
	 
		try {
			CallableStatement callableStatement = connection.prepareCall(getBooksInDateRange);
			callableStatement.setInt(1, 2);
			callableStatement.setDate(2,from);
			callableStatement.setDate(3,to);
			callableStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// We have a Connection object and are in a try block
			
	}

}
