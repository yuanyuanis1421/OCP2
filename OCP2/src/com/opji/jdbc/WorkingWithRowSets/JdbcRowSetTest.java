package com.opji.jdbc.WorkingWithRowSets;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {

	public static void main(String[] args) throws SQLException {
		
		String user ="root";
		String url ="jdbc:mysql://localhost:3306/sakila";
		String password ="surfberria";
		
		//Creamos JDBCRowSet a partir de la factoría
		RowSetFactory factory = RowSetProvider.newFactory();
		JdbcRowSet jrs = factory.createJdbcRowSet();
		
		String query = "SELECT * FROM CUSTOMER";
		jrs.setCommand(query);
		jrs.setUsername(user);
		jrs.setPassword(password);
		jrs.setUrl(url);
		jrs.execute();
		
		jrs.last(); 				// Nos posicionamos en la última linea de la tabla Customer
		jrs.updateString("FirstName", "Raquel"); // Actualizamos first name
		jrs.updateRow(); 		 // Actualiamos cambios en BBDD
		
		jrs.moveToInsertRow();
		jrs.updateInt("id_autor", 123);
		jrs.updateString("FirstName", "Juan");
		jrs.updateString("LastName", "Jordan"); 
		jrs.insertRow();
		jrs.moveToCurrentRow();

		
		
	}

}
