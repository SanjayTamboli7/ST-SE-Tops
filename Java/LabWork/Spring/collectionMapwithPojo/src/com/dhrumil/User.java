package com.dhrumil;

public class User {
	private int id;
	private String name, email;


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public String toString() {
		return "ID : " + id + "Name : " + name + "Email : " + email;
	}
}
