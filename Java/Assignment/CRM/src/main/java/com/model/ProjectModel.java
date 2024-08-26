package com.model;

public class ProjectModel {

	private int pkProjectID, fkCustomerID, ProjectDuration, ProjectCost, fkRegID;
	private String ProjectName, ProjectDescription, ProjectStartDate, ProjectEndDate, ProjectRemarks, ProjectStatus; 
	private String CustomerReview, CreatedDateTime, CreatedByIP;
	public int getPkProjectID() {
		System.out.println("pkProjectID : " + pkProjectID);
		return pkProjectID;
	}
	public void setPkProjectID(int pkProjectID) {
		this.pkProjectID = pkProjectID;
	}
	public int getFkCustomerID() {
		System.out.println("fkCustomerID : " + fkCustomerID);
		return fkCustomerID;
	}
	public void setFkCustomerID(int fkCustomerID) {
		this.fkCustomerID = fkCustomerID;
	}
	public int getProjectDuration() {
		System.out.println("ProjectDuration : " + ProjectDuration);
		return ProjectDuration;
	}
	public void setProjectDuration(int projectDuration) {
		ProjectDuration = projectDuration;
	}
	public int getProjectCost() {
		System.out.println("ProjectCost : " + ProjectCost);
		return ProjectCost;
	}
	public void setProjectCost(int projectCost) {
		ProjectCost = projectCost;
	}
	public int getFkRegID() {
		System.out.println("fkRegID : " + fkRegID);
		return fkRegID;
	}
	public void setFkRegID(int fkRegID) {
		this.fkRegID = fkRegID;
	}
	public String getProjectName() {
		System.out.println("ProjectName : " + ProjectName);
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectDescription() {
		System.out.println("ProjectDescription : " + ProjectDescription);
		return ProjectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}
	public String getProjectStartDate() {
		System.out.println("ProjectStartDate : " + ProjectStartDate);
		return ProjectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		ProjectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		System.out.println("ProjectEndDate : " + ProjectEndDate);
		return ProjectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		ProjectEndDate = projectEndDate;
	}
	public String getProjectRemarks() {
		System.out.println("ProjectRemarks : " + ProjectRemarks);
		return ProjectRemarks;
	}
	public void setProjectRemarks(String projectRemarks) {
		ProjectRemarks = projectRemarks;
	}
	public String getProjectStatus() {
		System.out.println("ProjectStatus : " + ProjectStatus);
		return ProjectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}
	public String getCustomerReview() {
		System.out.println("CustomerReview : " + CustomerReview);
		return CustomerReview;
	}
	public void setCustomerReview(String customerReview) {
		CustomerReview = customerReview;
	}
	public String getCreatedDateTime() {
		System.out.println("CreatedDateTime : " + CreatedDateTime);
		return CreatedDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	public String getCreatedByIP() {
		System.out.println("CreatedByIP : " + CreatedByIP);
		return CreatedByIP;
	}
	public void setCreatedByIP(String createdByIP) {
		CreatedByIP = createdByIP;
	}		
	
}
