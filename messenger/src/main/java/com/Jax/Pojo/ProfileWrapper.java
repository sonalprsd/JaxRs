package com.Jax.Pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class ProfileWrapper {
	
	//static HashMap<Long,ProfilePojo> hash_profiles = new HashMap<Long,ProfilePojo>();
	static List<ProfilePojo> hash_profiles = new ArrayList<>();
	public static List<ProfilePojo> getHash_profiles() {
		ProfilePojo pf1 = new  ProfilePojo(1, "Sonal");
		ProfilePojo pf2 = new  ProfilePojo(2, "Komal");
		ProfilePojo pf3 = new  ProfilePojo(3, "Sanidh");
		ProfilePojo pf4 = new  ProfilePojo(4, "Vanshika");
		hash_profiles.add(pf1);
		hash_profiles.add(pf2);
		hash_profiles.add(pf3);
		hash_profiles.add(pf4);
		return hash_profiles;
	}
	public static void setHash_profiles() {
		//HashMap<Long,ProfilePojo> hash_profiles = new HashMap<Long,ProfilePojo>();
		
		ProfilePojo pf1 = new  ProfilePojo(1, "Sonal");
		ProfilePojo pf2 = new  ProfilePojo(2, "Komal");
		ProfilePojo pf3 = new  ProfilePojo(3, "Sanidh");
		ProfilePojo pf4 = new  ProfilePojo(4, "Vanshika");
		
		
	}
	
	public static ProfilePojo getProfile(int id)
	{
		return hash_profiles.get(id);
	}
	
	
	

}
