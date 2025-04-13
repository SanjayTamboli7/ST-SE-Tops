package com.example.hms2;

//package com.example.holidaymanagement.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.sql.Date;

@Entity
@Table(name = "mstholiday")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Holiday {
    @Id
    private Date holidaydate;

    @Column(nullable = false, length = 50)
    private String holidayname;

    @Column(nullable = false, length = 10)
    private String holidaytype;

    @Column(length = 255)
    private String holidaydescription;

    @Column(nullable = false)
    private int lastaddeditby;

    @Column(nullable = false)
    private LocalDateTime lasteditdatetime;

	public Date getHolidaydate() {
		return holidaydate;
	}

	public void setHolidaydate(Date holidaydate) {
		this.holidaydate = holidaydate;
	}

	public String getHolidayname() {
		return holidayname;
	}

	public void setHolidayname(String holidayname) {
		this.holidayname = holidayname;
	}

	public String getHolidaytype() {
		return holidaytype;
	}

	public void setHolidaytype(String holidaytype) {
		this.holidaytype = holidaytype;
	}

	public String getHolidaydescription() {
		return holidaydescription;
	}

	public void setHolidaydescription(String holidaydescription) {
		this.holidaydescription = holidaydescription;
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
