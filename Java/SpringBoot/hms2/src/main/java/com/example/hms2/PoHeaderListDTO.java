package com.example.hms2;

import java.time.LocalDate;

public class PoHeaderListDTO {
    private Integer poid;
    private String suppliername;
    private LocalDate podate;
    private String status;
    private Float totalAmount;

    public PoHeaderListDTO(Integer poid, String suppliername, LocalDate podate, String status, Float totalAmount) {
        this.poid = poid;
        this.suppliername = suppliername;
        this.podate = podate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

	public Integer getPoid() {
		return poid;
	}

	public void setPoid(Integer poid) {
		this.poid = poid;
	}

	public String getSuppliername() {
		return suppliername;
	}

	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}

	public LocalDate getPodate() {
		return podate;
	}

	public void setPodate(LocalDate podate) {
		this.podate = podate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

    
}
