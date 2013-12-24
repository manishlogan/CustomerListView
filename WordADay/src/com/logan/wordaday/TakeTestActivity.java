package com.logan.wordaday;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class TakeTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take_test, menu);
		return true;
	}
	
	public void weeklyTest(View view){
		
	}
	
	public void monthlyTest(View view){
		
	}
}
