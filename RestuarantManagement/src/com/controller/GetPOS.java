package com.controller;

import java.io.IOException;

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
 * Servlet implementation class GetPOS
 */
@WebServlet("/GetPOS")
public class GetPOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPOS() {
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
		
		int posPayId = Integer.parseInt(request.getParameter("posPayId"));
		
		IPOS ipos = new POSImpl();
		
		POS pos = new POS();
			
		pos = ipos.getPOS(posPayId);			
			
		request.setAttribute("pos", pos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetPOS.jsp");		
		dispatcher.forward(request, response);
	}

}
