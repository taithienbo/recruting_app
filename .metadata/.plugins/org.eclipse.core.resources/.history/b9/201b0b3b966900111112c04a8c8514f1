package com.android.recruit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class RecruitContacts extends ListActivity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_list);
		contacts();
		populateList();
	}
	private static final ArrayList<HashMap<String,String>> list =
			new ArrayList<HashMap<String,String>>();
	
	private void populateList() {
		System.out.println(list+ "list");
		SimpleAdapter adapter = new SimpleAdapter(
				this,
				list,
				R.layout.custom_row_view,
				new String[] {"name","loc","stat","spec"},
				new int[] {R.id.name_contact,R.id.location_contact, R.id.available_contact, R.id.specialty_inbox}
				);
		System.out.println(list+ "list2");
		setListAdapter(adapter);
	}
	
	private void contacts(){
		HashMap<String,String> temp = new HashMap<String,String>();
		temp.put("name", "Michael Keaton");
		temp.put("loc", "Irvine");
		temp.put("stat", "Available");
		temp.put("spec", "Android Development, iOS Development");
		temp.put("tphone", "949-323-2050");
		temp.put("uemail", "thekeaton@gmail.com");
		temp.put("contr", "full time");
		list.add(temp);
		
		HashMap<String,String> temp2 = new HashMap<String,String>();
		temp2.put("name", "Jonathan Brandis");
		temp2.put("loc", "Los Angeles");
		temp2.put("stat", "Available");
		temp2.put("spec", "Javascript, HTML5");
		temp2.put("tphone", "949-323-2050");
		temp2.put("uemail", "thekeaton@gmail.com");
		temp2.put("contr", "full time");
		list.add(temp2);
		
		HashMap<String,String> temp3 = new HashMap<String,String>();
		temp3.put("name", "Richard Dean Anderson");
		temp3.put("loc", "San Diego");
		temp3.put("stat", "Available");
		temp3.put("spec", "Android Development, iOS Development, Blackberry Development");
		temp3.put("tphone", "949-323-2050");
		temp3.put("uemail", "thekeaton@gmail.com");
		temp3.put("contr", "full time");
		list.add(temp3);
		
		HashMap<String,String> temp4 = new HashMap<String,String>();
		temp4.put("name", "David Bowie");
		temp4.put("loc", "Irvine");
		temp4.put("stat", "Available");
		temp4.put("spec", "CSS, iOS Development, HTML");
		temp4.put("tphone", "949-323-2050");
		temp4.put("uemail", "thekeaton@gmail.com");
		temp4.put("contr", "full time");
		list.add(temp4);
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {

		super.onListItemClick(l, v, position, id);
		Object o = this.getListAdapter().getItem(position);
		Bundle bundle = new Bundle();
		HashMap<String,String> hm = (HashMap<String, String>) o;
		bundle.putStringArray("list", hm.values().toArray(new String[7]));
		Intent i = new Intent(getBaseContext(),RecruitContactCard.class);
		i.putExtras(bundle);
    	startActivity(i);
	}
}