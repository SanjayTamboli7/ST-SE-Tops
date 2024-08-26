package com.model;

public class CustomerModel {

	private int pkCustomerID, fkRegID;
	private String CustomerName, CustomerEmailID, CustomerContactNo, CustomerAddress, CustomerCity, CustomerState;
	private String CustomerCountry, CreatedDateTime, CreatedByIP;

	public int getPkCustomerID() {
		System.out.println(" pkCustomerID : " + pkCustomerID);
		return pkCustomerID;
	}

	public void setPkCustomerID(int pkCustomerID) {
		this.pkCustomerID = pkCustomerID;
	}

	public int getFkRegID() {
		System.out.println(" fkRegID : " + fkRegID);
		return fkRegID;
	}

	public void setFkRegID(int fkRegID) {
		this.fkRegID = fkRegID;
	}

	public String getCustomerName() {
		System.out.println(" CustomerName: " + CustomerName);
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getCustomerEmailID() {
		System.out.println(" CustomerEmailID : " + CustomerEmailID);
		return CustomerEmailID;
	}

	public void setCustomerEmailID(String customerEmailID) {
		CustomerEmailID = customerEmailID;
	}

	public String getCustomerContactNo() {
		System.out.println(" CustomerContactNo : " + CustomerContactNo);
		return CustomerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		CustomerContactNo = customerContactNo;
	}

	public String getCustomerAddress() {
		System.out.println(" CustomerAddress : " + CustomerAddress );
		return CustomerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}

	public String getCustomerCity() {
		System.out.println(" CustomerCity : " + CustomerCity );
		return CustomerCity;
	}

	public void setCustomerCity(String customerCity) {
		CustomerCity = customerCity;
	}

	public String getCustomerState() {
		System.out.println(" CustomerState : " + CustomerState);
		return CustomerState;
	}

	public void setCustomerState(String customerState) {
		CustomerState = customerState;
	}

	public String getCustomerCountry() {
		System.out.println(" CustomerCountry : " +CustomerCountry);
		return CustomerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		CustomerCountry = customerCountry;
	}

	public String getCreatedDateTime() {
		System.out.println(" CreatedDateTime : " + CreatedDateTime);
		return CreatedDateTime;
	}

	public void setCreatedDateTime(String createdDateTime) {
		CreatedDateTime = createdDateTime;
	}

	public String getCreatedByIP() {
		System.out.println(" CreatedByIP : " + CreatedByIP);
		return CreatedByIP;
	}

	public void setCreatedByIP(String createdByIP) {
		CreatedByIP = createdByIP;
	}

}
