package com.osatechs.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoServices service;
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return service.findAll();		
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user==null) 
			throw new UserNotFoundException("No user with the id-"+id);
		return user;
		
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = service.deleteUser(id);
		if(user==null) 
			throw new UserNotFoundException("No user with the id-"+id);
		return "user " + user.getName() + " with an ID of " + user.getId() + " was succesfully deleted";
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		//Get current url and add /{id} to get new id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
