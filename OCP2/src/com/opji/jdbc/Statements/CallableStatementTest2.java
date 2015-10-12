package com.opji.jdbc.Statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementTest2 {
	
	public static void main(String ...args) throws SQLException{
		String url ="jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "surfberria";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql="{? = call contar_ocurrecias(?,?)}";
		CallableStatement callableStatement = conn.prepareCall(sql);
		callableStatement.registerOutParameter(1, java.sql.Types.INTEGER );
		callableStatement.setString(2, "J%");
		callableStatement.setInt(3, 5);
		
		ResultSet resultSet = callableStatement.executeQuery();
		if(resultSet!=null){
			resultSet.next();
			System.out.println(resultSet.getInt(1));
		}
	}
}
