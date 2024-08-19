package com.model;

public class CustomerModel {

	private int pkCustomerID, fkRegID;
	private String CustomerName, CustomerEmailID, CustomerContactNo, CustomerAddress, CustomerCity, CustomerState,
			CustomerCountry, CreatedDateTime, CreatedByIP;

	public int getPkCustomerID() {
		return pkCustomerID;
	}

	public void setPkCustomerID(int pkCustomerID) {
		this.pkCustomerID = pkCustomerID;
	}

	public int getFkRegID() {
		return fkRegID;
	}

	public void setFkRegID(int fkRegID) {
		this.fkRegID = fkRegID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerEmailID() {
		return CustomerEmailID;
	}

	public void setCustomerEmailID(String customerEmailID) {
		CustomerEmailID = customerEmailID;
	}

	public String getCustomerContactNo() {
		return CustomerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		CustomerContactNo = customerContactNo;
	}

	public String getCustomerAddress() {
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerCity() {
		return CustomerCity;
	}

	public void setCustomerCity(String customerCity) {
		CustomerCity = customerCity;
	}

	public String getCustomerState() {
		return CustomerState;
	}

	public void setCustomerState(String customerState) {
		CustomerState = customerState;
	}

	public String getCustomerCountry() {
		return CustomerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		CustomerCountry = customerCountry;
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
