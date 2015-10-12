package com.opji.jdbc.transacciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class FirstTransaction {

	public static void main(String[] args) {
		Connection conn = ConnectionDefault.getConnectionDeafault();
		try {
			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();
			stmt.execute("INSERT INTO Author VALUES(1031, 'Rachel', 'McGinn')");
			stmt.execute("INSERT INTO Book VALUES('0554466789','My American Dolls', '2012-08-31','Paperback', 7.95)");
			stmt.execute(("INSERT INTO Books_by_Author VALUES(1031,'0554466789')"));
			conn.commit(); // Commit the current transaction and
						   // start another
		} catch (SQLException e) {
			
			try {
				conn.rollback();
			} catch (SQLException e1) {}
		} 

	}

}
