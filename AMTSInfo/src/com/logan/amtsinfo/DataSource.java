package com.logan.amtsinfo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {
	
	private SQLiteDatabase database;
	private MyDBHelper dbHelper;
	  
	public DataSource(Context context) {
		dbHelper = new MyDBHelper(context);
	}
	
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	  }
	
	public void close() {
	    dbHelper.close();
	  }
	
	public List<String> getAllBus(String busNo) {
	    List<String> comments = new ArrayList<String>();

	    String[] columns= {"BusNo"};
	    
	    Cursor cursor = database.query("Bus",
	    		columns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	comments.add(cursor.getString(0));
	    }
	    
	    cursor.close();
	    return comments;
	  }
}
