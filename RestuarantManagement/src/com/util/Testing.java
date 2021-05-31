package com.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.model.AssetOrder;
import com.model.Costing;
import com.model.POS;
import com.model.Salary;
import com.service.IInventory_Asset;
import com.service.IPOS;
import com.service.IPayroll;
import com.service.Inventory_AssetImpl;
import com.service.POSImpl;
import com.service.PayrollImpl;

class Testing {

	IPayroll ipayroll;
	IPOS ipos;
	IInventory_Asset inventory;
	
	
	//IT19991986
	@Test
	void AttendanceOfEmployee() {
		ipayroll = new PayrollImpl();
		int output = ipayroll.getAttendance("E0001", "2021-01");
		assertEquals(25, output);
	}

	//IT19991986
	@Test
	void TestOfOverTime() {
		ipayroll = new PayrollImpl();
		Salary salary = new Salary();
		float output = salary.calcOvertime("Cashier", 23);
		assertEquals(1600, output);
	}

	//IT19967530
	@Test
	void CalculateTotPrice() {
		ipos = new POSImpl();
		POS pos = new POS();
		float output = pos.calTotal(5,200);
		assertEquals(1000, output);
	}

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
