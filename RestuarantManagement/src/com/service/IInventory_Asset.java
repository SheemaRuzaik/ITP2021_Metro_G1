package com.service;

import java.util.ArrayList;

import com.model.Asset;
import com.model.AssetOrder;
import com.model.Costing;
import com.model.Inventory;
import com.model.Supplier;




public interface IInventory_Asset {
	
	//for Costing
	
		public void addCosting(Costing cost);
		public Costing getCosting(String food_description);
		public void DeleteCosting(String food_description);
		public void updateCosting(Costing cost);
		public ArrayList<Costing> ListCosting();
		
		
		
	//for Asset
		
		public void addAsset(Asset asset);
		public Asset getAsset(int assetID);
		public void DeleteAsset(int assetID);
		public void updateAsset(Asset asset);
		public ArrayList<Asset> ListAsset();
		
		
	//for Inventory
		

		public void addInventory(Inventory inv);
		public Inventory getInventory(int inventoryID);
		public void DeleteInventory(int inventoryID);
		public void updateInventory(Inventory inv);
		public ArrayList<Inventory> ListInventory();
		
		
	//for Asset Orders
		
		public void addOrder(AssetOrder order);
		public float getUnitPrice(int asset_ID);
		public AssetOrder getOrder(int supp_orderID);
		public void DeleteOrder(int supp_orderID);
		public void updateOrder(AssetOrder order);
		public ArrayList<AssetOrder> ListAssetOrder();
		
	//generate report
		
		public ArrayList<AssetOrder> generateReport(String supp_ID);
		

		
	//to get supplier list

		public ArrayList<Supplier> ListSupplier();
		
}
