package com.example.hms2;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// TxnPoDetails.java

@Entity
public class TxnPoDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer podetailid;

    @ManyToOne
    @JoinColumn(name = "poid")
    private TxnPoHeader poHeader;
    
    @ManyToOne
    @JoinColumn(name = "itemid")
    private POItem item;   
 
    private Integer qty;
    
    @Column(name = "rate")
    private Float rate;
    
    @Column(name="amount")
    private Float amount;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
    
	public Integer getPodetailid() {
		return podetailid;
	}
	public void setPodetailid(Integer podetailid) {
		this.podetailid = podetailid;
	}
	public TxnPoHeader getPoHeader() {
		return poHeader;
	}
	public void setPoHeader(TxnPoHeader poHeader) {
		this.poHeader = poHeader;
	}
	public POItem getItem() {
		return item;
	}
	public void setItem(POItem item) {
		this.item = item;
	}
	public Integer getQty() {
		return qty;
	}
	public Float getRate() {
		return rate;
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
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
	    recalculateAmount();
		this.amount = amount;
	}
	public void setQty(Integer qty) {
	    this.qty = qty;
	    recalculateAmount();
	}

	public void setRate(Float rate) {
	    this.rate = rate;
	    recalculateAmount();
	}

	private void recalculateAmount() {
	    if (qty != null && rate != null) {
	        this.amount = qty * rate;
	    }
	}

	public TxnPoDetails(Integer poDetailId) {
	    this.podetailid = poDetailId;
	}
	public TxnPoDetails() {
		// TODO Auto-generated constructor stub
	}

}
