package com.Jax.Pojo;

import java.util.HashMap;

public class ProfileWrapper {
	
	static HashMap<Long,ProfilePojo> hash_profiles = new HashMap<Long,ProfilePojo>();
	
	public static HashMap<Long, ProfilePojo> getHash_profiles() {
		return hash_profiles;
	}
	public static void setHash_profiles() {
		//HashMap<Long,ProfilePojo> hash_profiles = new HashMap<Long,ProfilePojo>();
		
		ProfilePojo pf1 = new  ProfilePojo(1, "Sonal");
		ProfilePojo pf2 = new  ProfilePojo(2, "Komal");
		ProfilePojo pf3 = new  ProfilePojo(3, "Sanidh");
		ProfilePojo pf4 = new  ProfilePojo(4, "Vanshika");
		hash_profiles.put((long) 1, pf1);
		hash_profiles.put((long) 2, pf2);
		hash_profiles.put((long) 3, pf3);
		hash_profiles.put((long) 4, pf4);
		
	}
	
	
	

}
