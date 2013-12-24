package com.logan.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.logan.entity.Words;

public class WordsDao {
	private static SQLHelper helper;
	
	private static final String TABLE_NAME = "words";
	
	public static void addWord(Context context,String word, String meaning){
		if(helper == null){
			helper = new SQLHelper(context);
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("word", word);
		values.put("meaning", meaning);
		db.insert(TABLE_NAME, null, values);
		
		db.close();
	}
	
	public static List<Words> getWords(Context context){
		List<Words> words = new ArrayList<Words>(); 
		
		if(helper == null){
			helper = new SQLHelper(context);
		}
		SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {"_ID","word","meaning"};
        Cursor cursor = db.query(TABLE_NAME, projection, null,null,null,null,null);
        if(cursor.moveToFirst()){
        	do{
        		Words word = new Words();
        		word.setId(cursor.getInt(0));
        		word.setWord(cursor.getString(1));
        		word.setMeaning(cursor.getString(2));
        		words.add(word);
        	}while(cursor.moveToNext());
        }
        
        db.close();
		return words;
	}
}
