package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Leave;
import com.service.PayrollImpl;
import com.service.IPayroll;

/**
 * Servlet implementation class GetLeaveRequest
 */
@WebServlet("/GetLeaveRequest")
public class GetLeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLeaveRequest() {
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
		
		int leaveid = Integer.parseInt(request.getParameter("leave"));
		IPayroll ipayroll = new PayrollImpl();
		Leave leave = new Leave();
		
		leave = ipayroll.getLeaveRequest(leaveid);
		
		request.setAttribute("leave", leave);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetLeaveRequest.jsp");
		dispatcher.forward(request, response);
	}

}
