package com.model;

public class FeedbackModel {
	
	private String customeremailid, description, suggestion, createddatetime, createdbyip;
	private int fkregid,pkfeedbackid;

	public int getPkfeedbackid() {
		return pkfeedbackid;
	}

	public void setPkfeedbackid(int pkfeedbackid) {
		this.pkfeedbackid = pkfeedbackid;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public int getFkregid() {
		return fkregid;
	}

	public void setFkregid(int fkregid) {
		this.fkregid = fkregid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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
