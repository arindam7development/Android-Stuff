package com.example.iturnedyourwebpageintoanapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends Activity {

	MediaPlayer jabberwocky;
	WebView myWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	protected void onResume() {
		jabberwocky = MediaPlayer.create(this, R.raw.jmusic);
		jabberwocky.start();
		jabberwocky.setLooping(true);
		super.onResume();
	}

	protected void onPause() {
		// TODO Auto-generated method stub

		jabberwocky.stop();
		jabberwocky.release();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void openIMG(View v) {
		Intent i = new Intent();
		i.setClass(this, BeastActivity.class);
		startActivity(i);

	}

	public void openWIKI(View v) {
		String url = "http://en.wikipedia.org/wiki/Jabberwocky";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
	public void openNASA(View v) {
		Intent i = new Intent();
		i.setClass(this,NasaActivity.class);
		startActivity(i);

	}
	public void openWORLD(View v) {
		Intent i = new Intent();
		i.setClass(this, WorldActivity.class);
		startActivity(i);

	}
	public void playROUNDBALL(View v) {
		Intent i = new Intent();
		i.setClass(this, PlayActivity.class);
		startActivity(i);

	}
	

}
