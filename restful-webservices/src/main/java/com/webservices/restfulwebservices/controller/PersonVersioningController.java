package com.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.restfulwebservices.entity.Name;
import com.webservices.restfulwebservices.entity.PersonV1;
import com.webservices.restfulwebservices.entity.PersonV2;

@RestController
public class PersonVersioningController {
	
/*URL VERSIONING*/	
/*
 * @GetMapping(value = "/v1/person") public PersonV1 personV1() { return new
 * PersonV1("Bob Charlie"); }
 * 
 * @GetMapping(value = "/v2/person") public PersonV2 personV2() { return new
 * PersonV2(new Name("Bob", "Charlie"));
 */

	/*param versioning*/
	/*
	 * @GetMapping(value = "/person/param",params = "version=1") public PersonV1
	 * paramV1() { return new PersonV1("Bob Charlie"); }
	 * 
	 * @GetMapping(value = "/person/param",params = "version=2") public PersonV2
	 * paramV2() { return new PersonV2(new Name("Bob", "Charlie")); }
	 */
	
/*HEADER VERSIONING*/	

/*
 * @GetMapping(value = "/person/header",headers = "X-API-VERSION=1") public
 * PersonV1 headerV1() { return new PersonV1("Bob Charlie"); }
 * 
 * @GetMapping(value = "/person/header",headers = "X-API-VERSION=2") public
 * PersonV2 headerV2() { return new PersonV2(new Name("Bob", "Charlie")); }
 */
	/*ACCEPT VERSIONING*/
	@GetMapping(value =  "/person/produces",produces = "application/v1+json")
	public PersonV1 produceV1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(value =  "/person/produces",produces = "application/v2+json")
	public PersonV2 produceV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
 
}
