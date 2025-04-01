package com.example.hms2;

import jakarta.persistence.*;

import java.time.LocalDateTime;
//import java.util.Date;

@Entity
@Table(name = "mstdepartment")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptid;

    private String deptname;
    private String deptheadname;
    private String activestatus;
    private int lastaddeditby;
//    private Date lasteditdatetime;
    
    @Column(nullable = false)
    private LocalDateTime lasteditdatetime = LocalDateTime.now();

    // Getters and Setters
    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptheadname() {
        return deptheadname;
    }

    public void setDeptheadname(String deptheadname) {
        this.deptheadname = deptheadname;
    }

    public String getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(String activestatus) {
        this.activestatus = activestatus;
    }

    public int getLastaddeditby() {
        return lastaddeditby;
    }

    public void setLastaddeditby(int lastaddeditby) {
        this.lastaddeditby = lastaddeditby;
    }

//    public Date getLasteditdatetime() {
//        return lasteditdatetime;
//    }
//
//    public void setLasteditdatetime(Date lasteditdatetime) {
//        this.lasteditdatetime = lasteditdatetime;
//    }

    public LocalDateTime getLasteditdatetime() { return lasteditdatetime; }
    public void setLasteditdatetime(LocalDateTime lasteditdatetime) { this.lasteditdatetime = lasteditdatetime; }
    
}