package com.example.hms2;

// package com.example.hms2.dto;

import java.time.LocalDateTime;

public class MstSupplierItemDTO {
    private Integer supplierid;
    private String suppliername;

    private Integer itemid;
    private String itemname;

    private Integer leadtimedays;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;

    // Getters and Setters
    public Integer getSupplierid() { return supplierid; }
    public void setSupplierid(Integer supplierid) { this.supplierid = supplierid; }

    public String getSuppliername() { return suppliername; }
    public void setSuppliername(String suppliername) { this.suppliername = suppliername; }

    public Integer getItemid() { return itemid; }
    public void setItemid(Integer itemid) { this.itemid = itemid; }

    public String getItemname() { return itemname; }
    public void setItemname(String itemname) { this.itemname = itemname; }

    public Integer getLeadtimedays() { return leadtimedays; }
    public void setLeadtimedays(Integer leadtimedays) { this.leadtimedays = leadtimedays; }

    public Integer getLastaddeditby() { return lastaddeditby; }
    public void setLastaddeditby(Integer lastaddeditby) { this.lastaddeditby = lastaddeditby; }

    public LocalDateTime getLasteditdatetime() { return lasteditdatetime; }
    public void setLasteditdatetime(LocalDateTime lasteditdatetime) { this.lasteditdatetime = lasteditdatetime; }
}

