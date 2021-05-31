package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Asset;
import com.service.IInventory_Asset;
import com.service.Inventory_AssetImpl;

/**
 * Servlet implementation class UpdateAssetServlet
 */
@WebServlet("/UpdateAssetServlet")
public class UpdateAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UpdateAssetServlet() {
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

		Asset asset = new Asset();
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();
		
		asset.setAssetID(Integer.parseInt(request.getParameter("assetID")));
		asset.setSupplierID_asst(request.getParameter("supplierid"));
		asset.setAsset_desc(request.getParameter("descp"));
		//asset.setCategory_asst(request.getParameter(""));
		asset.setMakeType(request.getParameter("maketype"));
		asset.setModel(request.getParameter("model"));
		asset.setMaxStock(Integer.parseInt(request.getParameter("maxstock")));
		asset.setUnitAssetPrice(Float.parseFloat(request.getParameter("unitprice")));
		asset.setRemarks(request.getParameter("remarks"));

		iinventory_asset.updateAsset(asset);

		request.setAttribute("value", 1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);

	}

}
