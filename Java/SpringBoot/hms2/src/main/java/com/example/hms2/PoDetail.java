package com.example.hms2;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "txnpodetails")
public class PoDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer podetailid;

    @ManyToOne
    private POItem item;

    private Integer qty;
    private Float rate;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;

    // Getters and Setters
    
    public POItem getItem() {
        return item;
    }

    public Integer getPodetailid() {
		return podetailid;
	}

	public void setPodetailid(Integer podetailid) {
		this.podetailid = podetailid;
	}

	public void setItem(POItem item) {
        this.item = item;
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
