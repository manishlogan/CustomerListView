package com.logan.adproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;

public class DummyActivity extends Activity {

	private StartAppAd startAppAd = new StartAppAd(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StartAppAd.init(this, "111147141", "211787147");
		setContentView(R.layout.activity_dummy);
		
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
		getMenuInflater().inflate(R.menu.dummy, menu);
		return true;
	}

}
