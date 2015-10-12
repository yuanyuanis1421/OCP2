package com.opji.jdbc.rowSet;

import static java.lang.System.out;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UtilityPrint {
	public static void printResults(ResultSet resultSet) throws SQLException {

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
