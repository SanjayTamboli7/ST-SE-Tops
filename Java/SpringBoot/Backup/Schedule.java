// ENTITY - Schedule.java
package com.example.hms2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "txnschedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schid; // Primary key, matches the added column

    @ManyToOne
    @JoinColumn(name = "schuserid", referencedColumnName = "ouserid")
    private OtherUser user; // Assuming this maps to the 'mstotheruser' table

    @ManyToOne
    @JoinColumn(name = "schdesignationid", referencedColumnName = "designationid")
    private Designation designation; // Assuming this maps to the 'mstdesignation' table

    @Column(name = "scheduledate")
    private LocalDate scheduledate;

    @Column(name = "fromtime")
    private LocalTime fromtime;

    @Column(name = "totime")
    private LocalTime totime;

    @Column(name = "attendance")
    private String attendance;

    @Column(name = "lastaddeditby")
    private int lastaddeditby;

    @Column(name = "lasteditdatetime")
    private LocalDateTime lasteditdatetime;

	public Long getSchid() {
		return schid;
	}

	public void setSchid(Long schid) {
		this.schid = schid;
	}

	public OtherUser getUser() {
		return user;
	}

	public void setUser(OtherUser user) {
		this.user = user;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public LocalDate getScheduledate() {
		return scheduledate;
	}

	public void setScheduledate(LocalDate scheduledate) {
		this.scheduledate = scheduledate;
	}

	public LocalTime getFromtime() {
		return fromtime;
	}

	public void setFromtime(LocalTime fromtime) {
		this.fromtime = fromtime;
	}

	public LocalTime getTotime() {
		return totime;
	}

	public void setTotime(LocalTime totime) {
		this.totime = totime;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
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
