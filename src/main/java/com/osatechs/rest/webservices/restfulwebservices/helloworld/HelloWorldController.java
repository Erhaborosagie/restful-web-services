package com.osatechs.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello")
	public String hello() {
		return "Hello in a different way";
	}
	
	@GetMapping(path="/hello2")
	public HelloMessage helloMessage() {
		return new HelloMessage("Hello in a different way");
	}
	
	@GetMapping(path="/hello/{name}")
	public String helloUser(@PathVariable String name) {
		return name;
	}
}
