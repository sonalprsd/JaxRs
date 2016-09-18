package com.Jax.messenger;


import java.util.HashMap;

import javax.ws.rs.GET;
import com.Jax.Pojo.*;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("allMessages")
public class MessageResource {
	
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public HashMap<Long,ProfilePojo> getIt() {
		  ProfileWrapper.setHash_profiles();
       return ProfileWrapper.getHash_profiles();
	    }
	  
	  @GET
	  @Path("/{messageId}")
	  @Produces(MediaType.TEXT_PLAIN)
	  public int getId(@PathParam("messageId")int Id)
	  {
		  
		return Id;
	  }

	

}
