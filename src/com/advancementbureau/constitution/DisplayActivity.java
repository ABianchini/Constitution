package com.advancementbureau.constitution;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends PickStoreActivity {
	
	public int choice;
	public String title;
	InputStream iFile;
	String strFile = "Something went horribly wrong!";
	
	String [] items = {"Preface","Article I: Work","Article II: People","Article III: Adventure","Article IV: Freedom","Article V: Religion and Morality","Article VI: Analysis","Article VII: Amendments","Article VIII: Adoption","More Info"};
	
	String [] itemsTitle = {"Preface","Work","People","Adventure","Freedom","Religion and Morality","Analysis","Amendments","Adoption","More Info"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		choice = mGameSettings.getInt(PICK_STORE, 0);
		TextView articleText = (TextView) findViewById(R.id.ArtText);
		TextView articleTitle = (TextView) findViewById(R.id.ArtTitle);
		
        ActionBar actionBar2 = getActionBar();
        actionBar2.setDisplayHomeAsUpEnabled(true);
        actionBar2.setTitle(itemsTitle[choice]);
		
		switch (choice) {
		case 0:
			iFile = getResources().openRawResource(R.raw.preface);
			break;
		case 1:
			iFile = getResources().openRawResource(R.raw.work);
			break;
		case 2:
			iFile = getResources().openRawResource(R.raw.people);
			break;
		case 3:
			iFile = getResources().openRawResource(R.raw.adventure);
			break;
		case 4:
			iFile = getResources().openRawResource(R.raw.freedom);
			break;
		case 5:
			iFile = getResources().openRawResource(R.raw.relandmor);
			break;
		case 6:
			iFile = getResources().openRawResource(R.raw.analysis);
			break;
		case 7:
			iFile = getResources().openRawResource(R.raw.amendments);
			break;
		case 8:
			iFile = getResources().openRawResource(R.raw.adoption);
			break;
		case 9:
			iFile = getResources().openRawResource(R.raw.moreinfo);
		}
		try {
			strFile = inputStreamToString(iFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		title = itemsTitle[choice];
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

}
