package com.osatechs.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	@GetMapping(value="/person", params="v=1")
	public Person1 person1() {
		return new Person1("Osagie Erhabor");
	}
	
	@GetMapping(value="/person", params="v=2")
	public Person2 person2() {
		return new Person2(new Name("Osagie","Erhabor"));
	}
	
	//Using header
	@GetMapping(value="/person/he", headers ="v=1")
	public Person1 header1() {
		return new Person1("Erhabor");
	}
	
	//Using header
	@GetMapping(value="/person/he", headers ="v=2")
	public Person2 header2() {
		return new Person2(new Name("Osagie","Erhabor"));
	}
	
	//Using header
	@GetMapping(value="/person/produces", produces ="application/v1+json")
	public Person1 produces1() {
		return new Person1("Erhabor");
	}
		
	//Using header
	@GetMapping(value="/person/produces", produces ="application/v2+json")
	public Person2 produces2() {
		return new Person2(new Name("Osagie","Erhabor"));
	}	
}
