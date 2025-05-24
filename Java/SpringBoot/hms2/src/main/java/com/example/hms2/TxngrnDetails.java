package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//TxngrnDetails.java
@Entity
@Table(name = "txngrndetails")
public class TxngrnDetails {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 
 @Column(name = "grndetailid")
 private Integer grnDetailId;

 @ManyToOne
 @JoinColumn(name = "grnid", nullable = false)
 private TxngrnHeader grnHeader;

 @ManyToOne
 @JoinColumn(name = "itemid", nullable = false)
 private Item item;

 @Column(name = "orderedqty")
 private Integer orderedQty = 0;
 
 @Column(name = "receivedqty")
 private Integer receivedQty = 0;
 
 @Column(name = "acceptedqty")
 private Integer acceptedQty = 0;
 
 @Column(name = "rejectedqty")
 private Integer rejectedQty = 0;
 
 @Column(name = "batchno")
 private String batchNo;
 
 @Column(name = "expirydate")
 private LocalDate expiryDate;

 @ManyToOne
 @JoinColumn(name = "podetailid")
 private TxnPoDetails poDetail;
 
 @Column(name = "lastaddeditby")
 private Integer lastAddEditBy;

 @Column(name = "lasteditdatetime")
 private LocalDateTime lastEditDateTime;

 public Integer getGrnDetailId() {
	return grnDetailId;
}
public void setGrnDetailId(Integer grnDetailId) {
	this.grnDetailId = grnDetailId;
}
public TxngrnHeader getGrnHeader() {
	return grnHeader;
}
public void setGrnHeader(TxngrnHeader grnHeader) {
	this.grnHeader = grnHeader;
}
public Item getItem() {
	return item;
}
public void setItem(Item item) {
	this.item = item;
}
public Integer getOrderedQty() {
	return orderedQty;
}
public void setOrderedQty(Integer orderedQty) {
	this.orderedQty = orderedQty;
}
public Integer getReceivedQty() {
	return receivedQty;
}
public void setReceivedQty(Integer receivedQty) {
	this.receivedQty = receivedQty;
}
public Integer getAcceptedQty() {
	return acceptedQty;
}
public void setAcceptedQty(Integer acceptedQty) {
	this.acceptedQty = acceptedQty;
}
public Integer getRejectedQty() {
	return rejectedQty;
}
public void setRejectedQty(Integer rejectedQty) {
	this.rejectedQty = rejectedQty;
}
public String getBatchNo() {
	return batchNo;
}
public void setBatchNo(String batchNo) {
	this.batchNo = batchNo;
}
public LocalDate getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(LocalDate expiryDate) {
	this.expiryDate = expiryDate;
}
public TxnPoDetails getPoDetail() {
	return poDetail;
}
public void setPoDetail(TxnPoDetails poDetail) {
	this.poDetail = poDetail;
}
public Integer getLastAddEditBy() {
	return lastAddEditBy;
}
public void setLastAddEditBy(Integer lastAddEditBy) {
	this.lastAddEditBy = lastAddEditBy;
}
public LocalDateTime getLastEditDateTime() {
	return lastEditDateTime;
}
public void setLastEditDateTime(LocalDateTime lastEditDateTime) {
	this.lastEditDateTime = lastEditDateTime;
}

 
}
