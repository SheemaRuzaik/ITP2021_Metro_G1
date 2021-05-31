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
 * Servlet implementation class UpdateLeaveRequest
 */
@WebServlet("/UpdateLeaveRequest")
public class UpdateLeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLeaveRequest() {
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
		
		Leave leave = new Leave();
		IPayroll ipayroll = new PayrollImpl();
		
		
		leave.setLeaveId(Integer.parseInt(request.getParameter("leaveid")));
		leave.setEmpid(request.getParameter("empid"));
		leave.setFromdate(request.getParameter("fromdate"));
		leave.setTodate(request.getParameter("todate"));
		leave.setNoOfdays(Integer.parseInt(request.getParameter("days")));
		leave.setReason(request.getParameter("reason"));
		leave.setStatus(request.getParameter("status"));
		
		ipayroll.UpdateLeaveRequest(leave);
		
		request.setAttribute("value", 1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LeaveRequestList.jsp");
		dispatcher.forward(request, response);
		
	}

}
