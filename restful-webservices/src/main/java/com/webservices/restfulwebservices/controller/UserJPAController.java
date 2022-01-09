package com.webservices.restfulwebservices.controller;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.webservices.restfulwebservices.entity.Post;
import com.webservices.restfulwebservices.entity.User;
import com.webservices.restfulwebservices.exception.UserCreationException;
import com.webservices.restfulwebservices.exception.UserNotFoundException;
import com.webservices.restfulwebservices.repository.PostRepository;
import com.webservices.restfulwebservices.repository.UserDAOService;
import com.webservices.restfulwebservices.repository.UserRepository;

@RestController
public class UserJPAController {	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable("id") int id){
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found with id - "+id);
		}
		EntityModel<User> model=EntityModel.of(user.get());
		WebMvcLinkBuilder linkToUsers=WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		if(user.getName()==null || user.getBirthDate()==null) {
			String message=(user.getName()==null)? "username is null":"birthdate is null";
			throw new UserCreationException(message);
		}
		User savedUser= userRepository.save(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/jpa/users/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		userRepository.deleteById(userId);
	}
	
	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> getAllPosts(@PathVariable("userId") int userId){
		Optional<User> user=userRepository.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found if : "+userId);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<Post> createPost(@PathVariable("userId") int userId, @RequestBody Post post){
		Optional<User> optionalUser=userRepository.findById(userId);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found if : "+userId);
		}
		User user=optionalUser.get();
		post.setUser(user);
		postRepository.save(post);	
		
	URI location = ServletUriComponentsBuilder
	.fromCurrentRequest()
	.path("/{userId}")
	.buildAndExpand(post.getId()).toUri();
		
		
//	 ResponseEntity.created(location).build();
	 return ResponseEntity.created(location).body(post);
	}
	
}
