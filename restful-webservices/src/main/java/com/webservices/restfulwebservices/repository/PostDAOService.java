package com.webservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.restfulwebservices.entity.Post;
import com.webservices.restfulwebservices.entity.User;
import com.webservices.restfulwebservices.exception.UserNotFoundException;

@Service
public class PostDAOService {

	private static List<Post> posts=new ArrayList<>();
	
	
	@Autowired
	private UserDAOService userDAOService;

	
//	public List<Post> findAll(int userId){
//		User user=userDAOService.findOne(userId);
//		if(user==null) {
//			throw new UserNotFoundException("User not found with id : "+userId);
//		}
//		
//		return user.getPosts();
//	}
//	
//	public Post save(int userId,Post post) {
//		User user=userDAOService.findOne(userId);
//		if(user==null) {
//			throw new UserNotFoundException("User not found with id : "+userId);
//		}
//		Post newPost=user.savePost(post);
//		return newPost;
//	}
//	
//	public Post findOne(int userId,int postId) {
//		User user=userDAOService.findOne(userId);
//		if(user==null) {
//			throw new UserNotFoundException("User not found with id : "+userId);
//		}
//		return user.getPosts().get(postId);
//	}
	
}
