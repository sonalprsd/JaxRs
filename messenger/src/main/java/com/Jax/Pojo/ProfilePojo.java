package com.Jax.Pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfilePojo {

	private int id;
	private String name;
public	ProfilePojo()
	 {
		 
	 }
	
 public	ProfilePojo(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
