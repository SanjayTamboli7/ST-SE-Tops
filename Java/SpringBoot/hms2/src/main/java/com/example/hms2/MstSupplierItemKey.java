package com.example.hms2;

//package com.example.hms2.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class MstSupplierItemKey implements Serializable {
    private Integer supplierid;
    private Integer itemid;

    public MstSupplierItemKey() {}

    public MstSupplierItemKey(Integer supplierid, Integer itemid) {
        this.supplierid = supplierid;
        this.itemid = itemid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MstSupplierItemKey that)) return false;
        return Objects.equals(supplierid, that.supplierid) && Objects.equals(itemid, that.itemid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierid, itemid);
    }
}
