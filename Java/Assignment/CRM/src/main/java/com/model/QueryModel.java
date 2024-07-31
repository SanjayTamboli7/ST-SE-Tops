package com.model;

public class QueryModel {

	private int pkQueryID, fkResponseID, fkRegID;
	private String CustomerEmailID, Description, Suggestion, Response, ResponseDate, CreatedDateTime, CreatedByIP;
	public int getPkQueryID() {
		return pkQueryID;
	}
	public void setPkQueryID(int pkQueryID) {
		this.pkQueryID = pkQueryID;
	}
	public int getFkResponseID() {
		return fkResponseID;
	}
	public void setFkResponseID(int fkResponseID) {
		this.fkResponseID = fkResponseID;
	}
	public int getFkRegID() {
		return fkRegID;
	}
	public void setFkRegID(int fkRegID) {
		this.fkRegID = fkRegID;
	}
	public String getCustomerEmailID() {
		return CustomerEmailID;
	}
	public void setCustomerEmailID(String customerEmailID) {
		CustomerEmailID = customerEmailID;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getSuggestion() {
		return Suggestion;
	}
	public void setSuggestion(String suggestion) {
		Suggestion = suggestion;
	}
	public String getResponse() {
		return Response;
	}
	public void setResponse(String response) {
		Response = response;
	}
	public String getResponseDate() {
		return ResponseDate;
	}
	public void setResponseDate(String responseDate) {
		ResponseDate = responseDate;
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
