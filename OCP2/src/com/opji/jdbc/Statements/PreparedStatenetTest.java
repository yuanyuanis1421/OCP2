package com.opji.jdbc.Statements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class PreparedStatenetTest {
	
	public static void main(String ...args){
		Connection conn = ConnectionDefault.getConnectionDeafault();
		String sql="select * from customer where first_name LIKE ?";
		try {
			PreparedStatement preparedStatement =conn.prepareStatement(sql);
			preparedStatement.setString(2, "Maria");
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.executeUpdate();
			
			while(resultSet!=null){
				System.out.println(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
