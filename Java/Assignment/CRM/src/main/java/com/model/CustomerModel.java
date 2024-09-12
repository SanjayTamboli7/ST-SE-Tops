package com.model;

public class CustomerModel {
	
	private int    pkcustomerid, fkregid;
	private String customername, customeremailid, customercontactno, customeraddress, customercity, customerstate;
	private String customercountry, createddatetime, createdbyip;
		
	public int getPkcustomerid() {
		return pkcustomerid;
	}

	public void setPkcustomerid(int pkcustomerid) {
		this.pkcustomerid = pkcustomerid;
	}

	public int getFkregid() {
		return fkregid;
	}

	public void setFkregid(int fkregid) {
		this.fkregid = fkregid;
	}

	public String getCustomername() {
		return customername;
	}
	
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getCustomeremailid() {
		return customeremailid;
	}
	
	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}
		
	public String getCustomercontactno() {
		return customercontactno;
	}

	public void setCustomercontactno(String customercontactno) {
		this.customercontactno = customercontactno;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}
	
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	
	public String getCustomercity() {
		return customercity;
	}
	
	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}
	
	public String getCustomerstate() {
		return customerstate;
	}
	
	public void setCustomerstate(String customerstate) {
		this.customerstate = customerstate;
	}
	
	public String getCustomercountry() {
		return customercountry;
	}
	
	public void setCustomercountry(String customercountry) {
		this.customercountry = customercountry;
	}
	
	public String getCreateddatetime() {
		return createddatetime;
	}
	
	public void setCreateddatetime(String createddatetime) {
		this.createddatetime = createddatetime;
	}
	
	public String getCreatedbyip() {
		return createdbyip;
	}
	
	public void setCreatedbyip(String createdbyip) {
		this.createdbyip = createdbyip;
	}
	
}
