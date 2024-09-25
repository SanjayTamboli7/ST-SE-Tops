package com.example.pojo;

import java.util.List;

public class clientdetail {

	private int clientid;
	private String clientname, clientlocation, noofproject;
	public List<String> projectmode;

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getClientlocation() {
		return clientlocation;
	}

	public void setClientlocation(String clientlocation) {
		this.clientlocation = clientlocation;
	}

	public String getNoofproject() {
		return noofproject;
	}

	public void setNoofproject(String noofproject) {
		this.noofproject = noofproject;
	}

	public List<String> getProjectmode() {
		return projectmode;
	}

	public void setProjectmode(List<String> projectmode) {
		this.projectmode = projectmode;
	}

	public void clientdetaildisplay() {
		
		System.out.println("  Client ID : "+clientid);
		System.out.println("Client Name : "+clientname);
		
		for(String s:projectmode) {
			System.out.println(s);
			
		}
	}
}
