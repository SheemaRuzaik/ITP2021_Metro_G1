package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Notification;
import com.service.IPayroll;
import com.service.PayrollImpl;

/**
 * Servlet implementation class SendNotification
 */
@WebServlet("/SendNotification")
public class SendNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendNotification() {
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
		
		Notification notification = new Notification();
		IPayroll ipayroll = new PayrollImpl();
		
		//PrintWriter p = response.getWriter();
		
		String month = (request.getParameter("salary_month"));
		
		notification.setMonth(month);
		notification.setAmount(Float.parseFloat(request.getParameter("amount")));
		//notification.setDescription(request.getParameter("desc"));
		
		if(ipayroll.checkFinance(month) == true) {
			
			request.setAttribute("value", "already");
			
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/SaveFinance.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			ipayroll.sendNotification(notification);
			
			request.setAttribute("value", 1);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SaveFinance.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}

}
