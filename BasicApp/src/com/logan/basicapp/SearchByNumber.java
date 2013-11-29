package com.logan.basicapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchByNumber extends Activity {
	
	private static Map<String,ArrayList<String>> data; 
	
	static{
		data = new HashMap<String, ArrayList<String>>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		
		list1.add("Vandematram Icon");
		list1.add("Wadaj");
		list1.add("Maninagar");
		data.put("72", list1);
		
		list2.add("Bhagwat");
		list2.add("Prabhat Chowk");
		list2.add("Income Tax");
		data.put("67", list2);
		
		list3.add("Akhbar nagar");
		list3.add("RTO");
		list3.add("Vasna");
		data.put("501", list3);
	}

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
		List<String> stops = data.get(busNo);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stops);
		ListView listView = (ListView)findViewById(R.id.listView1);
		listView.setAdapter(adapter);
	}

}
