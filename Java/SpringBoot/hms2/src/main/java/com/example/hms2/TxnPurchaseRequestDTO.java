package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TxnPurchaseRequestDTO {
    private Integer prid;
    private Integer requestedby;
    private String requestedbyname;
    private Integer itemid;
    private String itemname;
    private Integer qty;
    private LocalDate requestdate;
    private String status;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public Integer getRequestedby() {
		return requestedby;
	}
	public void setRequestedby(Integer requestedby) {
		this.requestedby = requestedby;
	}
	public String getRequestedbyname() {
		return requestedbyname;
	}
	public void setRequestedbyname(String requestedbyname) {
		this.requestedbyname = requestedbyname;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public LocalDate getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(LocalDate requestdate) {
		this.requestdate = requestdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getLastaddeditby() {
		return lastaddeditby;
	}
	public void setLastaddeditby(Integer lastaddeditby) {
		this.lastaddeditby = lastaddeditby;
	}
	public LocalDateTime getLasteditdatetime() {
		return lasteditdatetime;
	}
	public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
		this.lasteditdatetime = lasteditdatetime;
	}
}

