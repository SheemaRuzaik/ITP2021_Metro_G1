package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.PayrollImpl;
import com.service.IPayroll;

/**
 * Servlet implementation class DeleteLeaveRequest
 */
@WebServlet("/DeleteLeaveRequest")
public class DeleteLeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLeaveRequest() {
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
		
		int leave_id = Integer.parseInt(request.getParameter("leave"));
		IPayroll ipayroll = new PayrollImpl();
		
		ipayroll.DeleteLeaveRequest(leave_id);
		
		request.setAttribute("value", 1);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LeaveRequestList.jsp");
		dispatcher.forward(request, response);
	}

}
