package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Deliveryboy {

	@Id
	@Column
	private int Deliveryboy;
	@Column
	private String name;
	@Column
	private String mobileno;
	
	public int getDeliveryboy() {
		return Deliveryboy;
	}
	
	public void setDeliveryboy(int deliveryboy) {
		Deliveryboy = deliveryboy;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobileno() {
		return mobileno;
	}
	
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}	
	
}
