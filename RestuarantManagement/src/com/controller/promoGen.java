package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darwinsys.spdf.MoveTo;
import com.darwinsys.spdf.PDF;
import com.darwinsys.spdf.Page;
import com.darwinsys.spdf.Text;

import com.model.*;
import com.service.*;

/**
 * Servlet implementation class promoGen
 */
@WebServlet("/promoGen")
public class promoGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public promoGen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();  
		response.setContentType("application/pdf");  
		  
		response.setHeader("Content-disposition","inline; filename='javatpoint.pdf'");  
		
		PromoService list = new PromoService();
		ArrayList<PromoReport> arrayList = list.getReport(request.getSession(false).getAttribute("promoYear").toString(),request.getSession(false).getAttribute("promoMonth").toString());
		
		PDF p = new PDF(out);  
		Page p1 = new Page(p);  
		p1.add(new MoveTo(p, 100, 700));  
		p1.add(new Text(p, "Promotion Report")); 
		p1.add(new Text(p, "")); 
		for (PromoReport promos : arrayList) {
			p1.add(new Text(p, "Promotion Code: "+promos.getCode()+" , Unique Name: "+promos.getUname()+", Quantity: "+promos.getCount()));
		} 
		          
		p.add(p1); 
		  
		p.writePDF();  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
