package com.example.hms2;

import java.time.LocalDateTime;

//package com.yourpackage.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "mstotheruser")
public class OUUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ouserid;

    private String ousername;

    @Column(nullable = false)
    private String ouseremailid;

    private String ousercontactno;

    @Column(nullable = false)
    private int ouserdeptid;

    @Column(nullable = false)
    private int ouserdesignationid;

    @Column(nullable = false)
    private String ouserpassword;

    @Column(nullable = false)
    private String ouserstatus;

    @Column(nullable = false)
    private int lastaddeditby;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private LocalDateTime lasteditdatetime;

    // Getters and Setters
    public int getOuserid() {
        return ouserid;
    }

    public void setOuserid(int ouserid) {
        this.ouserid = ouserid;
    }

    public String getOusername() {
        return ousername;
    }

    public void setOusername(String ousername) {
        this.ousername = ousername;
    }

    public String getOuseremailid() {
        return ouseremailid;
    }

    public void setOuseremailid(String ouseremailid) {
        this.ouseremailid = ouseremailid;
    }

    public String getOusercontactno() {
        return ousercontactno;
    }

    public void setOusercontactno(String ousercontactno) {
        this.ousercontactno = ousercontactno;
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

    public String getOuserpassword() {
        return ouserpassword;
    }

    public void setOuserpassword(String ouserpassword) {
        this.ouserpassword = ouserpassword;
    }

    public String getOuserstatus() {
        return ouserstatus;
    }

    public void setOuserstatus(String ouserstatus) {
        this.ouserstatus = ouserstatus;
    }

    public int getLastaddeditby() {
        return lastaddeditby;
    }

    public void setLastaddeditby(int lastaddeditby) {
        this.lastaddeditby = lastaddeditby;
    }

    public LocalDateTime getLasteditdatetime() {
        return lasteditdatetime;
    }

    public void setLasteditdatetime(LocalDateTime localDateTime) {
        this.lasteditdatetime = localDateTime;
    }
}
