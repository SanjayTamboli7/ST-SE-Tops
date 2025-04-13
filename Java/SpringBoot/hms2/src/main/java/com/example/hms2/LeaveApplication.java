package com.example.hms2;

//package com.example.leaveapp.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "txnleave")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveappid;

    private LocalDate leaveappdate;
    private String leaveapptype;
    private LocalDate leavefromdate;
    private LocalDate leavetodate;
    private String leavefullhalfflag;
    private String leaveappremark;
    private String leaveappstatus;
    private Integer lastaddeditby;
    @Column(nullable = false)
    private LocalDateTime lasteditdatetime;
    
	public Integer getLeaveappid() {
		return leaveappid;
	}
	public void setLeaveappid(Integer leaveappid) {
		this.leaveappid = leaveappid;
	}
	public LocalDate getLeaveappdate() {
		return leaveappdate;
	}
	public void setLeaveappdate(LocalDate leaveappdate) {
		this.leaveappdate = leaveappdate;
	}
	public String getLeaveapptype() {
		return leaveapptype;
	}
	public void setLeaveapptype(String leaveapptype) {
		this.leaveapptype = leaveapptype;
	}
	public LocalDate getLeavefromdate() {
		return leavefromdate;
	}
	public void setLeavefromdate(LocalDate leavefromdate) {
		this.leavefromdate = leavefromdate;
	}
	public LocalDate getLeavetodate() {
		return leavetodate;
	}
	public void setLeavetodate(LocalDate leavetodate) {
		this.leavetodate = leavetodate;
	}
	public String getLeavefullhalfflag() {
		return leavefullhalfflag;
	}
	public void setLeavefullhalfflag(String leavefullhalfflag) {
		this.leavefullhalfflag = leavefullhalfflag;
	}
	public String getLeaveappremark() {
		return leaveappremark;
	}
	public void setLeaveappremark(String leaveappremark) {
		this.leaveappremark = leaveappremark;
	}
	public String getLeaveappstatus() {
		return leaveappstatus;
	}
	public void setLeaveappstatus(String leaveappstatus) {
		this.leaveappstatus = leaveappstatus;
	}
	
    @PrePersist
    @PreUpdate
    public void updateLastEditTime() {
        this.lasteditdatetime = LocalDateTime.now();
    }
    
	public Integer getLastaddeditby() {
		return lastaddeditby;
	}
	
	public void setLastaddeditby(Integer lastaddeditby) {
		this.lastaddeditby = lastaddeditby;
	}
	
	public LocalDateTime getLasteditdatetime() {
		return lasteditdatetime;
	}
	public void setLasteditdatetime(LocalDateTime lasteditdatetime) {
		this.lasteditdatetime = lasteditdatetime;
	}
	public LeaveApplication(Integer leaveappid, LocalDate leaveappdate, String leaveapptype, LocalDate leavefromdate,
			LocalDate leavetodate, String leavefullhalfflag, String leaveappremark, String leaveappstatus,
			Integer lastaddeditby, LocalDateTime lasteditdatetime) {
		super();
		this.leaveappid = leaveappid;
		this.leaveappdate = leaveappdate;
		this.leaveapptype = leaveapptype;
		this.leavefromdate = leavefromdate;
		this.leavetodate = leavetodate;
		this.leavefullhalfflag = leavefullhalfflag;
		this.leaveappremark = leaveappremark;
		this.leaveappstatus = leaveappstatus;
		this.lastaddeditby = lastaddeditby;
		this.lasteditdatetime = lasteditdatetime;
	}
	
	public LeaveApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
        
}

