package com.util;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.AssetOrder;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

class Testing_Inventory {

	
	IInventory_Asset iinventory_asset;
	
	@Test
	void TestCalcTotPrice() {
	
			iinventory_asset = new Inventory_AssetImpl();
			AssetOrder order = new AssetOrder();
			float output = order.calculateTotPrice(2, 2000);
			assertEquals(4000, output);
			
		}
		
		
	}



	
	

