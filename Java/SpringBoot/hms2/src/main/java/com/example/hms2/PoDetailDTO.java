package com.example.hms2;

import java.time.LocalDateTime;

public class PoDetailDTO {
    private Integer itemid;
    private String itemname;
    private Integer qty;
    private Float rate;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;

    // Getters and Setters
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
