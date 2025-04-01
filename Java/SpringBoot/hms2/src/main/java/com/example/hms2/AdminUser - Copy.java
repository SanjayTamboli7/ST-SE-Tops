package com.example.hms2;

//package com.example.adminlogin.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mstadminuser")
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auserid;

    private String ausername;

    @Column(name = "auseremailid", nullable = false, unique = true, length = 50)
    private String auserEmailId;

    private String ausercontactno;

    @Column(nullable = false)
    private String auserpassword;

//    @Column(nullable = false)
//    private Boolean auserstatus;

    @Column(name = "auserstatus", length = 8, nullable = false)
    private String auserstatus;
    
    private LocalDateTime lasteditdatetime;

	public Integer getAuserid() {
		return auserid;
	}

	public void setAuserid(Integer auserid) {
		this.auserid = auserid;
	}

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getAuserEmailId() {
    	System.out.println( "Email : " +  auserEmailId);		
		return auserEmailId;
	}

	public void setAuserEmailId(String auserEmailId) {
		this.auserEmailId = auserEmailId;
	}

	public String getAusercontactno() {
		return ausercontactno;
	}

	public void setAusercontactno(String ausercontactno) {
		this.ausercontactno = ausercontactno;
	}

	public String getAuserpassword() {		
    	System.out.println("Pwd : " + auserpassword);
		return auserpassword;
	}

	public void setAuserpassword(String auserpassword) {
		this.auserpassword = auserpassword;
	}

//	public Boolean getAuserstatus() {
//		return auserstatus;
//	}
//
//	public void setAuserstatus(Boolean auserstatus) {
//		this.auserstatus = auserstatus;
//	}

    public String getAuserstatus() {
        return auserstatus;
    }

    public void setAuserstatus(String auserstatus) {
        this.auserstatus = auserstatus;
    }	
    
	public LocalDateTime getLasteditdatetime() {
		return lasteditdatetime;
	}

	public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
		this.lasteditdatetime = lasteditdatetime;
	}       
}
