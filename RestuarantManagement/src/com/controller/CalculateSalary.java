package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.model.Employee;
import com.model.Salary;
import com.service.PayrollImpl;
import com.service.IPayroll;

/**
 * Servlet implementation class CalculateSalary
 */
@WebServlet("/CalculateSalary")
public class CalculateSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculateSalary() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		Salary salary = new Salary();
		
		IPayroll ipayroll = new PayrollImpl();
		
		employee = ipayroll.getEmployee(request.getParameter("empid"));
		//PrintWriter w = response.getWriter();
		
		String empid = request.getParameter("empid");
		String month = request.getParameter("month");
		int day = ipayroll.getAttendance(empid, month);
		
		salary.setEmpid(empid);
		salary.setMonth(month);
		
		if(ipayroll.checkEmp(salary.getEmpid()) == false) {
			request.setAttribute("value", "Id no");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
			dispatcher.forward(request, response);
			
		}else if(ipayroll.checkAttendance(salary.getEmpid(), salary.getMonth()) == false) {
			
			request.setAttribute("value", "already");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
			dispatcher.forward(request, response);
		
		}else {
			
			float basicSalary = salary.calcBasicSal(employee.getDesignation());
			salary.setDays(day);
			
			if(day > 21) {
				float overtime = salary.calcOvertime(employee.getDesignation(), salary.getDays());
				salary.setOvertime(overtime);
			}else if(day < 19){
				float leave = salary.calcLeave(employee.getDesignation(), salary.getDays());
				salary.setLeave(leave);
				}
			
			salary.setBasicSal(basicSalary);
			
			
				
			request.setAttribute("salary", salary);
			//w.print(month);
			//w.print(empid);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
			dispatcher.forward(request, response);
		}
	}

}
