package com.tops;

public class Emp {

		private String name, address, city, email;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public void display() {
			System.out.println("Name is "+name);
			System.out.println("Address is "+address);
			System.out.println("city is "+city);
			System.out.println("Email is "+email);
		}
}
