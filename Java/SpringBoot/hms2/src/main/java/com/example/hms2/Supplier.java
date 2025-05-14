package com.example.hms2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mstsupplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierid;

    private String suppliername;

    // Getters and Setters
    
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
