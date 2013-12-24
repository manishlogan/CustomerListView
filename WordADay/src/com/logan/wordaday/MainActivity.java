package com.logan.wordaday;

import com.startapp.android.publish.StartAppAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final static int SUCCESS_CODE = 200;
	
	private StartAppAd startAppAd = new StartAppAd(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StartAppAd.init(this, "111147141", "211787147");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode == SUCCESS_CODE){
			Toast.makeText(this, "Word added successfully...", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void addWord(View view){
		Intent addWordIntent = new Intent(this, AddWordActivity.class);
		startAppAd.showAd();
    	startAppAd.loadAd();
		startActivityForResult(addWordIntent,0);
	}
	
	public void viewWords(View view){
		Intent viewWordsIntent = new Intent(this, ViewWordsActivity.class);
		startActivity(viewWordsIntent);
	}
	
	public void takeTest(View view){
		Intent takeTestIntent = new Intent(this, TakeTestActivity.class);
		startActivity(takeTestIntent);
	}
	
	@Override
    protected void onResume() {
    	super.onResume();
    	startAppAd.onResume();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	startAppAd.onPause();
    }
}
