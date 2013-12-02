package com.logan.basicapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchByNumber extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_by_number);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_by_number, menu);
		return true;
	}
	
	public void searchByBusNumber(View view){
		EditText text = (EditText)findViewById(R.id.editText1);
		String busNo = text.getText().toString();
		List<String> stops = ApplicationUtility.data.get(busNo);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stops);
		ListView listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(adapter);
	}

}
