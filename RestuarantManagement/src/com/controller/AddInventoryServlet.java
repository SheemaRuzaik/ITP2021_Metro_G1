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
 * Servlet implementation class AddInventoryServlet
 */
@WebServlet("/AddInventoryServlet")
public class AddInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddInventoryServlet() {
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

		Inventory inv = new Inventory();
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();

		inv.setSupplierID_inv(request.getParameter("supplierid"));
		inv.setInventory_desc(request.getParameter("descp_inv"));
		//inv.setCategory_inv(request.getParameter(""));
		inv.setMaxStock_inv(Integer.parseInt(request.getParameter("maxstock_inv")));
		inv.setOrderQty_inv(Integer.parseInt(request.getParameter("orderqty")));
		inv.setUnitPrice_inv(Float.parseFloat(request.getParameter("unitprice")));
		//inv.setTotalPrice(Float.parseFloat(request.getParameter("")));
		//inv.setAvailableStatus(request.getParameter(""));
		inv.setFrequency(request.getParameter("orderfrequency"));
		inv.setRemarks_inv(request.getParameter("remarks"));

		iinventory_asset.addInventory(inv);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);

	}

}
