package com.osatechs.rest.webservices.restfulwebservices.versioning;

public class Name {
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Name(String firstName, String lastName) {
		super();
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
