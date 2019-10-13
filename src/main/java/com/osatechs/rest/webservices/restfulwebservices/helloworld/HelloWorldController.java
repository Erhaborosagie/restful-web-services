package com.osatechs.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
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
	
	@GetMapping(path="/hello-intl")
	public String helloIntl(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null, locale);
	}
	
	@GetMapping(path="/hello/{name}")
	public String helloUser(@PathVariable String name) {
		return name;
	}
}
