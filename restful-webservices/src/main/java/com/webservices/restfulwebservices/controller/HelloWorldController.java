package com.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.restfulwebservices.entity.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping("/helloworld")
	public String helloWorld() {
		return "hello World";
	}
	
	@GetMapping("/helloworldbean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/helloworldbean/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable("name") String name) {
		return new HelloWorldBean("Hello, "+name);
	}
	
	@GetMapping("/helloworld-inter")
	public String helloWorldInternationalized(
			@RequestHeader(name = "Accept-language",required = false)
			Locale locale) {
		return "hello World";
	}
}
