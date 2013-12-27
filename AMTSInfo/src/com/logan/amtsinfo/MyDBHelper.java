package com.logan.amtsinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{
 
	private static final String DATABASE_NAME = "amts.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREATE_BUS_TABLE = "create table "
		      + "Bus" + "(" + "id"
		      + " integer primary key autoincrement, " + "BusNo"
		      + " text not null);";
	
	private static final String CREATE_STOPS_TABLE = "create table "
		      + "Stops" + "(" + "id"
		      + " integer primary key autoincrement, " + "Stop"
		      + " text not null);";
	
	private static final String CREATE_ROUTE_TABLE = "create table "
		      + "Route" + "(" + "id"
		      + " integer primary key autoincrement, " + "BusID"
		      + " integer, StopID integer, sequence integer);";
	
	public MyDBHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	@Override
public void onCreate(SQLiteDatabase database) {
	System.out.println("Creating DB");
	database.execSQL(CREATE_BUS_TABLE);
	database.execSQL(CREATE_STOPS_TABLE);
	database.execSQL(CREATE_ROUTE_TABLE);
	
	System.out.println("Inserting bus nos.");
	for(String busNo : ApplicationUtility.data.keySet()){
		ContentValues values = new ContentValues();
		values.put("BusNo", busNo);
		database.insert("Bus", null, values);
	}
	
	System.out.println("Completed Inserting bus nos.");
}
 
 	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 		System.out.println("Upgrading DB");
 		db.execSQL("drop Bus;");
 		db.execSQL("drop stops");
 		db.execSQL("drop route");
 		onCreate(db);
	}
}
