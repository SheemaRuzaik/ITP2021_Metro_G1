package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.POS;
import com.service.POSImpl;

/**
 * Servlet implementation class AddpPOS
 */
@WebServlet("/AddpPOS")
public class AddpPOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddpPOS() {
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
		POSImpl IPOS = new POSImpl();

		psp.setFoodDesc(request.getParameter("fooddesc"));
		psp.setQty(Integer.parseInt(request.getParameter("qty")));
		psp.setPrice(Float.parseFloat(request.getParameter("price")));	
		//psp.setTotal(Float.parseFloat(request.getParameter("total")));	
	
				
		IPOS.addPOSProd(psp);
		request.setAttribute("value", 1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddPOS.jsp");		
		dispatcher.forward(request, response);
	
	}

}
