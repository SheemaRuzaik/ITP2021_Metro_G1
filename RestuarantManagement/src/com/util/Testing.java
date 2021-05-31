package com.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import com.model.Salary;
import com.service.IPayroll;
import com.service.PayrollImpl;

class Testing {

	IPayroll ipayroll;
	
	
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

	
}
