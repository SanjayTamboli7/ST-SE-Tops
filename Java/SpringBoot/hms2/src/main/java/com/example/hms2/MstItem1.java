package com.example.hms2;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mstitem")
public class MstItem1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemid;

    private String itemname;

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
        
}
