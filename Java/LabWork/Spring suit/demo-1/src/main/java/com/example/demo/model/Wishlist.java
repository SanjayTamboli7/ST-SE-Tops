package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table 
public class Wishlist {

	@Id
	@Column
	private int wishlistid;
	@Column
	private int customerid;
	@Column
	private int bookid;
	public int getWishlistid() {
		return wishlistid;
	}
	public void setWishlistid(int wishlistid) {
		this.wishlistid = wishlistid;
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
	
}
