package com.Jax.messenger;


import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import com.Jax.Pojo.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("allProfiles")
public class MessageResource {
	
	  @GET
	  @Produces(MediaType.APPLICATION_XML)
	  public  List<ProfilePojo> getIt() {
		//  ProfileWrapper.setHash_profiles();
         return  ProfileWrapper.getHash_profiles();
          
	    }
	  
	  @GET
	  @Path("/{messageId}")
	  @Produces(MediaType.APPLICATION_XML)
	  public ProfilePojo getId(@PathParam("messageId")int Id)
	  {
		  
		return ProfileWrapper.getProfile(Id-1);
	  }

	

}
