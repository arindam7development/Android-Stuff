package com.example.iturnedyourwebpageintoanapp;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;


public class PlayActivity extends Activity {

	 WebView myWebView;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		 myWebView = (WebView) findViewById(R.id.webView1);
	        myWebView.getSettings().setBuiltInZoomControls(true);
	        myWebView.getSettings().setJavaScriptEnabled(true);
	        myWebView.getSettings().setDomStorageEnabled(true);
	        myWebView.loadUrl("file:///android_asset/roundball.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play, menu);
		return true;
	}
	 public boolean onKeyDown(int keyCode,KeyEvent event){
	    	
			if((keyCode==KeyEvent.KEYCODE_BACK)&& myWebView.canGoBack()){
	    		myWebView.goBack();
	    		return true;
	    	}
	    		
	    	return super.onKeyDown(keyCode, event);
	    }
	    

}
