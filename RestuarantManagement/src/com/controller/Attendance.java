package com.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Salary;
import com.service.PayrollImpl;
import com.service.IPayroll;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/Attendance")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
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
		
		Salary salary = new Salary();
		IPayroll ipayroll = new PayrollImpl();
		//PrintWriter w = response.getWriter();
		
		String empid = request.getParameter("empid");
		String month = request.getParameter("month");
		int days = Integer.parseInt(request.getParameter("days"));
		salary.setEmpid(empid);
		salary.setMonth(month);
		salary.setDays(days);
		
		if(ipayroll.checkEmp(salary.getEmpid()) == false) {
			request.setAttribute("value", "Id no");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EnterAttendance.jsp");
			dispatcher.forward(request, response);
			
		}else if(ipayroll.checkAttendance(salary.getEmpid(), salary.getMonth()) == true) {
			
			request.setAttribute("value", "already");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EnterAttendance.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			ipayroll.enterAttendance(salary);
			
			//w.print(month);
			
			request.setAttribute("value", 1);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EnterAttendance.jsp");
			dispatcher.forward(request, response);
		}
	}

}
