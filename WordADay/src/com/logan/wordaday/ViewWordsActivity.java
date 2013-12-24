package com.logan.wordaday;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.logan.adapter.WordsAdapter;
import com.logan.dao.WordsDao;
import com.logan.entity.Words;

public class ViewWordsActivity extends Activity {
	private static List<String> addedWords; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_words);
		
		populateData();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_words, menu);
		return true;
	}

	private void populateData() {
		List<Words> words = WordsDao.getWords(this);
		addedWords = new ArrayList<String>();
		for(Words word : words){
			addedWords.add(word.getWord());
		}
		
		WordsAdapter adapter = new WordsAdapter(this, words);
		
		ListView wordList = (ListView)findViewById(R.id.listView1);
		wordList.setAdapter(adapter);
	}
}
