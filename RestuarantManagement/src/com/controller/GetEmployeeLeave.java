package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Leave;
import com.service.IPayroll;
import com.service.PayrollImpl;

/**
 * Servlet implementation class GetEmployeeLeave
 */
@WebServlet("/GetEmployeeLeave")
public class GetEmployeeLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeLeave() {
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
		Leave leave = new Leave();
		
		if(ipayroll.checkEmp(empid) == false) {
			
			request.setAttribute("value", "Id no");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewEmployeeLeave.jsp");
			dispatcher.forward(request, response);
			
		}else if(ipayroll.checkLeave(empid) == false) {
			
			request.setAttribute("value", "Employee No");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewEmployeeLeave.jsp");
			dispatcher.forward(request, response);
		}else {
			
			ArrayList<Leave> summary = new ArrayList<Leave>();
			summary = ipayroll.getEmployeeLeave(empid);
			
			leave.setSummary(summary);
			
			
			request.setAttribute("leave", leave);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewEmployeeLeave.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
