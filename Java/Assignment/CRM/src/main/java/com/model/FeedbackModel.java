package com.model;

public class FeedbackModel {
	
	private String customeremailid, description, suggestion, createddatetime, createdbyip;
	private int fkregid,pkfeedbackid;

	public int getPkfeedbackid() {
		System.out.println(" pkfeedbackid : " + pkfeedbackid);
		return pkfeedbackid;
	}

	public void setPkfeedbackid(int pkfeedbackid) {
		this.pkfeedbackid = pkfeedbackid;
	}

	public String getCustomeremailid() {
		System.out.println(" customeremailid : " + customeremailid);
		return customeremailid;
	}

	public int getFkregid() {
		System.out.println(" fkregid : " + fkregid);
		return fkregid;
	}

	public void setFkregid(int fkregid) {
		this.fkregid = fkregid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public String getDescription() {
		System.out.println(" description : " + description);
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuggestion() {
		System.out.println(" suggestion : " + suggestion);
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getCreateddatetime() {
		System.out.println(" createddatetime : " + createddatetime);
		return createddatetime;
	}

	public void setCreateddatetime(String createddatetime) {
		this.createddatetime = createddatetime;
	}

	public String getCreatedbyip() {
		System.out.println(" createdbyip : " + createdbyip);
		return createdbyip;
	}

	public void setCreatedbyip(String createdbyip) {
		this.createdbyip = createdbyip;
	}	
}
