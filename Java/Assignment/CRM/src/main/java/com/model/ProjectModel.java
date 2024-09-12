package com.model;

public class ProjectModel {

	private int pkprojectid, fkcustomerid, projectduration, projectcost, fkregid;
	private String projectname, projectdescription, projectstartdate, projectenddate, projectremarks, projectstatus; 
	private String customerreview, createddatetime, createdbyip;
	public int getPkprojectid() {
		return pkprojectid;
	}
	public void setPkprojectid(int pkprojectid) {
		this.pkprojectid = pkprojectid;
	}
	public int getFkcustomerid() {
		return fkcustomerid;
	}
	public void setFkcustomerid(int fkcustomerid) {
		this.fkcustomerid = fkcustomerid;
	}
	public int getProjectduration() {
		return projectduration;
	}
	public void setProjectduration(int projectduration) {
		this.projectduration = projectduration;
	}
	public int getProjectcost() {
		return projectcost;
	}
	public void setProjectcost(int projectcost) {
		this.projectcost = projectcost;
	}
	public int getFkregid() {
		return fkregid;
	}
	public void setFkregid(int fkregid) {
		this.fkregid = fkregid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getProjectstartdate() {
		return projectstartdate;
	}
	public void setProjectstartdate(String projectstartdate) {
		this.projectstartdate = projectstartdate;
	}
	public String getProjectenddate() {
		return projectenddate;
	}
	public void setProjectenddate(String projectenddate) {
		this.projectenddate = projectenddate;
	}
	public String getProjectremarks() {
		return projectremarks;
	}
	public void setProjectremarks(String projectremarks) {
		this.projectremarks = projectremarks;
	}
	public String getProjectstatus() {
		return projectstatus;
	}
	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	public String getCustomerreview() {
		return customerreview;
	}
	public void setCustomerreview(String customerreview) {
		this.customerreview = customerreview;
	}
	public String getCreateddatetime() {
		return createddatetime;
	}
	public void setCreateddatetime(String createddatetime) {
		this.createddatetime = createddatetime;
	}
	public String getCreatedbyip() {
		return createdbyip;
	}
	public void setCreatedbyip(String createdbyip) {
		this.createdbyip = createdbyip;
	}
	
}
