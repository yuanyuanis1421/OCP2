package com.opji.jdbc.rowSet;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class CachedRowSetTest {
	
	public static void main(String ...args) throws SQLException{
		RowSetFactory ro  =RowSetProvider.newFactory();
		CachedRowSet cached = ro.createCachedRowSet();
		String name ="root";
		String password = "surfberria";
		String url ="jdbc:mysql://localhost:3306/sakila";
		cached.setUsername(name);
		cached.setPassword(password);
		cached.setUrl(url);
		String query="select * from customer limit 10";
		cached.setCommand(query);
		cached.execute();
		cached.addRowSetListener(new MyJdbcListener());
		
		UtilityPrint.printResults(cached);
		
		modificarLosTresPrimeros(cached);
		UtilityPrint.printResults(cached);
		
	}

	private static void modificarLosTresPrimeros(CachedRowSet cached) throws SQLException {
		cached.first();
		Timestamp timestamp = new Timestamp(new Date().getTime());
		for(int i = 1 ; i<=5;i++){
			cached.setString("first_name", "insidius");
			cached.setString("last_name", "peligro");
			cached.setString("email", "Juan:TATATAT@CUSTOOORMERRR.es");
			cached.setTimestamp("last_update", timestamp);
			cached.updateRow();
			cached.next();
		}
		cached.acceptChanges();
			
		
	}

	
}
