package com.android.recruit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RecruitContactCard extends Activity{
	String[] theList;
	TextView name,phone,phone2,email,loc,rate,contract,avail,spec;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_card);
        Bundle bundle = this.getIntent().getExtras();
        theList = bundle.getStringArray("list");
        
        System.out.println(theList[0]+" = 0 ");
        System.out.println(theList[1]+" = 1 ");
        System.out.println(theList[2]+" = 2 ");
        System.out.println(theList[3]+" = 3 ");
        System.out.println(theList[4]+" = 4 ");
        System.out.println(theList[5]+" = 5 ");
        System.out.println(theList[6]+" = 6 ");
        
        name=(TextView)findViewById(R.id.nametext);
        name.setText("Name: "+theList[6]);
        phone = (TextView)findViewById(R.id.phonelink);
        phone.setText("Phone: "+theList[4]);
        phone2 = (TextView)findViewById(R.id.phonelink2);
        phone2.setText("Phone 2: ");
        email = (TextView)findViewById(R.id.email);
        email.setText("Email: "+theList[2]);
        loc = (TextView)findViewById(R.id.location);
        loc.setText("Location: "+theList[3]);
        rate = (TextView)findViewById(R.id.rate);
        rate.setText("Rate: ");
        contract = (TextView)findViewById(R.id.contract);
        contract.setText("Contract Type: "+theList[0]);
        avail = (TextView)findViewById(R.id.available);
        avail.setText("Available: "+theList[5]);
        spec = (TextView)findViewById(R.id.spec);
        spec.setText("Specialties: "+theList[1]);
	}
}
