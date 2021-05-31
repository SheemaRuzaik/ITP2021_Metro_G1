package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.Inventory;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

/**
 * Servlet implementation class RetrieveInventoryServlet
 */
@WebServlet("/RetrieveInventoryServlet")
public class RetrieveInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RetrieveInventoryServlet() {
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

		int inventoryID = Integer.parseInt(request.getParameter("invID"));
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();
		Inventory inv = new Inventory();

		inv = iinventory_asset.getInventory(inventoryID);

		request.setAttribute("inv", inv);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewInventory.jsp");
		dispatcher.forward(request, response);

	}

}
