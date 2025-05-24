package com.example.hms2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TxngrnHeaderDTO {

    @JsonProperty("grnid")
    private Integer grnid;

    @JsonProperty("poid")
    private Integer poid;

    @JsonProperty("receivedDate")
    private LocalDate receivedDate;

    @JsonProperty("receivedBy")
    private Integer receivedBy;

    @JsonProperty("status")
    private String status;

    @JsonProperty("lastAddEditBy")
    private Integer lastAddEditBy;

    @JsonProperty("lastEditDateTime")
    private LocalDateTime lastEditDateTime;

    @JsonProperty("details")
    private List<TxngrnDetailsDTO> details;

    // Getters and Setters

    public Integer getGrnid() {
        return grnid;
    }

    public void setGrnid(Integer grnid) {
        this.grnid = grnid;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Integer getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(Integer receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLastAddEditBy() {
        return lastAddEditBy;
    }

    public void setLastAddEditBy(Integer lastAddEditBy) {
        this.lastAddEditBy = lastAddEditBy;
    }

    public LocalDateTime getLastEditDateTime() {
        return lastEditDateTime;
    }

    public void setLastEditDateTime(LocalDateTime lastEditDateTime) {
        this.lastEditDateTime = lastEditDateTime;
    }

    public List<TxngrnDetailsDTO> getDetails() {
        return details;
    }

    public void setDetails(List<TxngrnDetailsDTO> details) {
        this.details = details;
    }
    
}
