package com.osatechs.rest.webservices.restfulwebservices.dbCon;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The user details")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="name should have at least two characters")
	@ApiModelProperty(notes="name should have at least two characters")
	private String name;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Past
	@ApiModelProperty(notes="Birth dates should be in the past")
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
