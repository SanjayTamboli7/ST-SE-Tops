package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TxnIssueRequestDTO {
    private Integer issueid;
    private Integer requestedby;
    private Integer departmentid;
    private Integer itemid;
    private Integer qty;
    private LocalDate requestdate;
    private String remark;
    private String status;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
	public Integer getIssueid() {
		return issueid;
	}
	public void setIssueid(Integer issueid) {
		this.issueid = issueid;
	}
	public Integer getRequestedby() {
		return requestedby;
	}
	public void setRequestedby(Integer requestedby) {
		this.requestedby = requestedby;
	}
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
