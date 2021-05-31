package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;
import com.service.*;

/**
 * Servlet implementation class promoGet
 */
@WebServlet("/promoGet")
public class promoGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public promoGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		PromoService list = new PromoService();
		ArrayList<Promotion> arrayList = list.getPromo(Integer.parseInt(request.getParameter("id")));
		
		for (Promotion promotion : arrayList) {

			out.print("***"+promotion.getId()+"***"+promotion.getCode()+"***"+promotion.getU_name()
			+"***"+promotion.getSdate()+"***"+promotion.getEdate()+"***"+promotion.getType()+"***"+promotion.getR_price()
			+"***"+promotion.getD_price()+"***"+promotion.getDescription());
			
		}
		
        out.flush();
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
