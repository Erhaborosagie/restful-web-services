package com.osatechs.rest.webservices.restfulwebservices.helloworld;

public class HelloMessage {

	private String message;

	public HelloMessage(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloMessage [message=" + message + "]";
	}
	
	
}
