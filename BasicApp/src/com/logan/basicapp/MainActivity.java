package com.logan.basicapp;

import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void searchByBusNumber(View view){
		Intent nextActivity = new Intent(this, SearchByNumber.class);
		startActivity(nextActivity);
	}
	
	public void feedback(View view){
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "My Own Text");
		startActivity(emailIntent);
	}

}
