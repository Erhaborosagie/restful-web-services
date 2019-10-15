package com.osatechs.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//Static filtering
	@GetMapping("/filterStates")
	public States retrieveStates() {
		return new States("value1", "value2", "value3", "value4");
	}
	
	//Dynamic filtering
	@GetMapping("/dynamicfilterarea")
	public MappingJacksonValue retrieveAreas() {
		Areas areaToFilter = new Areas("Ikeja", "7000km", "LagosCentral");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name","lent");
		FilterProvider filters = new SimpleFilterProvider().addFilter("AreasFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(areaToFilter);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
	
	//Dynamic filtering
		@GetMapping("/dynamicfilterarea2")
		public MappingJacksonValue retrieveAreas2() {
			Areas areaToFilter = new Areas("Ikeja", "7000km", "LagosCentral");
			
//			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept({"name","lent"});
			
			String[] ignorableFieldNames1 = { "name", "lent" };
			FilterProvider filters = new SimpleFilterProvider().addFilter("AreasFilter", SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames1));
			
			MappingJacksonValue mapping = new MappingJacksonValue(areaToFilter);
			mapping.setFilters(filters);
			return mapping;
			
		}
}