package com.example.hms2;

//package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mstsupplier")
public class MstSupplier1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierid;

    private String suppliername;

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
        
}
