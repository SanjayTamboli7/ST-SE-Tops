package com.example.hms2;

import java.time.LocalDateTime;

public class MaxStockUpdateDTO {
    private Integer maxstock;
    private Integer lastaddeditby;
    private LocalDateTime lasteditdatetime;
	public Integer getMaxstock() {
		return maxstock;
	}
	public void setMaxstock(Integer maxstock) {
		this.maxstock = maxstock;
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

