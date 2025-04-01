package com.example.hms2;

public class AdminUserDetails {
    private Integer auserid;
    private String auserstatus;

    public AdminUserDetails(Integer auserid, String auserstatus) {
        this.auserid = auserid;
        this.auserstatus = auserstatus;
    }

    public Integer getAuserid() {
        return auserid;
    }

    public void setAuserid(Integer auserid) {
        this.auserid = auserid;
    }

    public String getAuserstatus() {
        return auserstatus;
    }

    public void setAuserstatus(String auserstatus) {
        this.auserstatus = auserstatus;
    }
}
