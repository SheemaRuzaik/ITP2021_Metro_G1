package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Costing;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

/**
 * Servlet implementation class UpdateCostingServlet
 */
@WebServlet("/UpdateCostingServlet")
public class UpdateCostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UpdateCostingServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		Costing cost = new Costing();
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();

		cost.setProduct_ID(request.getParameter("prodid"));
		cost.setProd_type(request.getParameter("type"));
		cost.setFood_description(request.getParameter("descp"));
		
		float costprice= (Float.parseFloat(request.getParameter("costprice")));
		
		cost.setCost_price(costprice);
		
		//cost.calcProfit(costprice);
		float profit = cost.calcProfit(costprice);
		cost.setProfit(profit);
		
		
		cost.setProd_price(Float.parseFloat(request.getParameter("prodprice")));

		iinventory_asset.updateCosting(cost);

		request.setAttribute("value", 1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);

	}

}
