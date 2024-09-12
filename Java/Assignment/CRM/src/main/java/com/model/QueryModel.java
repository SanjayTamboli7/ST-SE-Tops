package com.model;

public class QueryModel {

	private int pkqueryid, fkresponseid, fkregid;
	private String customeremailid, description, suggestion, response, responsedate, createddatetime, createdbyip;
	public int getPkqueryid() {
		return pkqueryid;
	}
	public void setPkqueryid(int pkqueryid) {
		this.pkqueryid = pkqueryid;
	}
	public int getFkresponseid() {
		return fkresponseid;
	}
	public void setFkresponseid(int fkresponseid) {
		this.fkresponseid = fkresponseid;
	}
	public int getFkregid() {
		return fkregid;
	}
	public void setFkregid(int fkregid) {
		this.fkregid = fkregid;
	}
	public String getCustomeremailid() {
		return customeremailid;
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
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getResponsedate() {
		return responsedate;
	}
	public void setResponsedate(String responsedate) {
		this.responsedate = responsedate;
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
