package com.opji.jdbc.transacciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class SavePointTest {
	public static void main(String... args) throws SQLException {
		
		
		Connection conn = ConnectionDefault.getConnectionDeafault();
		conn.setAutoCommit(false); // Start a transaction
		Statement stmt = conn.createStatement();

		@SuppressWarnings("unused")
		int result1, result2;

		String query1 = "INSERT INTO Author " +"VALUES(1031, 'Rachel', 'McGinn')";
		String query2 = "INSERT INTO Book " +"VALUES('0554466789', " +"'My American Dolls', '2012-08-31'," +
						"'Paperback', 7.95)";

		
		Savepoint sp1 = null;
		try {
			result1 = stmt.executeUpdate(query1);
			result2 = stmt.executeUpdate(query2);
			
			sp1 = conn.setSavepoint(); // Create a Savepoint
							// for the two inserts so far
		} catch (SQLException ex) {
			conn.rollback(); // If we did not successfully insert
			throw new SQLException("fail"); // one record in author and book,
									// rollback the transaction and
									// throw an exception
		}
			String query3 = "INSERT INTO Books_by_Author " +
						"VALUES(1031,'0554466789')";
		try {
			stmt.executeUpdate(query3);
			conn.commit(); // If the whole thing worked, commit
		} catch (SQLException ex) {
			conn.rollback(sp1);  // If the join table insert failed, that's
						     // ok, rollback to the Savepoint (rollback
		                          // the insert into Books_by_Author)
			conn.commit();       // and commit from there.
		}
	}
}
