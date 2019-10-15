package com.osatechs.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("AreasFilter")
public class Areas {

	private String name;
	private String lent;
	private String senate;
	
	public Areas(String name, String lent, String senate) {
		super();
		this.name = name;
		this.lent = lent;
		this.senate = senate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLent() {
		return lent;
	}
	public void setLent(String lent) {
		this.lent = lent;
	}
	public String getSenate() {
		return senate;
	}
	public void setSenate(String senate) {
		this.senate = senate;
	}

}
