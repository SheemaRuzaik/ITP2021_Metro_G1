package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Salary;
import com.service.IPayroll;
import com.service.PayrollImpl;

/**
 * Servlet implementation class SalaryPayment
 */
@WebServlet("/SalaryPayment")
public class SalaryPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaryPayment() {
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
		
		Salary salary = new Salary();
		IPayroll ipayroll = new PayrollImpl();
		
		int stid = Integer.parseInt(request.getParameter("expanse"));
		
		salary.setSalaryid(stid);
		salary.setEmpid(request.getParameter("empid"));
		salary.setMonth(request.getParameter("month"));
		salary.setTotSalary(Float.parseFloat(request.getParameter("netsal")));
		//salary.setStatus(request.getParameter("status"));
		
		ipayroll.insertPayroll(salary);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Payroll.jsp");
		dispatcher.forward(request, response);
	}

}
