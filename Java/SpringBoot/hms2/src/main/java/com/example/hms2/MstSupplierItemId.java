package com.example.hms2;

//package com.example.hms2.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class MstSupplierItemId implements Serializable {

    private Integer supplierid;
    private Integer itemid;

    public MstSupplierItemId() {}

    public MstSupplierItemId(Integer supplierid, Integer itemid) {
        this.supplierid = supplierid;
        this.itemid = itemid;
    }

    // equals & hashCode for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MstSupplierItemId that)) return false;
        return Objects.equals(supplierid, that.supplierid) &&
               Objects.equals(itemid, that.itemid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierid, itemid);
    }
}

