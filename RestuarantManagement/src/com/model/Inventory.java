package com.model;

public class Inventory {
	
	private int inventoryID;
	private String supplierID_inv;
	private String inventory_desc;
	private int maxStock_inv;
	private int orderQty_inv;
	private float unitPrice_inv;
	private float totalPrice;
	private String availableStatus;
	private String frequency;
	private String remarks_inv;
	
	
	
	public int getInventoryID() {
		
		return inventoryID;
	}
	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}
	public String getSupplierID_inv() {
		return supplierID_inv;
	}
	public void setSupplierID_inv(String supplierID_inv) {
		this.supplierID_inv = supplierID_inv;
	}
	public String getInventory_desc() {
		return inventory_desc;
	}
	public void setInventory_desc(String inventory_desc) {
		this.inventory_desc = inventory_desc;
	}

	public int getMaxStock_inv() {
		return maxStock_inv;
	}
	public void setMaxStock_inv(int maxStock_inv) {
		this.maxStock_inv = maxStock_inv;
	}
	public int getOrderQty_inv() {
		return orderQty_inv;
	}
	public void setOrderQty_inv(int orderQty_inv) {
		this.orderQty_inv = orderQty_inv;
	}
	public float getUnitPrice_inv() {
		return unitPrice_inv;
	}
	public void setUnitPrice_inv(float unitPrice_inv) {
		this.unitPrice_inv = unitPrice_inv;
	}
	public float getTotalPrice() {
		
		return (unitPrice_inv*orderQty_inv);
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAvailableStatus() {
		if (maxStock_inv>0) {
			
			return "YES";
		
		}else {
			return "NO";
		}
		
	
	}
	public void setAvailableStatus(String availableStatus) {
		this.availableStatus = availableStatus;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getRemarks_inv() {
		return remarks_inv;
	}
	public void setRemarks_inv(String remarks_inv) {
		this.remarks_inv = remarks_inv;
	}
	
	
	
	

}
