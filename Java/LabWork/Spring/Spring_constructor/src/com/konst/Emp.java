package com.konst;

public class Emp {
	private int id;
	private String name;
	private Address address;
	
	public Emp() {
		System.out.println("dev cons");
	}

	public Emp(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public void show() {
		System.out.println("id : "+id);
		System.out.println("Name : "+name);
		System.out.println(address.toString());
	}
}
