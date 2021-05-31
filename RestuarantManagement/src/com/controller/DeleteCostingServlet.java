package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

/**
 * Servlet implementation class DeleteCostingServlet
 */
@WebServlet("/DeleteCostingServlet")
public class DeleteCostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DeleteCostingServlet() {
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

		String food_description = request.getParameter("descp");
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();

		iinventory_asset.DeleteCosting(food_description);

		request.setAttribute("value", 1);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);
	}
}
