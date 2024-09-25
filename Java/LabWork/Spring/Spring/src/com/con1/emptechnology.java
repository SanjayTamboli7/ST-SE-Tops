package com.con1;

public class emptechnology {

	public String emptechnology;
	public String empexperience;
	public int eid;
	
	public emptechnology(String emptechnology, String empexperience) {
		super();
		this.emptechnology = emptechnology;
		this.empexperience = empexperience;
	}

	
	public emptechnology(String emptechnology) {
		super();
		this.emptechnology = emptechnology;
	}

	public emptechnology(String empexperience, int eid) {
		super();
		this.empexperience = empexperience;
		this.eid = eid;
	}
	
	public emptechnology() {

	}
	
	public String empdisplay() {
		return emptechnology;
	}
	
	
}
