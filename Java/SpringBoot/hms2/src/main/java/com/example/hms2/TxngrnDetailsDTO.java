package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TxngrnDetailsDTO.java
public class TxngrnDetailsDTO {
 private Integer grnDetailId;
 private Integer grnid;
 private Integer itemid;
 private Integer orderedQty;
 private Integer receivedQty;
 private Integer acceptedQty;
 private Integer rejectedQty;
 private String batchNo;
 private LocalDate expiryDate;
 private Integer poDetailId;
 private Integer lastAddEditBy;
 private LocalDateTime lastEditDateTime;
 
// private Integer grnDetailId;
// private Integer itemid;
// private Double orderedqty;
// private Double receivedqty;
// private Double acceptedqty;
// private Double rejectedqty;
// private String batchno;
// private LocalDate expirydate;
// private Integer poDetailId;

 // + Getters and Setters
 
public Integer getGrnDetailId() {
	return grnDetailId;
}
public void setGrnDetailId(Integer grnDetailId) {
	this.grnDetailId = grnDetailId;
}
public Integer getGrnid() {
	return grnid;
}
public void setGrnid(Integer grnid) {
	this.grnid = grnid;
}
public Integer getItemid() {
	return itemid;
}
public void setItemid(Integer itemid) {
	this.itemid = itemid;
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
public Integer getPoDetailId() {
	return poDetailId;
}
public void setPoDetailId(Integer poDetailId) {
	this.poDetailId = poDetailId;
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
