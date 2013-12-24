package com.logan.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper{
	
	private static final int DB_VERSION = 1;
	
	private static final String DB_NAME = "Words";
	
	private static final String CREATE_WORDS_TABLE = "create table " +
			"words (_ID INTEGER PRIMARY KEY AUTOINCREMENT , word TEXT, meaning TEXT)";
	
	public SQLHelper(Context context) {
		super(context,DB_NAME,null,DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_WORDS_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
		// TODO Auto-generated method stub
	}
}
