package com.advancementbureau.constitution;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends PickStoreActivity {
	
	String [] items = {"Preface","Article I: Work","Article II: People","Article III: Adventure","Article IV: Freedom","Article V: Religion and Morality","Article VI: Analysis","Article VII: Amendments","Article VIII: Adoption","More Info"};
	
	String [] itemsTitle = {"Preface","Work","People","Adventure","Freedom","Religion and Morality","Analysis","Amendments","Adoption","More Info"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView menuList = (ListView) findViewById(R.id.ListView_Menu);
		mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		
		//mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		
		ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
		menuList.setAdapter(adapt);
		
		menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
        		Editor editor = mGameSettings.edit();
        		editor.putInt(PICK_STORE, position);
        		editor.commit();
        		startActivity(new Intent(MainActivity.this, DisplayActivity.class));
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
