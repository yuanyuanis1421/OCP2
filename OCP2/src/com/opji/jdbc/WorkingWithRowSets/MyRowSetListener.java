package com.opji.jdbc.WorkingWithRowSets;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements RowSetListener {
	@Override
	public void rowChanged(RowSetEvent event) { // A row changed:	
									// updated, inserted
									// or deleted.
		if (event.getSource() instanceof RowSet) {
			try {
			((RowSet) event.getSource()).execute(); 												// Re-execute the
									// query, refreshing
									// the results
			} catch (SQLException se) {
				System.out.println("SQLException during execute");
			}
		}
	}
	@Override
	public void cursorMoved(RowSetEvent event) { // Cursor moved
	
	}
	@Override
	public void rowSetChanged(RowSetEvent event) { // Entire RowSet
										// changed
	}
}