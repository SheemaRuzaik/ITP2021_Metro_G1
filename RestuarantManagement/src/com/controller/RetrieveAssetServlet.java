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
 * Servlet implementation class RetrieveAssetServlet
 */
@WebServlet("/RetrieveAssetServlet")
public class RetrieveAssetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RetrieveAssetServlet() {
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

		int assetID = Integer.parseInt(request.getParameter("assetID"));
		IInventory_Asset iinventory_asset = new Inventory_AssetImpl();
		Asset asset = new Asset();

		asset = iinventory_asset.getAsset(assetID);

		request.setAttribute("asset", asset);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewAssets.jsp");
		dispatcher.forward(request, response);
	}

}
