package com.example.constructor;

public class emp {
	private int id;
	private String name, email, address, city, technology;
	
	public emp() {
		
	}
	
	public emp(int id, String name, String email, String address, String city, String technology) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.technology = technology;
	}

}
