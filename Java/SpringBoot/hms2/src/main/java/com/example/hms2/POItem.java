package com.example.hms2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mstitem") // Optional: only if the table name is not 'po_item'
public class POItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemid;

    private String itemname;

    // Getters and Setters
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
