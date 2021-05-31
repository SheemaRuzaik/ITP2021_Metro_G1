package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Expense;
import com.service.ExpenseImpl;
import com.service.IExpense;

/**
 * Servlet implementation class GetExpense
 */
@WebServlet("/GetExpense")
public class GetExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetExpense() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		int expenseId = Integer.parseInt(request.getParameter("expenseId"));
		
		IExpense iexpense = new ExpenseImpl();
		
		Expense expense = new Expense();
			
		expense = iexpense.getExpense(expenseId);			
			
		request.setAttribute("expense", expense);
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetExpense.jsp");			
		dispatcher.forward(request, response);		
		
	}

}
