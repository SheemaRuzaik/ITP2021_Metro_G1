package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

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
 * Servlet implementation class GetMonthlySalary
 */
@WebServlet("/GetMonthlySalary")
public class GetMonthlySalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMonthlySalary() {
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
		//PrintWriter w = response.getWriter();
		
		String month = (request.getParameter("month"));
		
		salary.setMonth(month);
		
		if(ipayroll.checkTransaction(month) == false) {
			
			request.setAttribute("value", "no record");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/SaveFinance.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			float amount = ipayroll.totalAmount(request.getParameter("month"));
			
			salary.setTotSalary(amount);
			
			
			//w.print(amount);
			
			request.setAttribute("salary", salary);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SaveFinance.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

}
