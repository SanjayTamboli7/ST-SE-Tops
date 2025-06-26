package com.example.hms2;

public class PoItemDTO {
    private Integer podetailid;
    private Integer itemid;
    private Double orderedqty;

    public PoItemDTO(Integer podetailid, Integer itemid, Double orderedqty) {
        this.podetailid = podetailid;
        this.itemid = itemid;
        this.orderedqty = orderedqty;
    }

    public Integer getPodetailid() {
        return podetailid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public Double getOrderedqty() {
        return orderedqty;
    }
}
