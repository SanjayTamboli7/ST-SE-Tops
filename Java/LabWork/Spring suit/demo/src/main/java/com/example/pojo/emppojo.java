package com.example.pojo;

import java.util.Iterator;
import java.util.List;

public class emppojo {

	private int id;
	private String name, email, address, city, technology;
	private List<String> experience;

	public List<String> getExperience() {
		return experience;
	}

	public void setExperience(List<String> experience) {
		this.experience = experience;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public void displayInfo() {
		System.out.println("Id : " + name);
		System.out.println("Has experience :");
		Iterator<String> itr = experience.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

	public void datadisplay() {
		System.out.println("Empname : " + name);
		System.out.println("Emp ID : " + id);
		System.out.println("Experience : " + experience);

		for (String s : experience) {
			System.out.println(s);
		}
	}

}
