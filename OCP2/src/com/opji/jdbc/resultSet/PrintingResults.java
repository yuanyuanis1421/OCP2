package com.opji.jdbc.resultSet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import static java.lang.System.out;

import java.sql.ResultSetMetaData;
import com.opji.jdbc.driverManager.ConnectionDefault;

public class PrintingResults {

	private static final int ESPACIO_MIN = 3;
	
	public static void main(String[] args) {
		
		Connection conn = ConnectionDefault.getConnectionDeafault();
		String query = "Select * from customer limit 110";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			out.println(rs.getString("last_name"));
					
			
			while(rs!=null){
				
			}
			
		
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void printResults(ResultSet resultSet) throws SQLException{
		
		
		out.println();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols = metaData.getColumnCount();
		String col, colData;
		for (int i = 1; i <= cols; i++) {
			col = leftJustify(metaData.getColumnName(i),metaData.getColumnDisplaySize(i));
			out.print(col);
			
		}
		out.println();
		while(resultSet.next()){
			  for (int i = 1; i <= cols; i++) {
				    if (resultSet.getObject(i) != null) {
				      colData = resultSet.getObject(i).toString(); // Get 
			
				    } else {
				      colData = "NULL";                    
				    }
				    col = leftJustify(colData,
				    		metaData.getColumnDisplaySize(i));
				    out.print(col);
			  }
			  out.println();
		}
	}
	private static String leftJustify(String s, int n) {
		  if (s.length() <= n) n++;  // Add an extra space 
	
		    return String.format("%1$-" + n + "s", s); 
	}


}
