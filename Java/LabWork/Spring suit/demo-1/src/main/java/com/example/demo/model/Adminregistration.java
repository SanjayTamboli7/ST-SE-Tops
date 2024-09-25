package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Adminregistration {

	@Id
	@Column
	private int adminrid;
	@Column
	private String adminusername;
	@Column
	private String adminpassword;
	
	public int getAdminrid() {
		return adminrid;
	}
	public void setAdminrid(int adminrid) {
		this.adminrid = adminrid;
	}
	public String getAdminusername() {
		return adminusername;
	}
	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	
}
