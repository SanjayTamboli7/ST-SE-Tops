package com.example.hms2;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mstdesignation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int designationid;

    @Column(nullable = false, length = 50)
    private String designationname;

    @Column(nullable = false)
    private int lastaddeditby;

    @Column(nullable = false)
    private LocalDateTime lasteditdatetime;

    @Column(nullable = false, length = 7)
    private String dutytype;
    
	public int getDesignationid() {
		return designationid;
	}

	public void setDesignationid(int designationid) {
		this.designationid = designationid;
	}

	public String getDesignationname() {
		return designationname;
	}

	public void setDesignationname(String designationname) {
		this.designationname = designationname;
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

	public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
		this.lasteditdatetime = lasteditdatetime;
	}

	public String getDutytype() {
		return dutytype;
	}

	public void setDutytype(String dutytype) {
		this.dutytype = dutytype;
	}
	
}
