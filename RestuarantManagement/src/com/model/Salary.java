package com.model;

import java.util.ArrayList;

public class Salary{

	private int salaryid;
	private String empid;
	private String fullname;
	private String month;
	private int days;
	private String date;
	private float basicSal;
	private float overtime;
	private float leave;
	private float netSal;
	private float totSalary;
	private String Status;
	private String Description;
	private ArrayList<Salary> summary;
	
	
	public int getSalaryid() {
		return salaryid;
	}
	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}
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
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(float basicSal) {
		this.basicSal = basicSal;
	}
	public float getOvertime() {
		return overtime;
	}
	public void setOvertime(float overtime) {
		this.overtime = overtime;
	}
	public float getLeave() {
		return leave;
	}
	public void setLeave(float leave) {
		this.leave = leave;
	}
	public float getNetSal() {
		if(days > 21) {
			return netSal = (basicSal + overtime) ;
		}
		else if (days <= 18) {
			return netSal = (basicSal - leave) ;
		}
		else {
			return netSal = basicSal ;
		}
	}
	public void setNetSal(float netSal) {
		this.netSal = netSal;
	}
	public float getTotSalary() {
		return totSalary;
	}
	public void setTotSalary(float totSalary) {
		this.totSalary = totSalary;
	}
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public ArrayList<Salary> getSummary() {
		return summary;
	}
	public void setSummary(ArrayList<Salary> summary) {
		this.summary = summary;
	}
	
	public float calcBasicSal(String designation) {
		if(designation.equals("Manager")) {
			return 70000;
		}
		else if(designation.equals("Clerk")) {
			return 40000;
		}
		else if(designation.equals("Chef")) {
			return 55000;
		}
		else if(designation.equals("Cashier")) {
			return 47000;
		}
		else if(designation.equals("Waiter")) {
			return 35000;
		}
		else if(designation.equals("Trainer")) {
			return 45000;
		}
		else if(designation.equals("Server")) {
			return 25000;
		}
		else {
			return 20000;
		}
	}
	
	public float calcOvertime(String designation, int days) {
		if(designation.equals("Manager")) {
			return 1000*(days-21);
		}
		else if(designation.equals("Clerk")) {
			return 800*(days-21);
		}
		else if(designation.equals("Chef")) {
			return 1200*(days-21);
		}
		else if(designation.equals("Cashier")) {
			return 800*(days-21);
		}
		else if(designation.equals("Waiter")) {
			return 550*(days-21);
		}
		else if(designation.equals("Trainer")) {
			return 820*(days-21);
		}
		else if(designation.equals("Server")) {
			return 400*(days-21);
		}
		else {
			return 200*(days-21);
		}
	}
	
	public float calcLeave(String designation, int days) {
		if(designation.equals("Manager")) {
			return 1000*(19-days);
		}
		else if(designation.equals("Clerk")) {
			return 800*(19-days);
		}
		else if(designation.equals("Chef")) {
			return 1200*(19-days);
		}
		else if(designation.equals("Cashier")) {
			return 800*(19-days);
		}
		else if(designation.equals("Waiter")) {
			return 550*(19-days);
		}
		else if(designation.equals("Trainer")) {
			return 820*(19-days);
		}
		else if(designation.equals("Server")) {
			return 400*(19-days);
		}
		else {
			return 200*(19-days);
		}
	}
}
