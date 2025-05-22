package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//TxngrnHeaderDTO.java
public class TxngrnHeaderDTO {
 private Integer grnid;
 private Integer poid;
 private LocalDate receivedDate;
 private Integer receivedBy;
 private String status;
 private Integer lastAddEditBy;
 private LocalDateTime lastEditDateTime;
 private List<TxngrnDetailsDTO> details;
public Integer getGrnid() {
	return grnid;
}
public void setGrnid(Integer grnid) {
	this.grnid = grnid;
}
public Integer getPoid() {
	return poid;
}
public void setPoid(Integer poid) {
	this.poid = poid;
}
public LocalDate getReceivedDate() {
	return receivedDate;
}
public void setReceivedDate(LocalDate receivedDate) {
	this.receivedDate = receivedDate;
}
public Integer getReceivedBy() {
	return receivedBy;
}
public void setReceivedBy(Integer receivedBy) {
	this.receivedBy = receivedBy;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
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
public List<TxngrnDetailsDTO> getDetails() {
	return details;
}
public void setDetails(List<TxngrnDetailsDTO> details) {
	this.details = details;
}

 
}
