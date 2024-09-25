package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Addtocart {

	@Id
	@Column
	private int Cartid;
	@Column
	private int customerid;
	@Column
	private int bookid;
	@Column
	private int totalprice;
	public int getCartid() {
		return Cartid;
	}
	public void setCartid(int cartid) {
		Cartid = cartid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	

}
