package com.example.hms2;

import java.time.LocalDateTime;

public class TxnPoDetailsDTO {

    private Integer podetailid;
    private Integer poid; // from poHeader
    private Integer itemid; // from item
    private Integer qty;
    private Float rate;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
    
    private String itemname;
    private Float amount;
        
    public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	// No-argument constructor
    public TxnPoDetailsDTO() {}

    // Constructor with parameters (optional, for convenience)
    public TxnPoDetailsDTO(Integer podetailid, Integer poid, Integer itemid, Integer qty, Float rate) {
        this.podetailid = podetailid;
        this.poid = poid;
        this.itemid = itemid;
        this.qty = qty;
        this.rate = rate;
    }

    // Getters and setters

    public Integer getPodetailid() {
        return podetailid;
    }

    public void setPodetailid(Integer podetailid) {
        this.podetailid = podetailid;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
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

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
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
