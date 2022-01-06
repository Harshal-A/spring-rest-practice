package com.webservices.restfulwebservices.entity;

public class HelloWorldBean {

	private String messages;

	public HelloWorldBean(String messages) {
		this.messages = messages;
	}

	public String getmessages() {
		return messages;
	}

	public void setmessages(String messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [messages=" + messages + "]";
	}
	
	
}
