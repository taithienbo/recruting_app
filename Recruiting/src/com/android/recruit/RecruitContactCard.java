package com.android.recruit;

import com.android.recruit.RecruitContacts.ViewHolder;
import com.android.recruit.model.Candidate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;

public class RecruitContactCard extends Activity
{
/**
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
	**/
	
	
	private String[] fields;
	
//	private Candidate candidate;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_card_list_layout);
		
		ListView lv = (ListView) findViewById(R.id.listView_contact_card_profile_info);
		
		
		
		fields = getResources().getStringArray(R.array.string_array_contact_card);
		
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
			return fields.length;
		}



		public Object getItem ( int position )
		{
			// TODO Auto-generated method stub
			return fields[position];
		}



		public long getItemId ( int position )
		{
			// TODO Auto-generated method stub
			return 0;
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

			if ( convertView == null )
			{
				
				// To save space, status will not be shown in the contacts page
				// It will be shown when the user clicks on a contact 
				// To enable status preview in contact page, uncomment these
				// and also uncomment the comments in contact_row_layout.xml
				
				convertView = mInflater.inflate ( R.layout.contact_card_row_layout, null );
				holder = new ViewHolder ( (TextView) convertView.findViewById(R.id.textView_contact_card_field),
									(TextView) convertView.findViewById(R.id.textView_contact_card_value));

				convertView.setTag ( holder );
			}
			else
			{
				holder = (ViewHolder) convertView.getTag ( );
			}

			holder.contact_card_field.setText(fields[position]);
			holder.contact_card_value.setText("Test value");
			
			return convertView;
		}



		public Filter getFilter ( )
		{
			return null;
		}

	}
	

	class ViewHolder
	{
	
		TextView	contact_card_field;
		TextView	contact_card_value;
	

		public ViewHolder ( TextView contact_card_field, TextView contact_card_value)
			
		{
			this.contact_card_field = contact_card_field;
			this.contact_card_value = contact_card_value;
		}

	}


}
