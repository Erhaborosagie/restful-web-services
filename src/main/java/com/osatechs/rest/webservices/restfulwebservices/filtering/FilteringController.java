package com.osatechs.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filterStates")
	public States retrieveStates() {
		return new States("value1", "value2", "value3", "value4");
	}
}