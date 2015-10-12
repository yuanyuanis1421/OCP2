package com.opji.jdbc.rowSet;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyJdbcListener implements RowSetListener {

	@Override
	public void cursorMoved(RowSetEvent arg0) {
	

	}

	@Override
	public void rowChanged(RowSetEvent event) {
		if(event.getSource() instanceof RowSet){
			try {
				((RowSet)event.getSource()).execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void rowSetChanged(RowSetEvent arg0) {
		// TODO Auto-generated method stub

	}

}
