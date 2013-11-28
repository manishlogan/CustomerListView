package com.logan.customlistview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_DURATION = "duration";
    static final String KEY_THUMB_URL = "thumb_url";
    
    ListView list;
    LazyAdapter adapter;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String,String>>();
        
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_ID, "1");
        map.put(KEY_TITLE, "Being Logan");
        map.put(KEY_ARTIST, "Manish Jain");
        map.put(KEY_DURATION, "5:37");
        
     // adding HashList to ArrayList
        songsList.add(map);
        
        list = (ListView)findViewById(R.id.list);
        
     // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(this, songsList);
        list.setAdapter(adapter);
        
     // Click event for single list row
        list.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
