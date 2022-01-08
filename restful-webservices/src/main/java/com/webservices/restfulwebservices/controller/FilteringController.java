package com.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.restfulwebservices.entity.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public List<SomeBean> retrieveSomeBean() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value21","value22","value23")) ;
	}
}
