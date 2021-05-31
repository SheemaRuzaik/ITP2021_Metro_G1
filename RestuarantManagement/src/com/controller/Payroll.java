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
 * Servlet implementation class Payroll
 */
@WebServlet("/Payroll")
public class Payroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payroll() {
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
		
		salary.setEmpid(request.getParameter("empid"));
		salary.setFullname(request.getParameter("fullname"));
		salary.setMonth(request.getParameter("month"));
		salary.setDays(Integer.parseInt(request.getParameter("days")));
		salary.setBasicSal(Float.parseFloat(request.getParameter("basicsal")));
		salary.setOvertime(Float.parseFloat(request.getParameter("ot")));
		salary.setLeave(Float.parseFloat(request.getParameter("leave")));
		salary.setTotSalary(Float.parseFloat(request.getParameter("netsal")));
		//salary.setStatus(request.getParameter("paid"));
		
		ipayroll.insertPayroll(salary);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Payroll.jsp");
		dispatcher.forward(request, response);
	}

}
