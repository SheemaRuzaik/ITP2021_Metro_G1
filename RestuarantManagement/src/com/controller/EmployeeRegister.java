package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.service.PayrollImpl;

/**
 * Servlet implementation class EmployeeRegister
 */
@WebServlet("/EmployeeRegister")
public class EmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegister() {
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
		
		Employee employee=new Employee();
		PayrollImpl ipayroll=new PayrollImpl();
		
		employee.setEmpid(request.getParameter("empid"));
		employee.setFullname(request.getParameter("fullname"));
		employee.setEmail(request.getParameter("email"));
		employee.setNic(request.getParameter("nic"));
		employee.setContact(request.getParameter("phone"));
		employee.setAddress(request.getParameter("address"));
		employee.setDob(request.getParameter("dob"));;
		employee.setGender(request.getParameter("gender"));
		employee.setJoin_date(request.getParameter("join"));
		employee.setDepartment(request.getParameter("dept"));
		employee.setDesignation(request.getParameter("desc"));
		
		if(ipayroll.checkEmpID(employee.getEmpid()) == false) {
			
			ipayroll.registeremployee(employee);
			
			request.setAttribute("value", "Employee Added");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("value", "Employee Exist");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.forward(request, response);
		}
	}

}
