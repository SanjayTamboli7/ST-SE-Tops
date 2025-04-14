package com.example.hms2;

//package com.yourpackage.dto;

public class OUUserStatusResponse {
    private int ouserid;
    private int ouserdeptid;
    private int ouserdesignationid;
    private String ouserstatus;

    // Constructor
    public OUUserStatusResponse(int ouserid, int ouserdeptid, int ouserdesignationid, String ouserstatus) {
        this.ouserid = ouserid;
        this.ouserdeptid = ouserdeptid;
        this.ouserdesignationid = ouserdesignationid;
        this.ouserstatus = ouserstatus;
    }

    // Getters & Setters
    public int getOuserid() {
        return ouserid;
    }

    public void setOuserid(int ouserid) {
        this.ouserid = ouserid;
    }

    public int getOuserdeptid() {
        return ouserdeptid;
    }

    public void setOuserdeptid(int ouserdeptid) {
        this.ouserdeptid = ouserdeptid;
    }

    public int getOuserdesignationid() {
        return ouserdesignationid;
    }

    public void setOuserdesignationid(int ouserdesignationid) {
        this.ouserdesignationid = ouserdesignationid;
    }

    public String getOuserstatus() {
        return ouserstatus;
    }

    public void setOuserstatus(String ouserstatus) {
        this.ouserstatus = ouserstatus;
    }
}

