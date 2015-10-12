package com.opji.jdbc.ExceptionsYWarnings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class SQLExceptionMethodsTest {
	
	public static void main (String ...args){
		Connection conn = ConnectionDefault.getConnectionDeafault();
		
		try{
			Statement statement = conn.createStatement();
			ResultSet re = statement.executeQuery("Select * from DIOSSS"); // esta tabla no exite asi que BOOM!!! AQUI
		
		}catch(SQLException e){
			
			SQLException ex = new SQLException("Me he inventado el menssage de esta excepcion y la excepción en si;");
			e.setNextException(ex);
			while(e!=null){
				System.out.println("getMessage: "+e.getMessage());
				System.out.println("getSQLState: "+e.getSQLState());
				System.out.println("getErrorCode: "+e.getErrorCode());
				System.out.println("getNextException"+e.getNextException());
				e = e.getNextException();
			}
		}
		
	}

}
