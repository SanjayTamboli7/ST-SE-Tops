package com.example.pojo;

import java.util.List;

public class compnaydetail {

	private int cid;
	private String companyname, address, noofemp, noofyear;
	public List<String> companytechnology;

	public List<String> getCompanytechnology() {
		return companytechnology;
	}

	public void setCompanytechnology(List<String> companytechnology) {
		this.companytechnology = companytechnology;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoofemp() {
		return noofemp;
	}

	public void setNoofemp(String noofemp) {
		this.noofemp = noofemp;
	}

	public String getNoofyear() {
		return noofyear;
	}

	public void setNoofyear(String noofyear) {
		this.noofyear = noofyear;
	}

	public void companydetaildisplay() {

		System.out.println("Company Detail");
		System.out.println(" ID : " + cid);
		System.out.println(" name : " + companyname);

		for (String s : companytechnology) {
			System.out.println(s);
		}
	}
}
