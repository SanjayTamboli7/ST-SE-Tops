package com.example.hms2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class TxnPoDetailsDTO {

    private Integer podetailid;
    private Integer poid; // from poHeader
    private Integer itemid; // from item
    private Integer qty;
    private Float rate;
    private Float amount;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;   
    private String itemname;
        
    public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Float getAmount() {
	    if (qty != null && rate != null) {
	        return qty * rate;
	    }
	    return amount; // fallback if amount is set directly
	}

	public void setAmount(Float amount) {
	    recalculateAmount();
		this.amount = amount;
	}

	// No-argument constructor
    public TxnPoDetailsDTO() {}

 // Constructor with all parameters (optional, for convenience)
    public TxnPoDetailsDTO(Integer podetailid, Integer poid, Integer itemid, Integer qty, Float rate, Float amount, Integer lastaddeditby, LocalDateTime lasteditdatetime) {
        this.podetailid = podetailid;
        this.poid = poid;
        this.itemid = itemid;
        this.qty = qty;
        this.rate = rate;
        this.amount = amount;
        this.lastaddeditby = lastaddeditby;
        this.lasteditdatetime = lasteditdatetime;
    }

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
	
}
