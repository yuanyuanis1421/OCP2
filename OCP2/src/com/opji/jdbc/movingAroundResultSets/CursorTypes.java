package com.opji.jdbc.movingAroundResultSets;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.lang.System.out;

import com.opji.jdbc.driverManager.ConnectionDefault;

public class CursorTypes {

	public static void main(String[] args) throws SQLException {
		
		
		Connection conn = ConnectionDefault.getConnectionDeafault();
		DatabaseMetaData databaseMetaData = conn.getMetaData();
		
		if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
			out.println("Soporta TYPE_FORWARD_ONLY");
			if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
				out.println("y soporta CONCUR_UPDATABLE");
			}
		}
		
		
		if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
			out.println("Soporta TYPE_SCROLL_INSENSITIVE");
			if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				out.println("y soporta CONCUR_UPDATABLE");
			}
		}
		
		if(databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
			out.println("Soporta TYPE_SCROLL_SENSITIVE");
			if(databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
				out.println("y soporta CONCUR_UPDATABLE");
			}
		}

	}

}
