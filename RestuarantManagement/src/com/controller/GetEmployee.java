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
import com.service.IPayroll;

/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
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
		
		String empid = request.getParameter("empid");
		IPayroll ipayroll = new PayrollImpl();
		
		
		if(ipayroll.checkEmp(empid) == false) {
			
			request.setAttribute("value", "Employee No");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewEmployee.jsp");
			dispatcher.forward(request, response);
		}else {
			Employee employee = new Employee();
			employee = ipayroll.getEmployee(empid);
			
			request.setAttribute("employee", employee);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewEmployee.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
