package com.opji.jdbc.Statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest2 {
	public static void main(String ...args) throws SQLException{
		String url ="jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "surfberria";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "select Max_id_actor()";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if(rs!=null){
			rs.next();
			System.out.println(rs.getInt(1));
		}else{
			SQLException sqlException =new SQLException("BAD call or something");
			throw sqlException;
		}
	}
}
