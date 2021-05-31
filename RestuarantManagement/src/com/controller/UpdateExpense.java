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
 * Servlet implementation class UpdateExpense
 */
@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpense() {
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
		
		Expense ex = new Expense();
		IExpense iexpense = new ExpenseImpl();
		
		ex.setExpenseId(Integer.parseInt(request.getParameter("expenseId")));
		ex.setCategory(request.getParameter("category"));
		ex.setDate(request.getParameter("date"));
		ex.setAmount(Float.parseFloat(request.getParameter("amount")));	
			
		iexpense.updateExpense(ex);		
		request.setAttribute("value", 1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Expenses.jsp");		
		dispatcher.forward(request, response);
	}

}
