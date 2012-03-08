package com.android.recruit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RecruitLogin extends Activity implements OnClickListener{
	Button ok,back,exit;
	EditText uname, pword;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        uname = (EditText)findViewById(R.id.editText1);
        pword = (EditText)findViewById(R.id.editText2);
        
        ok = (Button)findViewById(R.id.button1);
        ok.setOnClickListener(this);
    }
    
  //  @Override
    public void onClick(View view) {
    	if(view == ok){
       // LoginAuthentication auth = new LoginAuthentication();
       // auth.execute(new String[] { "http://www.rapidconsultingusa.com/html5/simonHuynh/rapidSuite/login.php" });
    	  if(uname.getText().toString().equals("user") && pword.getText().toString().equals("pass")){
    		  Intent i = new Intent(getBaseContext(),RecruitingActivity.class);
    	    	startActivity(i);
    	    	finish();
    	  }  
      }
    }
}