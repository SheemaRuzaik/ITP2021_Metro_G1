package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.POS;
import com.service.IPOS;
import com.service.POSImpl;

/**
 * Servlet implementation class CalculatePrice
 */
@WebServlet("/CalculatePrice")
public class CalculatePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatePrice() {
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
		
		POS psp = new POS();
		
		//PrintWriter p = response.getWriter();
		
		IPOS ipos = new POSImpl();
						
		int qty = Integer.parseInt(request.getParameter("qty"));
		float price = Float.parseFloat(request.getParameter("price"));
		
		
		float calTotal = psp.calTotal(qty, price);
		
		psp.setFoodDesc(request.getParameter("fooddesc"));
		
		psp.setTotal(calTotal);
		psp.setQty(qty);
		psp.setPrice(price);
		
		ipos.addPOSProd(psp);
		
		
		request.setAttribute("psp", psp);
		//p.print(calTotal);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddPOS.jsp");
		dispatcher.forward(request, response);
	}

}
