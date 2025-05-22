package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

//TxngrnDetailsDTO.java
public class TxngrnDetailsDTO {
 private Integer grnid;
 private Integer lastAddEditBy;
 private LocalDateTime lastEditDateTime;

 @JsonProperty("grnDetailId")
 private Integer grnDetailId;

 @JsonProperty("itemid")
 private Integer itemid;

 @JsonProperty("orderedqty")
 private Integer orderedQty;

 @JsonProperty("receivedqty")
 private Integer receivedQty;

 @JsonProperty("acceptedqty")
 private Integer acceptedQty;

 @JsonProperty("rejectedqty")
 private Integer rejectedQty;

 @JsonProperty("batchno")
 private String batchNo;

 @JsonProperty("expirydate")
 private LocalDate expiryDate;

 @JsonProperty("poDetailId")
 private Integer poDetailId;

public Integer getGrnid() {
	return grnid;
}
public void setGrnid(Integer grnid) {
	this.grnid = grnid;
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

public Integer getGrnDetailId() {
    return grnDetailId;
}

public void setGrnDetailId(Integer grnDetailId) {
    this.grnDetailId = grnDetailId;
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
 
}
