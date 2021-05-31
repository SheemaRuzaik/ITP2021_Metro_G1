package com.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.AssetOrder;
import com.model.Costing;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

class Testing_Inventory {

	
	IInventory_Asset inventory;
	
	//IT19116570
		@Test
		void testcalcTotOrder() {
			inventory = new Inventory_AssetImpl();
			AssetOrder asset = new AssetOrder();
			float output = asset.calculateTotPrice(2,2000);
			assertEquals(4000, output);
		}
		
		//IT19116570
		@Test
		void getProfit() {
			inventory = new Inventory_AssetImpl();
			Costing costing = new Costing();
			float output = costing.calcProfit(800);
			assertEquals(400, output);
		}
		
	}



	
	

