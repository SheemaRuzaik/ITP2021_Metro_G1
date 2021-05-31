package com.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class MonthlySalaryTransaction
 */
@WebServlet("/MonthlySalaryTransaction")
public class MonthlySalaryTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthlySalaryTransaction() {
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
		
		IPayroll ipayroll = new PayrollImpl();
		
		String month = (request.getParameter("month"));
		
		
		Salary salary = new Salary();
		
		salary.setMonth(month);
		
		if(ipayroll.checkTransaction(month) == false) {
			
			request.setAttribute("value", "no record");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/ViewSalaryDetails.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			ArrayList<Salary> summary = new ArrayList<>();
			
			summary = ipayroll.MonthlySalaryTransaction(month);
			
			salary.setSummary(summary);
			
			request.setAttribute("salary", salary);
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/MonthlySalaryTransactionSummary.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
