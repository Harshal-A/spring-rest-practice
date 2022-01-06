package com.webservices.restfulwebservices.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.boot.jaxb.hbm.internal.EntityModeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.restfulwebservices.entity.User;
import com.webservices.restfulwebservices.exception.UserCreationException;
import com.webservices.restfulwebservices.exception.UserNotFoundException;
import com.webservices.restfulwebservices.repository.UserDAOService;

@RestController
public class UserController {

	@Autowired
	private UserDAOService userDAOService;
	
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDAOService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable("id") int id){
		User user=userDAOService.findOne(id);
		if(user==null) {
			throw new UserNotFoundException("User not found with id - "+id);
		}
		EntityModel<User> model=EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers=WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		if(user.getName()==null || user.getBirthDate()==null) {
			String message=(user.getName()==null)? "username is null":"birthdate is null";
			throw new UserCreationException(message);
		}
		User savedUser= userDAOService.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId) {
		User user=userDAOService.deleteById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
