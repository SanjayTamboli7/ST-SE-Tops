package com.con1;

public class empdetails {

	public int empid;
	public String empname;
	public String empemail;
	public String emppassword;

	public empdetails(int empid, String empname, String empemail, String emppassword) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
		this.emppassword = emppassword;
	}

	public empdetails(int empid, String empname, String empemail) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empemail = empemail;
	}

	public empdetails(int empid, String empname) {
		super();
		this.empid = empid;
		this.empname = empname;
	}

	public empdetails(int empid) {
		super();
		this.empid = empid;
	}

	public empdetails() {
		super();
	}

	public String display() {
		return empname;
	}

}
