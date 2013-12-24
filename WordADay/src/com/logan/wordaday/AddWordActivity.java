package com.logan.wordaday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.logan.dao.WordsDao;
import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;

public class AddWordActivity extends Activity {
	private StartAppAd startAppAd = new StartAppAd(this);

	private final static int SUCCESS_CODE = 200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_word);
		StartAppAd.init(this, "111147141", "211787147");
		
		startAppAd.loadAd(new AdEventListener() {
			
			@Override
			public void onReceiveAd(Ad arg0) {
				System.out.println("Ad recieved");
				
				startAppAd.showAd();
			}
			
			@Override
			public void onFailedToReceiveAd(Ad arg0) {
				System.out.println("Failed to load ad");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_word, menu);
		return true;
	}
	
	public void add(View view){
		EditText wordText = (EditText)findViewById(R.id.wordText);
		EditText meaningText = (EditText)findViewById(R.id.meaningText);
		
		String word = wordText.getText().toString();
		String meaning = meaningText.getText().toString();
		
		WordsDao.addWord(this, word, meaning);
		setResult(SUCCESS_CODE);
		finish();
	}
}
