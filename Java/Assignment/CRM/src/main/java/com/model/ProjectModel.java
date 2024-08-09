package com.model;

public class ProjectModel {

	private int pkProjectID, fkCustomerID, ProjectDuration, ProjectCost, fkRegID;
	private String ProjectName, ProjectDescription, ProjectStartDate, ProjectEndDate, ProjectRemarks, ProjectStatus, CustomerReview, CreatedDateTime, CreatedByIP;
	public int getPkProjectID() {
		return pkProjectID;
	}
	public void setPkProjectID(int pkProjectID) {
		this.pkProjectID = pkProjectID;
	}
	public int getFkCustomerID() {
		return fkCustomerID;
	}
	public void setFkCustomerID(int fkCustomerID) {
		this.fkCustomerID = fkCustomerID;
	}
	public int getProjectDuration() {
		return ProjectDuration;
	}
	public void setProjectDuration(int projectDuration) {
		ProjectDuration = projectDuration;
	}
	public int getProjectCost() {
		return ProjectCost;
	}
	public void setProjectCost(int projectCost) {
		ProjectCost = projectCost;
	}
	public int getFkRegID() {
		return fkRegID;
	}
	public void setFkRegID(int fkRegID) {
		this.fkRegID = fkRegID;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectDescription() {
		return ProjectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}
	public String getProjectStartDate() {
		return ProjectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		ProjectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return ProjectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		ProjectEndDate = projectEndDate;
	}
	public String getProjectRemarks() {
		return ProjectRemarks;
	}
	public void setProjectRemarks(String projectRemarks) {
		ProjectRemarks = projectRemarks;
	}
	public String getProjectStatus() {
		return ProjectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}
	public String getCustomerReview() {
		return CustomerReview;
	}
	public void setCustomerReview(String customerReview) {
		CustomerReview = customerReview;
	}
	public String getCreatedDateTime() {
		return CreatedDateTime;
	}
	public void setCreatedDateTime(String createdDateTime) {
		CreatedDateTime = createdDateTime;
	}
	public String getCreatedByIP() {
		return CreatedByIP;
	}
	public void setCreatedByIP(String createdByIP) {
		CreatedByIP = createdByIP;
	}		
	
}
