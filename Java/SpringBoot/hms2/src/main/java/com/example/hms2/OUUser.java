package com.example.hms2;

//package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mstotheruser")
public class OUUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ouserid;

    private String ousername;
    private String ouseremailid;
    private String ousercontactno;
    private int ouserdeptid;
    private int ouserdesignationid;
    private String ouserpassword;
    private String ouserstatus;
    private int lastaddeditby;
    private LocalDateTime lasteditdatetime;
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
	public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
		this.lasteditdatetime = lasteditdatetime;
	}
    
}
