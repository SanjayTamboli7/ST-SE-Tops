package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PoHeaderDTO {
    private Integer poid;
    private Integer supplierid;
    private String suppliername;
    private LocalDate podate;
    private LocalDate deliverydate;
    private String status;
    @JsonProperty("total_amount")
    private Float totalAmount; // ✅ Renamed to camelCase
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
    private List<PoDetailDTO> details;

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

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

    public LocalDate getPodate() {
        return podate;
    }

    public void setPodate(LocalDate podate) {
        this.podate = podate;
    }

    public LocalDate getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(LocalDate deliverydate) {
        this.deliverydate = deliverydate;
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

    public List<PoDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<PoDetailDTO> details) {
        this.details = details;
    }
}
