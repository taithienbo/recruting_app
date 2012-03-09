package com.android.login;

import com.android.recruit.R;
import com.android.recruit.RecruitingActivity;
import com.android.recruit.R.id;
import com.android.recruit.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RecruitLogin extends Activity implements OnClickListener{

	Button login_button,back,exit;
	EditText uname, pword;

	private static final String LOG_TAG = "RecruitLogin";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		uname = (EditText)findViewById(R.id.login_user_name);
		pword = (EditText)findViewById(R.id.login_user_pass);

		login_button = (Button)findViewById(R.id.button_login);
		login_button.setOnClickListener(this);
	}

	//  @Override
	public void onClick(View view) 
	{
		
		if(view == login_button)
		{
			// LoginAuthentication auth = new LoginAuthentication();
			// auth.execute(new String[] { "http://www.rapidconsultingusa.com/html5/simonHuynh/rapidSuite/login.php" });
			if(Authentication.passAuthentication(uname.getText().toString().trim(), pword.getText().toString().trim()))
			{
				Log.d(LOG_TAG, "authenticated");
				Intent i = new Intent(getBaseContext(),RecruitingActivity.class);
				startActivity(i);
				//	finish();			// User should be able to go back to this login screen by pressing the back button
			}  
			else
			{
				Log.i(LOG_TAG, "authentication failed.");
			}
		}
		else
		{
			Log.d(LOG_TAG, "View is not login button");
		}
		

	}


}
