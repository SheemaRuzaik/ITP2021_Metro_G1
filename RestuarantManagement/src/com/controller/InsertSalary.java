package com.controller;

import java.io.IOException;

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
 * Servlet implementation class InsertSalary
 */
@WebServlet("/InsertSalary")
public class InsertSalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertSalary() {
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
		
		String empid = request.getParameter("empid");
		String month = request.getParameter("month");
		int day = ipayroll.getAttendance(empid, month);
		
		salary.setEmpid(empid);
		salary.setMonth(month);
		
		if(ipayroll.checkSalary(empid, month) == true) {
			
			request.setAttribute("value", "insert");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
			dispatcher.forward(request, response);
			
		}else {
			
			salary.setDays(Integer.parseInt(request.getParameter("attend_days")));
			
			salary.setBasicSal(Float.parseFloat(request.getParameter("basicsalary")));
			
			if(day > 21) {
				salary.setOvertime(Float.parseFloat(request.getParameter("ot")));
			}
			else if(day < 19) {
				salary.setLeave(Float.parseFloat(request.getParameter("leave")));
			}
			else {
				//salary.setOvertime(0);
				//salary.setLeave(0);
			}
			salary.setTotSalary(Float.parseFloat(request.getParameter("netsalary")));
			
			ipayroll.insertSalary(salary);
			
			request.setAttribute("value", 1);
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/CalculateSalary.jsp");
			dispatcher.forward(request, response);
		}
	}
		
	

}
