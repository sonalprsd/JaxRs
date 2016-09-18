package com.Jax.messenger;


import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Jax.Pojo.ProfilePojo;
import com.Jax.Pojo.ProfileWrapper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public HashMap<Long,ProfilePojo> getIt() {
        return ProfileWrapper.getHash_profiles();
 	    }
    
    
    @Path("resource/1")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getProfile() {
        return "Hi Mayank!";
    }
    
    
    
    
    
    
}
