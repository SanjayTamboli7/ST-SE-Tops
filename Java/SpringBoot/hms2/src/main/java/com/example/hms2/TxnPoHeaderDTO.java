package com.example.hms2;

//package com.example.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TxnPoHeaderDTO {
    private Integer poid;
    private Integer supplierid;
    private String suppliername;
    private LocalDate podate;
    private LocalDate deliverydate;
    private String status;
    private BigDecimal totalAmount; 
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
    private List<TxnPoDetailsDTO> details;
	public Integer getPoid() {
		return poid;
	}
	public void setPoid(Integer poid) {
		this.poid = poid;
	}
	public Integer getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(Integer supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public LocalDate getPodate() {
		return podate;
	}
	public void setPodate(LocalDate podate) {
		this.podate = podate;
	}
	public LocalDate getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(LocalDate deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
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
	public List<TxnPoDetailsDTO> getDetails() {
		return details;
	}
	public void setDetails(List<TxnPoDetailsDTO> details) {
		this.details = details;
	}
        
}

