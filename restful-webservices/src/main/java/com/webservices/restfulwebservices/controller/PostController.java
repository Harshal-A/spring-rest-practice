package com.webservices.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.restfulwebservices.entity.Post;
import com.webservices.restfulwebservices.entity.User;
import com.webservices.restfulwebservices.exception.UserCreationException;
import com.webservices.restfulwebservices.exception.UserNotFoundException;
import com.webservices.restfulwebservices.repository.PostDAOService;
import com.webservices.restfulwebservices.repository.UserDAOService;

@RestController
public class PostController {
	
	@Autowired
	private PostDAOService postDAOService;

	@GetMapping("/users/{userId}/posts")
	public List<Post> getAllPosts(@PathVariable("userId") int userId){
		return postDAOService.findAll(userId);
	}
	
	@GetMapping("/users/{userId}/posts/{id}")
	public Post getPost(@PathVariable("userId") int userId,@PathVariable("id") int postId){
		return postDAOService.findOne(userId,postId);
	}
	
	@PostMapping("/users/{userId}/posts")
	public ResponseEntity<Post> addPost(@PathVariable("userId") int userId,@RequestBody Post post) {
		Post newPost=postDAOService.save(userId, post);
		return new ResponseEntity<Post>(newPost, HttpStatus.CREATED);
	}
}
