package com.osatechs.rest.webservices.restfulwebservices.user;

import java.util.Date;

public class User {

	private Integer id;
	private String name;
	private Date dob;
	private String email;
	public Integer getId() {
		return id;
	}
	public User(Integer id, String name, Date dob, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
