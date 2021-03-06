package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.LoginImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

		LoginImpl loginImpl = new LoginImpl();
		
		String un = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		if(loginImpl.login(un, pwd)) {
			if(un.equalsIgnoreCase("adminPayroll")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/User&PayrollDashboard.jsp");
				dispatcher.forward(request, response);
				
			}else if(un.equalsIgnoreCase("adminInventory")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Inventory_dashboard.jsp");
				dispatcher.forward(request, response);
				
			}else if(un.equalsIgnoreCase("adminTransaction")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/POS_DashBoard.jsp");
				dispatcher.forward(request, response);
				
			/*}else if(un.equalsIgnoreCase("adminSupplier")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/User&PayrollDashboard.jsp");
				dispatcher.forward(request, response);
				
			}else if(un.equalsIgnoreCase("adminCustomer")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/User&PayrollDashboard.jsp");
				dispatcher.forward(request, response);*/
				
			}else if(un.equalsIgnoreCase("adminPromotions")) {
				HttpSession session = request.getSession();
				session.setAttribute("username", un);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/promotion.jsp");
				dispatcher.forward(request, response);
			}
		}
		else if(loginImpl.login(un, pwd)==false||request.getSession()==null) {
		
		
		request.setAttribute("un", "fail");
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
		
	}
	}

}
