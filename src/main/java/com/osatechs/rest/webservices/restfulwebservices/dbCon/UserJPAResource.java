package com.osatechs.rest.webservices.restfulwebservices.dbCon;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> getAllUser() {
		return userRepository.findAll();	
//		System.out.println(service.findAll());
//		return null;
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException("No user with the id-"+id);
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(methodOn(this.getClass()).getAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;
		
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUsersPost(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) 
			throw new UserNotFoundException("No user with the id-"+id);
		
		return user.get().getPosts();
		
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()) 
			throw new UserNotFoundException("No user with the id-"+id);
		
		User user = userOptional.get();
		
		post.setUser(user);
		
		System.out.println(post);
		System.out.println("That's ur post");
		
		postRepository.save(post);
		
		//Get current url and add /{id} to get new id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/jpa/users/{id}/posts").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		//Get current url and add /{id} to get new id
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/jpa/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
