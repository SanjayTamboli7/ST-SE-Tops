package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Distributer {

	@Id
	@Column
	private int distid;
	@Column
	private String distname;
	@Column
	private String shopname;
	@Column
	private String address;
	public int getDistid() {
		return distid;
	}
	public void setDistid(int distid) {
		this.distid = distid;
	}
	public String getDistname() {
		return distname;
	}
	public void setDistname(String distname) {
		this.distname = distname;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}
