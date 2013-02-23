package com.advancementbureau.constitution;

import android.app.Activity;
import android.content.SharedPreferences;

public class PickStoreActivity extends Activity {

	SharedPreferences mGameSettings;
	
	public static final String GAME_PREFERENCES = "GamePrefs";
	public static final String PICK_STORE = "artPick";
	
	String [] items = {
			getResources().getString(R.string.preface_art),
			getResources().getString(R.string.work_art),
			getResources().getString(R.string.people_art),
			getResources().getString(R.string.adventure_art),
			getResources().getString(R.string.freedom_art),
			getResources().getString(R.string.relandmor_art),
			getResources().getString(R.string.analysis_art),
			getResources().getString(R.string.amentments_art),
			getResources().getString(R.string.adoption_art),
			getResources().getString(R.string.moreinfo)
	};
	
	String [] itemsTitle = {
			getResources().getString(R.string.preface),
			getResources().getString(R.string.work),
			getResources().getString(R.string.people),
			getResources().getString(R.string.adventure),
			getResources().getString(R.string.freedom),
			getResources().getString(R.string.relandmor),
			getResources().getString(R.string.analysis),
			getResources().getString(R.string.amentments),
			getResources().getString(R.string.adoption),
			getResources().getString(R.string.moreinfo)
	};

}
