package com.example.hms2;

//package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "txnpoheader")
public class TxnPoHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer poid;

    private Integer supplierid;

    private LocalDate podate;

    private LocalDate deliverydate;

    private String status;

    private float totalAmount;
    
    private Integer lastaddeditby;

    private LocalDateTime lasteditdatetime;

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
	
	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

//	public void setTotalAmount(float totalAmount2) {
//		// TODO Auto-generated method stub
//		
//	}
	
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

