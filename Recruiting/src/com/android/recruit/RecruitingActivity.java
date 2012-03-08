package com.android.recruit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RecruitingActivity extends Activity implements OnClickListener{
	Button contacts, calendar;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		contacts = (Button)findViewById(R.id.button1);
		calendar = (Button)findViewById(R.id.button2);
		contacts.setOnClickListener(this);
		calendar.setOnClickListener(this);
	}
	
	
	
	public void onClick(View view) {
		if(view == contacts){
			Intent i = new Intent(getBaseContext(),RecruitContacts.class);
			startActivity(i);
			finish();
		}
		if(view == calendar){
			Intent i = new Intent(getBaseContext(),RecruitCalendar.class);
			startActivity(i);
			finish();
		}
		
	}

	/**
	@Override
	public void onClick(View view) {
		if(view == contacts){
			Intent i = new Intent(getBaseContext(),RecruitContacts.class);
			startActivity(i);
			finish();
		}
		if(view == calendar){
			Intent i = new Intent(getBaseContext(),RecruitCalendar.class);
			startActivity(i);
			finish();
		}
	}
	**/
}