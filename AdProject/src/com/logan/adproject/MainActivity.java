package com.logan.adproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.startapp.android.publish.StartAppAd;

public class MainActivity extends Activity {

	private StartAppAd startAppAd = new StartAppAd(this);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppAd.init(this, "111147141", "211787147");
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
    	Intent nextActivity = new Intent(this, DummyActivity.class);
    	startAppAd.showAd();
    	startAppAd.loadAd();
    	startActivity(nextActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
