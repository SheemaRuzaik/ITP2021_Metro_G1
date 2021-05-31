package com.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class GenerateReport
 */
@WebServlet("/GenerateReport")
public class GenerateReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateReport() {
		super();
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

		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();

		String supp_ID = (request.getParameter("supp_ID"));

		AssetOrder order = new AssetOrder();

		order.setDateOrdered(supp_ID);

		ArrayList<AssetOrder> assetorderarray = new ArrayList<>();

		assetorderarray = iinventory_asset.generateReport(supp_ID);

		order.setAssetorderarray(assetorderarray);

		request.setAttribute("order", order);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RetrieveReport.jsp");
		dispatcher.forward(request, response);

	}

}
