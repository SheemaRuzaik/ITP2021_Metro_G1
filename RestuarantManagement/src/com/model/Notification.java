package com.model;

import java.util.ArrayList;

public class Notification {

	private int notificationID;
	private String month;
	private float amount;
	private String Description;
	private String date;
	private ArrayList<Notification> summary;
	
	public int getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Notification> getSummary() {
		return summary;
	}
	public void setSummary(ArrayList<Notification> summary) {
		this.summary = summary;
	}
	
	
}
