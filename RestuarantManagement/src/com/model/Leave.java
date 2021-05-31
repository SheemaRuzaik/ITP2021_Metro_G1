package com.model;

import java.util.ArrayList;

public class Leave{

	private String empid;
	private String fullname;
	private int leaveId;
	private String fromdate;
	private String todate;
	private int noOfdays;
	private String reason;
	private String status;
	private ArrayList<Leave> summary;
	
	
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public int getNoOfdays() {
		return noOfdays;
	}
	public void setNoOfdays(int noOfdays) {
		this.noOfdays = noOfdays;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public ArrayList<Leave> getSummary() {
		return summary;
	}
	public void setSummary(ArrayList<Leave> summary) {
		this.summary = summary;
	}
	
	
}
