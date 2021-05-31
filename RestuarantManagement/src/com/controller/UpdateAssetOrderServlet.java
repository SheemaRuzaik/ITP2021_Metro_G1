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
 * Servlet implementation class UpdateAssetOrderServlet
 */
@WebServlet("/UpdateAssetOrderServlet")
public class UpdateAssetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UpdateAssetOrderServlet() {
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

		AssetOrder order = new AssetOrder();
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();
		
		
		order.setSupp_orderID(Integer.parseInt(request.getParameter("supp_orderID")));
		order.setSupplierID(request.getParameter("supplierid"));
		int AssetID=Integer.parseInt(request.getParameter("assetID"));
	
		
		float unitAssetPrice=iinventory_asset.getUnitPrice(AssetID);
		
		int Qty=Integer.parseInt(request.getParameter("orderqty"));
		
		float TotAssetPrice=order.calculateTotPrice(Qty, unitAssetPrice);
		
		order.setAssetID(AssetID);
		order.setOrderAssetQty(Qty);
		order.setTotalAssetPrice(TotAssetPrice);
		order.setDateOrdered(request.getParameter("dateorderd"));

		iinventory_asset.updateOrder(order);

		request.setAttribute("value", 1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);

	}

}
