package com.example.hms2;

//package com.example.hms2;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "mstuom")
@Data
public class MstUom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uomid;

    private String uomname;

    private String description;

    private Integer lastaddeditby;

    private LocalDateTime lasteditdatetime;

	public Integer getUomid() {
		return uomid;
	}

	public void setUomid(Integer uomid) {
		this.uomid = uomid;
	}

	public String getUomname() {
		return uomname;
	}

	public void setUomname(String uomname) {
		this.uomname = uomname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
       
}
