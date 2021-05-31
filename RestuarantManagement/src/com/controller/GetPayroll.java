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
 * Servlet implementation class GetPayroll
 */
@WebServlet("/GetPayroll")
public class GetPayroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPayroll() {
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
		
		int salaryid = Integer.parseInt(request.getParameter("salaryid"));
		IPayroll ipayroll = new PayrollImpl();
		
		Salary salary = new Salary();
		salary = ipayroll.getSalary(salaryid);
		
		request.setAttribute("Salary", salary);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewPayroll.jsp");
		dispatcher.forward(request, response);
	}

}
