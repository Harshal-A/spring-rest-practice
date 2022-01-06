package com.webservices.restfulwebservices.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.restfulwebservices.entity.Post;
import com.webservices.restfulwebservices.entity.User;

@Service
public class UserDAOService {


	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	
	static{
		users.add(new User(1, "Aaron", new Date()));
		users.add(new User(2, "Barack", new Date()));
		users.add(new User(3, "Charlie", new Date()));
		
		List<Post> posts=new ArrayList();
		posts.add(new Post(1,"aaron", "aaron@gnc.com", "GNC gives 30% off!!"));
		posts.add(new Post(2,"barack", "barack@on.com", "Original!!"));
		posts.add(new Post(3,"cameron", "cameron@muscleblaze.com", "I am ignored!!"));
		users.get(0).setPosts(posts);
	}
	
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
				User user=iterator.next();
				if(user.getId()==id) {
					iterator.remove();
					return user;
				}		
		}
		return null;
	}
	
}
