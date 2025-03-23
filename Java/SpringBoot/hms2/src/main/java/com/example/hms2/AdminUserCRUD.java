package com.example.hms2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mstadminuser")
public class AdminUserCRUD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auserid;
    
    private String ausername;

    @Column(nullable = false, unique = true)
    private String auseremailid;
    
    private String ausercontactno;
    
    @Column(nullable = false)
    private String auserpassword;

    @Column(name = "auserstatus", length = 8, nullable = false)
    private String auserstatus;
    
    @Column(nullable = false)
    private LocalDateTime lasteditdatetime = LocalDateTime.now();

    // Getters and Setters
    public int getAuserid() { return auserid; }
    public void setAuserid(int auserid) { this.auserid = auserid; }

    public String getAusername() { return ausername; }
    public void setAusername(String ausername) { this.ausername = ausername; }

    public String getAuseremailid() { return auseremailid; }
    public void setAuseremailid(String auseremailid) { this.auseremailid = auseremailid; }

    public String getAusercontactno() { return ausercontactno; }
    public void setAusercontactno(String ausercontactno) { this.ausercontactno = ausercontactno; }

    public String getAuserpassword() { return auserpassword; }
    public void setAuserpassword(String auserpassword) { this.auserpassword = auserpassword; }

    public String getAuserstatus() {
        return auserstatus;
    }

    public void setAuserstatus(String auserstatus) {
        this.auserstatus = auserstatus;
    }

    public LocalDateTime getLasteditdatetime() { return lasteditdatetime; }
    public void setLasteditdatetime(LocalDateTime lasteditdatetime) { this.lasteditdatetime = lasteditdatetime; }
}


