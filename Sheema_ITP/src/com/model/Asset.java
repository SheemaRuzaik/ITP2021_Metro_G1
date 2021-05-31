package com.model;

public class Asset {

	private int assetID;
	private String supplierID_asst;
	private String asset_desc;
	private String makeType;
	private String model;
	private int maxStock;
	private float unitAssetPrice;
	private String remarks;

	public int getAssetID() {
		return assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public String getSupplierID_asst() {
		return supplierID_asst;
	}

	public void setSupplierID_asst(String supplierID_asst) {
		this.supplierID_asst = supplierID_asst;
	}


	public String getAsset_desc() {
		return asset_desc;
	}

	public void setAsset_desc(String asset_desc) {
		this.asset_desc = asset_desc;
	}

	public String getMakeType() {
		return makeType;
	}

	public void setMakeType(String makeType) {
		this.makeType = makeType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public float getUnitAssetPrice() {
		return unitAssetPrice;
	}

	public void setUnitAssetPrice(float unitAssetPrice) {
		this.unitAssetPrice = unitAssetPrice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
