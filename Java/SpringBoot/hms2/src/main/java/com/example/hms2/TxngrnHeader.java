package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//TxngrnHeader.java
@Entity
@Table(name = "txngrnheader")
public class TxngrnHeader {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 
 private Integer grnid;

 @ManyToOne
 @JoinColumn(name = "poid", nullable = false)
 private TxnPoHeader po;

 private LocalDate receivedDate;

 @ManyToOne
 @JoinColumn(name = "receivedby", nullable = false)
 private OtherUser receivedBy;

 private String status;

 private Integer lastAddEditBy;

 private LocalDateTime lastEditDateTime;

 @OneToMany(mappedBy = "grnHeader", cascade = CascadeType.ALL, orphanRemoval = true)
 private List<TxngrnDetails> details = new ArrayList<>();

public Integer getGrnid() {
	return grnid;
}

public void setGrnid(Integer grnid) {
	this.grnid = grnid;
}

public TxnPoHeader getPo() {
	return po;
}

public void setPo(TxnPoHeader po) {
	this.po = po;
}

public LocalDate getReceivedDate() {
	return receivedDate;
}

public void setReceivedDate(LocalDate receivedDate) {
	this.receivedDate = receivedDate;
}

public OtherUser getReceivedBy() {
	return receivedBy;
}

public void setReceivedBy(OtherUser receivedBy) {
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

public List<TxngrnDetails> getDetails() {
	return details;
}

public void setDetails(List<TxngrnDetails> details) {
	this.details = details;
}

 
}
