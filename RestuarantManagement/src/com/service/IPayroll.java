package com.service;

import java.util.ArrayList;

import com.model.Employee;
import com.model.Leave;
import com.model.Notification;
import com.model.Salary;

public interface IPayroll {

	// Employee
	
	public void registeremployee(Employee employee);
	
	public Employee getEmployee(String empid);
	
	public void updateEmployee(Employee employee);
	
	public void DeleteEmployee(String empid);
	
	public ArrayList<Employee> ListEmployee();
	
	public ArrayList<Employee> DeleteEmployee();
	
	public int totalEmployee();
	
	
	// Leave
	
	public void leaveRequest(Leave leave);
	
	public Leave getLeaveRequest(int leaveid);
	
	public ArrayList<Leave> getEmployeeLeave(String empid);
	
	public void UpdateLeaveRequest(Leave leave);
	
	public void DeleteLeaveRequest(int leaveid);
	
	public ArrayList<Leave> LeaveList();
	
	public int totalLeave();
	
	
	//Salary
	
	public void enterAttendance(Salary salary);
	
	public int getAttendance(String empid, String month);
	
	public void insertSalary(Salary salary);
	
	public ArrayList<Salary> SalaryList(String month);
	
	public Salary getSalary(int salaryid);
	
	public void insertPayroll(Salary salary);
	
	public ArrayList<Salary> MonthlySalary(String month);
	
	public ArrayList<Salary> MonthlySalaryTransaction(String month);
	
	
	// Notification
	
	public float totalAmount(String month);
	
	public void deleteNotification(int notID);
	
	public void sendNotification(Notification notification);
	
	public ArrayList<Notification> notificationList();
	
	
	// Managers
	
	public Employee manager(String department);
	
	
	// Validations
	
	public boolean checkEmpID(String empid);
	
	public boolean checkEmp(String empid);
	
	public boolean checkLeave(String empid);
	
	public boolean checkAttendance(String empid, String month);
	
	public boolean checkSalary(String empid, String month);
	
	public boolean checkTransaction(String month);
	
	public boolean checkFinance(String month);
	
	public boolean checkSalaryTransaction(String month);
	
	public boolean checkMonthlySalary(String month);
	
}
