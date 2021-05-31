package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.AssetOrder;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

/**
 * Servlet implementation class RetrieveAssetOrderServlet
 */
@WebServlet("/RetrieveAssetOrderServlet")
public class RetrieveAssetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RetrieveAssetOrderServlet() {
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

		int supp_orderID = Integer.parseInt(request.getParameter("orderID"));
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();
		AssetOrder order = new AssetOrder();

		order = iinventory_asset.getOrder(supp_orderID);

		request.setAttribute("order", order);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewAssetOrder.jsp");
		dispatcher.forward(request, response);
	}

}
