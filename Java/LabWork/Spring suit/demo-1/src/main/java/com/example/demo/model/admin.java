package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class admin {

	@Id
	@Column
	private int adminid;
	@Column
	private String adminusername;
	@Column
	private String adminuserpassword;
	
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminusername() {
		return adminusername;
	}
	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}
	public String getAdminuserpassword() {
		return adminuserpassword;
	}
	public void setAdminuserpassword(String adminuserpassword) {
		this.adminuserpassword = adminuserpassword;
	}
		
}
