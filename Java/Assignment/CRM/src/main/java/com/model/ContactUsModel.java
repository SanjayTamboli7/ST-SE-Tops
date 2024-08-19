package com.model;

public class ContactUsModel {

	private int pkContactUsID;
	private String YourName, YourEmailID, YourMessage, CreatedDateTime, CreatedByIP;
	public int getPkContactUsID() {
		return pkContactUsID;
	}
	public void setPkContactUsID(int pkContactUsID) {
		this.pkContactUsID = pkContactUsID;
	}
	public String getYourName() {
		return YourName;
	}
	public void setYourName(String yourName) {
		YourName = yourName;
	}
	public String getYourEmailID() {
		return YourEmailID;
	}
	public void setYourEmailID(String yourEmailID) {
		YourEmailID = yourEmailID;
	}
	public String getYourMessage() {
		return YourMessage;
	}
	public void setYourMessage(String yourMessage) {
		YourMessage = yourMessage;
	}
	public String getCreatedDateTime() {
		return CreatedDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	public String getCreatedByIP() {
		return CreatedByIP;
	}
	public void setCreatedByIP(String createdByIP) {
		CreatedByIP = createdByIP;
	}
	
}
