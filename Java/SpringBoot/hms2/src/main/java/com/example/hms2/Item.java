package com.example.hms2;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "mstitem")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemid;

    @Column(nullable = false, length = 100)
    private String itemname;

    @Column(nullable = false, unique = true, length = 50)
    private String itemcode;

    @Column(nullable = false)
    private Integer categoryid;

    @Column(nullable = false)
    private Integer uomid;

    @Column(nullable = false)
    private Integer reorderlevel;

    @Column(nullable = false)
    private Integer maxstock;

    @Column(nullable = false)
    private Integer lastaddeditby;

    @Column(nullable = false)
    private LocalDateTime lasteditdatetime;

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

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public Integer getUomid() {
		return uomid;
	}

	public void setUomid(Integer uomid) {
		this.uomid = uomid;
	}

	public Integer getReorderlevel() {
		return reorderlevel;
	}

	public void setReorderlevel(Integer reorderlevel) {
		this.reorderlevel = reorderlevel;
	}

	public Integer getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Integer maxstock) {
		this.maxstock = maxstock;
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
    
	public Item(Integer itemId) {
	    this.itemid = itemId;
	}

	public Item(Integer itemid, String itemname, String itemcode, Integer categoryid, Integer uomid,
			Integer reorderlevel, Integer maxstock, Integer lastaddeditby, LocalDateTime lasteditdatetime) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemcode = itemcode;
		this.categoryid = categoryid;
		this.uomid = uomid;
		this.reorderlevel = reorderlevel;
		this.maxstock = maxstock;
		this.lastaddeditby = lastaddeditby;
		this.lasteditdatetime = lasteditdatetime;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

}
