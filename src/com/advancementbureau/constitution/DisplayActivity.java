package com.advancementbureau.constitution;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DisplayActivity extends PickStoreActivity {
	
	public int choice;
	public String title;
	InputStream iFile;
	String strFile = "Something went horribly wrong!";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		choice = mGameSettings.getInt(PICK_STORE, 0);
		TextView articleText = (TextView) findViewById(R.id.ArtText);
		TextView articleTitle = (TextView) findViewById(R.id.ArtTitle);
		
		switch (choice) {
		case 0:
			iFile = getResources().openRawResource(R.raw.preface);
			title = itemsTitle[0];
			break;
		}
		try {
			strFile = inputStreamToString(iFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		articleText.setText(strFile);
		articleTitle.setText(title);
		
		
	}
	
	public String inputStreamToString(InputStream is) throws IOException {
		StringBuffer sBuffer = new StringBuffer();
		DataInputStream dataIO = new DataInputStream(is);
		String strLine = null;
		while ((strLine = dataIO.readLine()) != null) {
			sBuffer.append(strLine + "\n");
		}
		dataIO.close();
		is.close();
		return sBuffer.toString();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
