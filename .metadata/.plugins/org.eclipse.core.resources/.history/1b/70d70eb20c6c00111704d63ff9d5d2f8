package com.android.recruit;

import java.util.ArrayList;
import java.util.HashMap;

import com.android.databaseManager.CandidateDataRetriever;
import com.android.recruit.model.Candidate;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


	
public class RecruitContacts extends Activity{
	
	private static ArrayList<Candidate> candidates;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_list);
		
		ListView lv = (ListView) findViewById(R.id.listView_contact_list);
		
		candidates = CandidateDataRetriever.getListOfCandidates();
		
	
		
		
	
		lv.setAdapter(new MyListContentAdapter(this));
		
	}
	
	

	private class MyListContentAdapter extends BaseAdapter implements Filterable
	{
		private LayoutInflater	mInflater;
		private Context		context;



		public MyListContentAdapter ( Context context )
		{
			mInflater = LayoutInflater.from ( context );
			this.context = context;
		}



		public int getCount ( )
		{
			// TODO Auto-generated method stub
			return candidates.size ( );
		}



		public Object getItem ( int position )
		{
			// TODO Auto-generated method stub
			return candidates.get ( position );
		}



		public long getItemId ( int position )
		{
			// TODO Auto-generated method stub
			return candidates.get( position ).getId();
		}



		/**
		 * 
		 * @param position
		 * @param convertView
		 * @param parent
		 * @return
		 */
		public View getView ( final int position, View convertView, ViewGroup parent )
		{
			ViewHolder holder;

			final Candidate currCandidate = candidates.get ( position );
			if ( convertView == null )
			{
				
				// To save space, status will not be shown in the contacts page
				// It will be shown when the user clicks on a contact 
				// To enable status preview in contact page, uncomment these
				// and also uncomment the comments in contact_row_layout.xml
				
				convertView = mInflater.inflate ( R.layout.contact_row_layout, null );
				holder = new ViewHolder ( currCandidate, (TextView) convertView.findViewById(R.id.textView_contact_name),
									(TextView) convertView.findViewById(R.id.textVew_contact_skills),
						//			(TextView) convertView.findViewById(R.id.textView_contact_status),
									(TextView) convertView.findViewById(R.id.textView_contact_date_added));

				convertView.setTag ( holder );
			}
			else
			{
				holder = (ViewHolder) convertView.getTag ( );
			}

			TextView contact_name = holder.contact_name;
			if(contact_name == null)
			{
				
				String tag = "RecruitContacts.MyListContentAdapter.getView()";
				Log.e(tag , " contact_name is null");
			}
			holder.contact_name.setText(currCandidate.getName());
			holder.contact_skills.setText(currCandidate.getSpecialities());
		//	holder.contact_status.setText(currCandidate.getAvailable());
			holder.contact_date_added.setText(currCandidate.getTimestamp().toString());

			convertView.setOnClickListener(new OnClickListener(){
				public void onClick(View v)
				{
					Intent intent = new Intent(v.getContext(), RecruitContactCard.class);
					startActivity(intent);
				}
			});
			
			return convertView;
		}



		public Filter getFilter ( )
		{
			return null;
		}

	}

	class ViewHolder
	{
		Candidate currentCand;
		TextView	contact_name;
		TextView	contact_skills;
	//	TextView	contact_status;
		TextView	contact_date_added;



		public ViewHolder ( Candidate candidate, TextView contact_name, TextView contact_skills,
				//TextView contact_status, 
								TextView contact_date_added )
		{
			this.currentCand = candidate;
			this.contact_name = contact_name;
			this.contact_skills = contact_skills;
			//this.contact_status = contact_status;
			this.contact_date_added = contact_date_added;
		}

	}


	
	
	/**
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
	
	**/
}