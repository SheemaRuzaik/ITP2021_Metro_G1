package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Employee;
import com.model.Leave;
import com.model.Notification;
import com.model.Salary;
import com.util.DBConnection;

public class PayrollImpl implements IPayroll{

	private static Connection connection;
	private static PreparedStatement pt;
	//private static CallableStatement ct;
	//private static Statement st; 
	
	
	// Employee
	
	// ------------Add new employee------------
	@Override
	public void registeremployee(Employee employee) {
		// TODO Auto-generated method stub
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("insert into Employee(Emp_Id,FullName,Email,Nic,Contact,Address,Dob,Gender,Joined_date,Department,Designation,Status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pt.setString(1, employee.getEmpid());
			pt.setString(2, employee.getFullname());
			pt.setString(3, employee.getEmail());
			pt.setString(4, employee.getNic());
			pt.setString(5, employee.getContact());
			pt.setString(6, employee.getAddress());
			pt.setString(7, employee.getDob());
			pt.setString(8, employee.getGender());
			pt.setString(9, employee.getJoin_date());
			pt.setString(10, employee.getDepartment());
			pt.setString(11, employee.getDesignation());
			pt.setString(12, "Active");
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------Delete employee------------
	@Override
	public void DeleteEmployee(String empid) {
		// TODO Auto-generated method stub
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("update Employee set Status=? where Emp_Id=?");
			pt.setString(1, "Exit");
			pt.setString(2,empid);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	// ------------Retrieve employee details------------
	@Override
	public Employee getEmployee(String empid) {
		// TODO Auto-generated method stub
		
		Employee employee=new Employee();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Employee where Emp_Id=?");
			pt.setString(1, empid);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				employee.setEmpid(result.getString(1));
				employee.setFullname(result.getString(2));
				employee.setEmail(result.getString(3));
				employee.setNic(result.getString(4));
				employee.setContact(result.getString(5));
				employee.setDob(result.getString(6));
				employee.setAddress(result.getString(7));
				employee.setGender(result.getString(8));
				employee.setJoin_date(result.getString(9));
				employee.setDepartment(result.getString(10));
				employee.setDesignation(result.getString(11));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}

	// ------------Update employee details------------
	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("update Employee set FullName=?,Email=?,Nic=?,Contact=?,Address=?,Dob=?,Joined_date=?,Gender=?,Department=?,Designation=? where Emp_Id=?");
			pt.setString(1, employee.getFullname());
			pt.setString(2, employee.getEmail());
			pt.setString(3, employee.getNic());
			pt.setString(4, employee.getContact());
			pt.setString(5, employee.getAddress());
			pt.setString(6, employee.getDob());
			pt.setString(7, employee.getJoin_date());
			pt.setString(8, employee.getGender());
			pt.setString(10, employee.getDesignation());
			pt.setString(9, employee.getDepartment());
			
			pt.setString(11, employee.getEmpid());
			
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ------------Employee List------------
	@Override
	public ArrayList<Employee> ListEmployee() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees=new ArrayList<>();
		   
        try {
				   connection=DBConnection.initializedb();
				   pt=connection.prepareStatement("Select * from Employee where Status=?");
				   pt.setString(1, "Active");
				   ResultSet result=pt.executeQuery();
				   
				   while(result.next()) {
					   
					   Employee employee = new Employee();
					   
					   employee.setEmpid(result.getString(1));
					   employee.setFullname(result.getString(2));
					   employee.setEmail(result.getString(3));
					   employee.setNic(result.getString(4));
					   employee.setContact(result.getString(5));
					   employee.setAddress(result.getString(7));
					   employee.setDob(result.getString(6));
					   employee.setGender(result.getString(8));
					   employee.setJoin_date(result.getString(9));
					   employee.setDepartment(result.getString(10));
					   employee.setDesignation(result.getString(11));
					   
					   employees.add(employee);
					   
				   }
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				   
        return employees;

	}

	// ------------Retire employee list------------
	@Override
	public ArrayList<Employee> DeleteEmployee() {
		// TODO Auto-generated method stub
		
		ArrayList<Employee> employees=new ArrayList<>();
		   
        try {
				   connection=DBConnection.initializedb();
				   pt=connection.prepareStatement("Select * from Employee where Status=?");
				   pt.setString(1, "Exit");
				   ResultSet result=pt.executeQuery();
				   
				   while(result.next()) {
					   
					   Employee employee = new Employee();
					   
					   employee.setEmpid(result.getString(1));
					   employee.setFullname(result.getString(2));
					   employee.setEmail(result.getString(3));
					   employee.setNic(result.getString(4));
					   employee.setContact(result.getString(5));
					   employee.setAddress(result.getString(7));
					   employee.setDob(result.getString(6));
					   employee.setGender(result.getString(8));
					   employee.setJoin_date(result.getString(9));
					   employee.setDepartment(result.getString(10));
					   employee.setDesignation(result.getString(11));
					   
					   employees.add(employee);
					   
				   }
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				   
        return employees;
	}

	// ------------Total Number Of Employee------------
	@Override
	public int totalEmployee() {
		
		int total = 0;
		//Employee employee=new Employee();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select count(*) from Employee where Status=?");
			pt.setString(1, "Active");
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				total = result.getInt(1);
			}
		}catch (Exception e) {
				
			}
		return total;
	}

	
	// Leave

	// ------------Add new Leave Request------------
	@Override
	public void leaveRequest(Leave leave) {
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("insert into LeaveRequest(Emp_Id,From_date,To_date,NoOfDays,reason,Status) values(?,?,?,?,?,?)");
			pt.setString(1, leave.getEmpid());
			pt.setString(2, leave.getFromdate());
			pt.setString(3, leave.getTodate());
			pt.setInt(4, leave.getNoOfdays());
			pt.setString(5, leave.getReason());
			pt.setString(6, leave.getStatus());
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// ------------Retrieve Leave Request details------------
	@Override
	public Leave getLeaveRequest(int leaveid) {
		
		Leave leave = new Leave();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from LeaveRequest where Leave_ID=?");
			pt.setInt(1, leaveid);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				leave.setLeaveId(result.getInt(1));
				leave.setEmpid(result.getString(2));
				leave.setFromdate(result.getString(3));
				leave.setTodate(result.getString(4));
				leave.setNoOfdays(result.getInt(5));
				leave.setReason(result.getString(6));
				leave.setStatus(result.getString(7));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return leave;
	}
	
	// ------------Particular Employee Leave Request List------------
	@Override
	public ArrayList<Leave> getEmployeeLeave(String empid) {
		
		ArrayList<Leave> leaves = new ArrayList<Leave>();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from LeaveRequest where Emp_Id=?");
			pt.setString(1, empid);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				Leave leave = new Leave();
				
				leave.setLeaveId(result.getInt(1));
				leave.setEmpid(result.getString(2));
				leave.setFromdate(result.getString(3));
				leave.setTodate(result.getString(4));
				leave.setNoOfdays(result.getInt(5));
				leave.setReason(result.getString(6));
				leave.setStatus(result.getString(7));
				
				leaves.add(leave);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return leaves;
	}

	// ------------Update Leave Request details------------
	@Override
	public void UpdateLeaveRequest(Leave leave) {
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("update LeaveRequest set Emp_Id=?,From_date=?,To_date=?,NoOfDays=?,Reason=?,Status=? where Leave_ID=?");
			
			pt.setString(1, leave.getEmpid());
			pt.setString(2, leave.getFromdate());
			pt.setString(3, leave.getTodate());
			pt.setInt(4, leave.getNoOfdays());
			pt.setString(5, leave.getReason());
			pt.setString(6, leave.getStatus());
			
			pt.setInt(7, leave.getLeaveId());
			
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Delete Leave Request------------
	@Override
	public void DeleteLeaveRequest(int leaveid) {
		
		try {
			connection=DBConnection.initializedb();
			
			
			pt=connection.prepareStatement("delete from LeaveRequest where Leave_ID=?");
			pt.setInt(1,leaveid);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Leave Request List------------
	@Override
	public ArrayList<Leave> LeaveList() {
		
		ArrayList<Leave> leave=new ArrayList<>();   
        
        try {
				   connection=DBConnection.initializedb();
				   pt=connection.prepareStatement("Select * from LeaveRequest");
				   ResultSet result=pt.executeQuery();
				   
				   while(result.next()) {
					   
					   Leave leaves = new Leave();
					   
					   leaves.setLeaveId(result.getInt(1));
					   leaves.setEmpid(result.getString(2));
					   leaves.setFromdate(result.getString(3));
					   leaves.setTodate(result.getString(4));
					   leaves.setNoOfdays(result.getInt(5));
					   leaves.setReason(result.getString(6));
					   leaves.setStatus(result.getString(7));
					   
					   leave.add(leaves);
				   }
				   
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				   
        return leave;
	}

	// ------------Total number of Leave Request------------
	@Override
	public int totalLeave() {
		
		int total = 0;
		//Employee employee=new Employee();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select count(*) from LeaveRequest");
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				total = result.getInt(1);
			}
		}catch (Exception e) {
				
			}
		return total;
	}


	// Salary
	
	// ------------Enter Monthly Attendance------------
	@Override
	public void enterAttendance(Salary salary) {
		// TODO Auto-generated method stub
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("insert into Attendance(emp_id,AttendMonth,tot_days_per_month) values(?,?,?)");
			pt.setString(1, salary.getEmpid());
			pt.setString(2, salary.getMonth());
			pt.setInt(3, salary.getDays());
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Retrieve No Of Days Attended in a month------------
	@Override
	public int getAttendance(String empid, String month) {
		// TODO Auto-generated method stub
		
		int attendance = 0;
		//Employee employee=new Employee();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Attendance where emp_id=? AND AttendMonth=?");
			pt.setString(1, empid);
			pt.setString(2, month);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				attendance = result.getInt(3);
			}
		}catch (Exception e) {
				
			}
		return attendance;
	}

	// ------------Insert Salary------------
	@Override
	public void insertSalary(Salary salary) {
		// TODO Auto-generated method stub
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("insert into Salary(Emp_Id,AttendMonth,noOfDays,BasicSal,OverTime,Leave,NetSalary) values(?,?,?,?,?,?,?)");
			pt.setString(1, salary.getEmpid());
			pt.setString(2, salary.getMonth());
			pt.setInt(3, salary.getDays());
			pt.setFloat(4, salary.getBasicSal());
			pt.setFloat(5, salary.getOvertime());
			pt.setFloat(6, salary.getLeave());
			pt.setFloat(7, salary.getTotSalary());
			
			pt.execute();
			pt.close();
			
			pt=connection.prepareStatement("insert into SalaryTransaction(Emp_ID,Month,Status,Amount) values(?,?,?,?)");
			pt.setString(1, salary.getEmpid());
			pt.setString(2, salary.getMonth());
			pt.setString(3, "Not Paid");
			pt.setFloat(4, salary.getTotSalary());
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Monthly Salary Payment List------------
	@Override
	public ArrayList<Salary> SalaryList(String month) {
		
		ArrayList<Salary> salary=new ArrayList<>();   
        
        try {
				   connection=DBConnection.initializedb();
				   pt=connection.prepareStatement("Select * from SalaryTransaction where Month=?");
				   pt.setString(1, month);
				   ResultSet result=pt.executeQuery();
				   
				   while(result.next()) {
					   
					   Salary salaries = new Salary();
					   
					   salaries.setSalaryid(result.getInt(1));
					   salaries.setEmpid(result.getString(2));
					   salaries.setMonth(result.getString(3));
					   salaries.setStatus(result.getString(4));
					   salaries.setTotSalary(result.getFloat(5));
					   
					   salary.add(salaries);
				   }
				   
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 				   
        return salary;
	}
	
	// ------------Get Monthly Salary Payment details------------
	@Override
	public Salary getSalary(int salaryid) {
		
		Salary salary = new Salary();

		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from SalaryTransaction where ST_Id=?");
			pt.setInt(1, salaryid);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				salary.setSalaryid(result.getInt(1));
				salary.setEmpid(result.getString(2));
				salary.setMonth(result.getString(3));
				salary.setStatus(result.getString(4));
				salary.setTotSalary(result.getFloat(5));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return salary;
	}
	
	// ------------Insert Monthly Salary Payment------------
	@Override
	public void insertPayroll(Salary salary) {
		// TODO Auto-generated method stub
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("update SalaryTransaction set Status=? where Emp_ID=? and Month=?");
			pt.setString(1, "Paid");
			
			pt.setString(2, salary.getEmpid());
			pt.setString(3, salary.getMonth());
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Generate Report for Monthly Salary Details------------
	@Override
	public ArrayList<Salary> MonthlySalary(String month) {
		// TODO Auto-generated method stub

		ArrayList<Salary> salary2 = new ArrayList<>();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select Emp_Id,NoOfDays,BasicSal,OverTime,Leave,NetSalary from Salary where AttendMonth=?");
			pt.setString(1, month);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				Salary salary = new Salary();
				
				salary.setEmpid(result.getString(1));
				salary.setDays(result.getInt(2));
				salary.setBasicSal(result.getFloat(3));
				salary.setOvertime(result.getFloat(4));
				salary.setLeave(result.getFloat(5));
				salary.setTotSalary(result.getFloat(6));
				
				salary2.add(salary);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
					
						e.printStackTrace();
		}
		return salary2;
	}

	// ------------Generate Report for Monthly Salary Transaction Details------------
	@Override
	public ArrayList<Salary> MonthlySalaryTransaction(String month) {
		// TODO Auto-generated method stub
		
		ArrayList<Salary> salary2 = new ArrayList<>();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select ST_ID,Emp_ID,Amount,E_date from SalaryTransaction where Month=?");
			pt.setString(1, month);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				Salary salary = new Salary();
				
				salary.setSalaryid(result.getInt(1));
				salary.setEmpid(result.getString(2));
				salary.setTotSalary(result.getFloat(3));
				salary.setDate(result.getString(4));
				
				salary2.add(salary);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
					
						e.printStackTrace();
		}
		return salary2;
	}

	
	// Notifications
	
	// ------------Calculate total Monthly Salary Payment------------
	@Override
	public float totalAmount(String month) {

		float amount = 0;
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select sum(Amount) from SalaryTransaction where Month = ? and Status=? ");
			pt.setString(1, month);
			pt.setString(2, "Paid");
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				amount = result.getFloat(1);
			}
		}catch (Exception e) {
				
			}
		return amount;
	}

	// ------------send total Monthly Salary payment to POS & Transaction management------------
	@Override
	public void sendNotification(Notification notification) {
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("insert into Notification(Month,Amount,description) values(?,?,?)");
			pt.setString(1, notification.getMonth());
			pt.setFloat(2, notification.getAmount());
			pt.setString(3, "Salary Paid");
			
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Delete Finance List------------
	@Override
	public void deleteNotification(int notID) {
		
		try {
			connection=DBConnection.initializedb();
			
			
			pt=connection.prepareStatement("delete from Notification where not_id=?");
			pt.setInt(1,notID);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// ------------Finance List------------
	@Override
	public ArrayList<Notification> notificationList() {
		
		ArrayList<Notification> notification = new ArrayList<>();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Notification");
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				Notification not = new Notification();
				
				not.setNotificationID(result.getInt(1));
				not.setMonth(result.getString(2));
				not.setAmount(result.getFloat(3));
				not.setDescription(result.getString(4));
				not.setDate(result.getString(5));
				
				notification.add(not);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
					
						e.printStackTrace();
		}
		
		return notification;
	}


	
	// Manager
	
	// ------------Retrieve Department Managers------------
	@Override
	public Employee manager(String department) {
		
		Employee employee=new Employee();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Employee where Department=? and Designation=? and Status=?");
			pt.setString(1, department);
			pt.setString(2, "Manager");
			pt.setString(3, "Active");
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				employee.setEmpid(result.getString(1));
				employee.setFullname(result.getString(2));
				employee.setDepartment(result.getString(10));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}

	
	// Validations
	
	// ------------Check Employee------------
	@Override
	public boolean checkEmpID(String empid) {
		// TODO Auto-generated method stub
		boolean find=false;
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Employee where Emp_Id=?");
			pt.setString(1, empid);
			ResultSet res = pt.executeQuery();
			find=res.next();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return find;
	}

	// ------------Check Active Employee------------
	@Override
	public boolean checkEmp(String empid) {
		// TODO Auto-generated method stub
		
		boolean find=false;
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Employee where Emp_Id=? and Status=?");
			pt.setString(1, empid);
			pt.setString(2, "Active");
			ResultSet res = pt.executeQuery();
			find=res.next();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return find;
		
	}

	// ------------Check Employee in Leave Request Table------------
	@Override
	public boolean checkLeave(String empid) {
		// TODO Auto-generated method stub
		boolean find=true;
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from LeaveRequest where Emp_Id=?");
			pt.setString(1, empid);
			ResultSet res = pt.executeQuery();
			find=res.next();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return find;
	}

	// ------------Check Employee and Month in Attendance Table------------
	@Override
	public boolean checkAttendance(String empid, String month) {
		// TODO Auto-generated method stub
		
		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Attendance where emp_id=? and AttendMonth=?");
			pt.setString(1, empid);
			pt.setString(2, month);
			ResultSet res=pt.executeQuery();
			find = res.next();
			//find = true;
			
		}catch(ClassNotFoundException e) {
			
			e.printStackTrace();
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}

	// ------------Check Employee and Month in salary table------------
	@Override
	public boolean checkSalary(String empid, String month) {
		// TODO Auto-generated method stub
		
		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Salary where Emp_Id=? and AttendMonth=?");
			pt.setString(1, empid);
			pt.setString(2, month);
			ResultSet res=pt.executeQuery();
			find = res.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}

	// ------------Check Salary Transaction is paid or not------------
	@Override
	public boolean checkTransaction(String month) {
		
		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from SalaryTransaction where Month=? and Status=?");
			pt.setString(1, month);
			pt.setString(2, "Paid");
			ResultSet res=pt.executeQuery();
			find = res.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}

	// ------------Check Salary Transaction month------------
	@Override
	public boolean checkSalaryTransaction(String month) {

		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from SalaryTransaction where Month=?");
			pt.setString(1, month);
			ResultSet res=pt.executeQuery();
			find = res.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}

	// ------------Check Salary in a month------------
	@Override
	public boolean checkMonthlySalary(String month) {

		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Salary where AttendMonth=?");
			pt.setString(1, month);
			ResultSet res=pt.executeQuery();
			find = res.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}

	// ------------Check finance in a month------------
	@Override
	public boolean checkFinance(String month) {

		boolean find = true;
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("select * from Notification where Month=?");
			pt.setString(1, month);
			ResultSet res=pt.executeQuery();
			find = res.next();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return find;
	}


	
}
