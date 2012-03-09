package com.android.databaseManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.recruit.model.Candidate;

import android.util.Log;


public class CandidateDataRetriever extends DBManager
{
	
	private static final String LOG_TAG = "CandidateDataRetriever";
	
	
	private static final String PHP_CANDIDATE_DATA_FILE_LINK = 
			"http://www.rapidconsultingusa.com/html5/apps/recruitment/candidate.php";
	
	
	private static final String REQUEST = "request";
	
	private enum CFields
	{
		
		NAME 				("name"),
		SPECIALITIES 		("specialities"),
		YEARS_OF_EXPERIENCE ("years_of_experience"),
		EMAIL 				("email"),
		PHONE				("phone"),
		SECOND_PHONE		("second_phone"),
		RATE				("rate"),
		AVAILABLE			("available"),
		LOCATION			("location"),
		ID					("id"),
		RESUME_LINK			("resume_link"),
		LINKEDIN_LINK		("linkedin_link	"),
		DATE_ADDED			("date_added");
	
		
		
		CFields(String field)
		{
			this.field = field;
		}
		
		public String getValue()
		{
			return field;
		}
		
		private String field;	
	}
	
	
	private static String getCandidateData()
	{
		ArrayList<NameValuePair> nameValuePairs = get_database_settings();
	


		InputStream is = null;
		//http post
		try
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(PHP_CANDIDATE_DATA_FILE_LINK);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();		
		}
		catch(Exception e)
		{
			Log.e("log_tag", "Error getting result " + e.toString());
		}

		String result = "";

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null){
				sb.append(line + "\n");
				Log.i(LOG_TAG, "getCandidateData().line value: " + line);
			}

			is.close();
			result = sb.toString();		
			reader.close();
			Log.i(LOG_TAG, "getCandidateData() succedded");
		}
		catch(Exception e){
			Log.e(LOG_TAG, "getCandidateData(): Error converting result " + e.toString());
		}
		
		return result;
	}
	

	public static ArrayList<Candidate> getListOfCandidates()
	{
		
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		try
		{
			JSONArray candidates_array = new JSONArray(getCandidateData());
			
			for(int i = 0; i < candidates_array.length();i++)
			{
				candidates.add(getCandidateObject(candidates_array.getJSONObject(i)));
			}
		}
		catch (Exception e)
		{
			Log.e(LOG_TAG, "getListOfCandidates(): Error converting result \n " + e.toString());
		}
		
		return candidates;
		
	}


	private static Candidate getCandidateObject(JSONObject jsonObject) {
		
		Candidate candidate = null;
	
		try
		{
			String name = 
					jsonObject.isNull(CFields.NAME.getValue()) ? "" :
						jsonObject.getString(CFields.NAME.getValue());
		
			String specialities = 
					jsonObject.isNull(CFields.SPECIALITIES.getValue()) ? "" :
				jsonObject.getString(CFields.SPECIALITIES.getValue());
			
			int years_of_experience = jsonObject.getInt(CFields.YEARS_OF_EXPERIENCE.getValue());
			
			String email = 
					jsonObject.isNull(CFields.EMAIL.getValue()) ? "" : 
						jsonObject.getString(CFields.EMAIL.getValue());
			
			long phone = jsonObject.getLong(CFields.PHONE.getValue());
			long second_phone = jsonObject.getLong(CFields.SECOND_PHONE.getValue());
			
			String rate = jsonObject.isNull(CFields.RATE.getValue()) ? "" :
				jsonObject.getString(CFields.RATE.getValue());
			
			String available = 
					jsonObject.isNull(CFields.AVAILABLE.getValue()) ?  "" :
						jsonObject.getString(CFields.AVAILABLE.getValue());
		
			String location = jsonObject.isNull(CFields.LOCATION.getValue()) ? "" :
					jsonObject.getString(CFields.LOCATION.getValue());
			
			int id = jsonObject.getInt(CFields.ID.getValue());
			
			String resume_link = jsonObject.isNull(CFields.RESUME_LINK.getValue()) ? "" :
				jsonObject.getString(CFields.RESUME_LINK.getValue());
			
			String linkedin_link = jsonObject.isNull(CFields.LINKEDIN_LINK.getValue()) ? "" :
				jsonObject.getString(CFields.LINKEDIN_LINK.getValue());
			
		//	Timestamp date_added = (Timestamp) jsonObject.get(CFields.DATE_ADDED.getValue());
			String date_added =  jsonObject.get(CFields.DATE_ADDED.getValue()).toString();
				
			candidate = new Candidate(name, specialities, years_of_experience, email, phone,
					second_phone, rate, available, location, id, resume_link, linkedin_link,
					date_added);
		}
		catch (JSONException e)
		{
			Log.e(LOG_TAG, "getCandidateObject(): " + e.getMessage());
		}
		return candidate;
	}
	
}
