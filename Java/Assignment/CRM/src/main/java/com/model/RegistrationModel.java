package com.model;

public class RegistrationModel {

	private int pkregid;
	private String username, emailid, pwd, registrationtype, activeflag, createdbyip;
	private String createddatetime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPkregid() {
		return pkregid;
	}

	public void setPkregid(int pkregid) {
		this.pkregid = pkregid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegistrationtype() {
		return registrationtype;
	}

	public void setRegistrationtype(String registrationtype) {
		this.registrationtype = registrationtype;
	}

	public String getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(String activeflag) {
		this.activeflag = activeflag;
	}

	public String getCreatedbyip() {
		return createdbyip;
	}

	public void setCreatedbyip(String createdbyip) {
		this.createdbyip = createdbyip;
	}

	public String getCreateddatetime() {
		return createddatetime;
	}

	public void setCreateddatetime(String string) {
		this.createddatetime = string;
	}
}
