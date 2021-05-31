package com.model;

import java.util.ArrayList;

public class AssetOrder {
	
	
	private int supp_orderID;
	private String supplierID;
	private int asset_ID;
	private int orderAssetQty;
	private float totalAssetPrice;
	private String dateOrdered;
	
	ArrayList<AssetOrder> assetorderarray;
	


	public ArrayList<AssetOrder> getAssetorderarray() {
		return assetorderarray;
	}

	public void setAssetorderarray(ArrayList<AssetOrder> assetorderarray) {
		this.assetorderarray = assetorderarray;
	}


	Asset asset=new Asset();

	public int getSupp_orderID() {
		return supp_orderID;
	}

	public void setSupp_orderID(int supp_orderID) {
		this.supp_orderID = supp_orderID;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public int getAssetID() {
		return asset_ID ;
	}

	public void setAssetID(int asset_ID) {
		this.asset_ID = asset_ID;
	}

	public int getOrderAssetQty() {
		return orderAssetQty;
	}

	public void setOrderAssetQty(int orderAssetQty) {
		this.orderAssetQty = orderAssetQty;
	}

	public float getTotalAssetPrice() {
		
		return totalAssetPrice;
	}

	public void setTotalAssetPrice(float totalAssetPrice) {
		this.totalAssetPrice = totalAssetPrice;
	}

	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	
	public float calculateTotPrice(int orderAssetQty,float unitPrice) {
		
		return orderAssetQty*unitPrice;
		
		
	}
	
}
