package com.webservices.restfulwebservices.entity;

public class Post {

	private Integer id;
	private String name;
	private String email;
	private String content;
	
	public Post(String name, String email, String content) {
		this.name = name;
		this.email = email;
		this.content = content;
	}
	
	
	
	public Post(Integer id, String name, String email, String content) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.content = content;
	}



	public Post() {
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
