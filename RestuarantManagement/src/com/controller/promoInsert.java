package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.*;
import com.service.*;

/**
 * Servlet implementation class promoInsert
 */
@WebServlet("/promoInsert")
public class promoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public promoInsert() {
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

		Promotion promo = new Promotion();
		
		promo.setCode(request.getParameter("code"));
		promo.setU_name(request.getParameter("uname"));
		promo.setSdate(request.getParameter("sdate"));
		promo.setEdate(request.getParameter("edate"));
		promo.setType(request.getParameter("type"));
		promo.setR_price(Double.parseDouble(request.getParameter("rprice")));
		promo.setD_price(Double.parseDouble(request.getParameter("dprice")));
		promo.setDescription(request.getParameter("description"));
		
		PromoService promoService = new PromoService();
		promoService.addPromo(promo);
		
		if(promoService.getSuccess()==1) {
			HttpSession session = request.getSession();
			session.setAttribute("errors_success",1);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/promoList.jsp");
			dispatcher.forward(request, response);
		}else if(promoService.getSuccess()==0) {
			HttpSession session = request.getSession();
			session.setAttribute("errors_success",2);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/promoAdd.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
