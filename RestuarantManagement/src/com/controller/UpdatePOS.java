package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Expense;
import com.model.POS;
import com.service.ExpenseImpl;
import com.service.IExpense;
import com.service.IPOS;
import com.service.POSImpl;

/**
 * Servlet implementation class UpdatePOS
 */
@WebServlet("/UpdatePOS")
public class UpdatePOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePOS() {
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
		
		POS ps = new POS();
		IPOS ipos = new POSImpl();
		
		ps.setPosPayId(Integer.parseInt(request.getParameter("posPayId")));		
		ps.setCategory(request.getParameter("category"));		
		ps.setDate(request.getParameter("date"));
		ps.setMethod(request.getParameter("method"));
		ps.setCardType(request.getParameter("cardType"));
		ps.setCardNo(request.getParameter("cardNo"));
		ps.setCardHoldName(request.getParameter("cardHoldName"));		
		//ps.setGivenAmount(Float.parseFloat(request.getParameter("givamo")));
		ps.setTotAmount(Float.parseFloat(request.getParameter("totamo")));
		//ps.setBalAmount(Float.parseFloat(request.getParameter("balamo")));
		
		ipos.updatePOS(ps);
		request.setAttribute("value", 1);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Incomes.jsp");		
		dispatcher.forward(request, response);
	}

}
