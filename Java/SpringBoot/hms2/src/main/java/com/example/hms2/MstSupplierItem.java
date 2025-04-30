package com.example.hms2;

//package com.example.hms2.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mstsupplieritems")
@IdClass(MstSupplierItemKey.class)

public class MstSupplierItem {

    @Id
    private Integer supplierid;

    @Id
    private Integer itemid;

    private Integer leadtimedays;

    private Integer lastaddeditby;

    private LocalDateTime lasteditdatetime;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "supplierid", insertable = false, updatable = false)
    private MstSupplier supplier;

    @ManyToOne
    @JoinColumn(name = "itemid", insertable = false, updatable = false)
    private Item item;

    // Getters and setters...
    public Integer getSupplierid() { return supplierid; }
    public void setSupplierid(Integer supplierid) { this.supplierid = supplierid; }

    public Integer getItemid() { return itemid; }
    public void setItemid(Integer itemid) { this.itemid = itemid; }

    public Integer getLeadtimedays() { return leadtimedays; }
    public void setLeadtimedays(Integer leadtimedays) { this.leadtimedays = leadtimedays; }

    public Integer getLastaddeditby() { return lastaddeditby; }
    public void setLastaddeditby(Integer lastaddeditby) { this.lastaddeditby = lastaddeditby; }

    public LocalDateTime getLasteditdatetime() { return lasteditdatetime; }
    public void setLasteditdatetime(LocalDateTime lasteditdatetime) { this.lasteditdatetime = lasteditdatetime; }

    public MstSupplier getSupplier() { return supplier; }
    public void setSupplier(MstSupplier supplier) { this.supplier = supplier; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
}
