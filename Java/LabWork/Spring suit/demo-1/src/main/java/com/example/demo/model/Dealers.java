package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Dealers {

	@Id
	@Column
	private int dealerid;
	@Column
	private String dealername;
	@Column
	private String dealeraddress;
	
	public int getDealerid() {
		return dealerid;
	}
	public void setDealerid(int dealerid) {
		this.dealerid = dealerid;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public String getDealeraddress() {
		return dealeraddress;
	}
	public void setDealeraddress(String dealeraddress) {
		this.dealeraddress = dealeraddress;
	}

	
}
