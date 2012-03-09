package com.android.recruit.model;

import java.math.BigInteger;
import java.sql.Timestamp;


/**
 * An object storing information of a Candidate
 * @author taibo
 *
 */
public class Candidate 
{
	
	private String name;
	private String specialities;
	private int years_of_experience;
	private String email;
	private long phone;
	private long second_phone;
	private String rate;
	private String available;
	private String location;
	private int id;
	private String resume_link;
	private String linkedin_link;
	private Timestamp date_added;
	
	
	/**
	 * 
	 * @param name
	 * @param specialities
	 * @param years_of_experience
	 * @param email
	 * @param phone
	 * @param second_phone
	 * @param rate
	 * @param available
	 * @param location
	 * @param id
	 * @param resume_link
	 * @param linkedin_link
	 */
	public Candidate (String name, String specialities, int years_of_experience, String email, 
						long phone, long second_phone, String rate, String available,
						String location, int id, String resume_link, String linkedin_link,
						Timestamp date_added)
	{
		this.name = name;
		this.specialities = specialities;
		this.years_of_experience = years_of_experience;
		this.email = email;
		this.phone = phone;
		this.second_phone = second_phone;
		this.rate = rate;
		this.available = available;
		this.location = location;
		this.resume_link = resume_link;
		this.linkedin_link = linkedin_link;
		this.date_added = date_added;
	}
	
	
	
	public String getName()
	{
		return name;
	}
	
	
	public String getSpecialities()
	{
		return specialities;
	}
	
	

	public int get_years_of_experiences()
	{
		return get_years_of_experiences();
	}
	
	
	public String getEmail()
	{
		return email;
	}
	
	
	public long getPHone()
	{
		return phone;
	}
	
	
	public BigInteger getSecondPhone()
	{
		return getSecondPhone();
	}
	
	
	public String getRate()
	{
		return rate;
	}
	
	
	public String getAvailable()
	{
		return available;
	}
	
	
	public String getLocation()
	{
		return location;
	}
	
	
	public int getId()
	{
		return id;
	}
	
	
	public String get_resume_link()
	{
		return resume_link;
	}
	
	
	public String get_linkedin_link()
	{
		return linkedin_link;
	}


	public Timestamp getTimestamp()
	{
		return date_added;
	}
	
}