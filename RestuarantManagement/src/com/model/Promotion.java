package com.model;

public class Promotion {

	private int id;
	private String code,u_name,sdate,edate,type,description;
	private double r_price,d_price;
	
	public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getU_name() {
		return u_name;
	}
	public String getSdate() {
		return sdate;
	}
	public String getEdate() {
		return edate;
	}
	public String getType() {
		return type;
	}
	public double getR_price() {
		return r_price;
	}
	public double getD_price() {
		return d_price;
	}
	public String getDescription() {
		return description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setR_price(double r_price) {
		this.r_price = r_price;
	}
	public void setD_price(double d_price) {
		this.d_price = d_price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
