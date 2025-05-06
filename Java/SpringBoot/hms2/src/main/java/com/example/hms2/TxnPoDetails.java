// TxnPoDetails entity
package com.example.hms2;

//package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "txnpodetails")
public class TxnPoDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer podetailid;

    private Integer poid;

    private Integer itemid;

    private Integer qty;

    private BigDecimal rate;

    private BigDecimal amount;

    private Integer prid;

    private Integer lastaddeditby;

    private LocalDateTime lasteditdatetime;

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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
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
