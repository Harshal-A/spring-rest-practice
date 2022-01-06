package com.webservices.restfulwebservices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

	private Integer id;
	
	@NotBlank
	@Size(min = 2,message = "Name sohuld have atleast 2 chracters")
	private String name;
	
	@Past
	private Date birthDate;
	
	
	private List<Post> posts;
	
	
	
	public User() {
		
	}
	public User(Integer id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Post savePost(Post post) {
		if(getPosts()==null) {
			posts=new ArrayList<Post>();
		}
		posts.add(post);
		return post;
	}
	
	public Post retrievePost(int postId) {
		return getPosts().get(postId-1);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
