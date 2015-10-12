package com.opji.jdbc.rowSet;

import static java.lang.System.out;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

	public static void main(String... args) throws SQLException {

		String name = "root";
		String password = "surfberria";
		String url = "jdbc:mysql://localhost:3306/sakila";

		String query = "select * from customer limit 10";
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = rowSetFactory.createJdbcRowSet();
		jdbcRowSet.setUsername(name);
		jdbcRowSet.setPassword(password);
		jdbcRowSet.setUrl(url);
		jdbcRowSet.setCommand(query);
		jdbcRowSet.execute();
		jdbcRowSet.addRowSetListener(new MyJdbcListener());
		realizarConsulta(jdbcRowSet);
		actualizarNombre(jdbcRowSet);
	//	borrarNombre(jdbcRowSet); IMPOSIBLE DE HACER POR LA BASE DE DATOS
	}
	
	

	private static void borrarNombre(JdbcRowSet jdbcRowSet) throws SQLException {
		jdbcRowSet.last();
		jdbcRowSet.deleteRow();
		realizarConsulta(jdbcRowSet);
		
	}



	private static void realizarConsulta(JdbcRowSet jdbcRowSet) throws SQLException {
		printResults(jdbcRowSet);
		
	}



	private static void actualizarNombre(JdbcRowSet jdbcRowSet) throws SQLException {
		jdbcRowSet.absolute(10);
		jdbcRowSet.updateString("first_name", "Leticia");
		jdbcRowSet.updateString("last_name", "Lumbreras Santacatalina");
		jdbcRowSet.updateRow();
		realizarConsulta(jdbcRowSet);
	}
	



	private static void printResults(ResultSet resultSet) throws SQLException {

		out.println();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols = metaData.getColumnCount();
		String col, colData;
		for (int i = 1; i <= cols; i++) {
			col = leftJustify(metaData.getColumnName(i), metaData.getColumnDisplaySize(i));
			out.print(col);
			
		}
		out.println();
		while (resultSet.next()) {
			for (int i = 1; i <= cols; i++) {
				if (resultSet.getObject(i) != null) {
					colData = resultSet.getObject(i).toString(); // Get

				} else {
					colData = "NULL";
				}
				col = leftJustify(colData, metaData.getColumnDisplaySize(i));
				out.print(col);
			}
			out.println();
		}
	}

	private static String leftJustify(String s, int n) {
		if (s.length() <= n)
			n++; // Add an extra space

		return String.format("%1$-" + n + "s", s);
	}

}
