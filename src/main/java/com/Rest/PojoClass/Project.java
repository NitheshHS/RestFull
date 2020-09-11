package com.Rest.PojoClass;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({
	 "projectId",
	 "projectName",
	 "createdOn",
	 "createdBy",
	 "status",
	 "teamSize"
})
public class Project {

	String projectName;
	String projectid;
	String createdOn;
	String createdBy;
	String status;
	int teamSize;
	public Project(String projectName, String projectid, String createdOn, String createdBy, String status,
			int teamSize) {
		super();
		this.projectName = projectName;
		this.projectid = projectid;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
	}
	public Project() {}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	

}
