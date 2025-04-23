//DTO - ScheduleDTO.java
package com.example.hms2;

public class ScheduleDTO {
 private Long schid;
 private int schuserid;
 private int schdesignationid;
 private String scheduledate;
 private String fromtime;
 private String totime;
 private String attendance;
 private String ousername;
 private String designationname;
 private int lastaddeditby;
 
public Long getSchid() {
	return schid;
}
public void setSchid(Long schid) {
	this.schid = schid;
}
//public Long getId() {
//	return id;
//}
//public void setId(Long id) {
//	this.id = id;
//}
public int getSchuserid() {
	return schuserid;
}
public void setSchuserid(int schuserid) {
	this.schuserid = schuserid;
}
public int getSchdesignationid() {
	return schdesignationid;
}
public void setSchdesignationid(int schdesignationid) {
	this.schdesignationid = schdesignationid;
}
public String getScheduledate() {
	return scheduledate;
}
public void setScheduledate(String scheduledate) {
	this.scheduledate = scheduledate;
}
public String getFromtime() {
	return fromtime;
}
public void setFromtime(String fromtime) {
	this.fromtime = fromtime;
}
public String getTotime() {
	return totime;
}
public void setTotime(String totime) {
	this.totime = totime;
}
public String getAttendance() {
	return attendance;
}
public void setAttendance(String attendance) {
	this.attendance = attendance;
}
public String getOusername() {
	return ousername;
}
public void setOusername(String ousername) {
	this.ousername = ousername;
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
 
 
}
