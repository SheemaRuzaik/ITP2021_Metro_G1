package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Asset;
import com.model.AssetOrder;
import com.model.Costing;
import com.model.Inventory;
import com.model.Supplier;
import com.util.DBConnection;

public class Inventory_AssetImpl implements IInventory_Asset {

	private static Connection connection;
	private static PreparedStatement pt;
	// private static CallableStatement ct;
	// private static Statement st;
	
	
	

	// ====================Costing======================================//

	// ----------------Add Costing-------------------------------------//

	@Override
	public void addCosting(Costing cost) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement(
					"insert into food_costing (Product_ID,prod_type,food_description,cost_price,profit,prod_price) values (?,?,?,?,?,?)");

			pt.setString(1, cost.getProduct_ID());
			pt.setString(2, cost.getProd_type());
			pt.setString(3, cost.getFood_description());
			pt.setFloat(4, cost.getCost_price());
			pt.setFloat(5, cost.getProfit());
			pt.setFloat(6, cost.getProd_price());

			pt.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ------------------------Retrieve Costing--------------------------//

	@Override
	public Costing getCosting(String food_description) {
		// TODO Auto-generated method stub

		Costing cost = new Costing();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from food_costing where food_description=?");
			pt.setString(1, food_description);
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				cost.setProduct_ID(result.getString(1));
				cost.setProd_type(result.getString(2));
				cost.setFood_description(result.getString(3));
				cost.setCost_price(result.getFloat(4));
				cost.setProfit(result.getFloat(5));
				cost.setProd_price(result.getFloat(6));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cost;
	}

	// ------------------------Delete Costing--------------------------//

	@Override
	public void DeleteCosting(String food_description) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();

			pt = connection.prepareStatement("delete from food_costing where food_description=?");
			pt.setString(1, food_description);
			pt.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ------------------------Update Costing--------------------------//

	@Override
	public void updateCosting(Costing cost) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement(
					"update food_costing set Product_ID=?,prod_type=?,cost_price=?,profit=?,prod_price=? where food_description=?");
			pt.setString(1, cost.getProduct_ID());
			pt.setString(2, cost.getProd_type());
			pt.setFloat(3, cost.getCost_price());
			pt.setFloat(4,cost.getProfit());
			pt.setFloat(5,cost.getProd_price());
			
			pt.setString(6, cost.getFood_description());
			

			pt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// --------------Table-List Costing---------------------------------------//

	@Override
	public ArrayList<Costing> ListCosting() {

		ArrayList<Costing> costing = new ArrayList<>();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from food_costing");
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				Costing cost = new Costing();

				cost.setProduct_ID(result.getString(1));
				cost.setProd_type(result.getString(2));
				cost.setFood_description(result.getString(3));
				cost.setCost_price(result.getFloat(4));
				cost.setProfit(result.getFloat(5));
				cost.setProd_price(result.getFloat(6));

				costing.add(cost);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return costing;
	}

	// ====================Assets======================================//

	// --------------------Add Asset------------------------------------//

	@Override
	public void addAsset(Asset asset) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement(
					"insert into asset(supplierID_asst,asset_desc,makeType,model,maxStock,unitAssetPrice,remarks) values(?,?,?,?,?,?,?)");
			pt.setString(1, asset.getSupplierID_asst());
			pt.setString(2, asset.getAsset_desc());
			//pt.setString(3, asset.getCategory_asst());
			pt.setString(3, asset.getMakeType());
			pt.setString(4, asset.getModel());
			pt.setInt(5, asset.getMaxStock());
			pt.setFloat(6, asset.getUnitAssetPrice());
			pt.setString(7, asset.getRemarks());

			pt.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --------------------Retrieve Asset------------------------------------//

	@Override
	public Asset getAsset(int assetID) {
		// TODO Auto-generated method stub

		Asset asset = new Asset();
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from asset where assetID=?");
			pt.setInt(1, assetID);
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				asset.setAssetID(result.getInt(1));
				asset.setSupplierID_asst(result.getString(2));
				asset.setAsset_desc(result.getString(3));
				//asset.setCategory_asst(result.getString(4));
				asset.setMakeType(result.getString(4));
				asset.setModel(result.getString(5));
				asset.setMaxStock(result.getInt(6));
				asset.setUnitAssetPrice(result.getFloat(7));
				asset.setRemarks(result.getString(8));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return asset;
	}

	// --------------------Delete Asset------------------------------------//

	@Override
	public void DeleteAsset(int assetID) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();

			pt = connection.prepareStatement("delete from asset where assetID=?");
			pt.setInt(1, assetID);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --------------------Update Asset------------------------------------//

	@Override
	public void updateAsset(Asset asset) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("update asset set supplierID_asst=?,asset_desc=?,makeType=?,model=?,maxStock=?,unitAssetPrice=?,remarks=? where assetID=?");

			pt.setString(1, asset.getSupplierID_asst());
			pt.setString(2, asset.getAsset_desc());
			//pt.setString(3, asset.getCategory_asst());
			pt.setString(3, asset.getMakeType());
			pt.setString(4, asset.getModel());
			pt.setInt(5, asset.getMaxStock());
			pt.setFloat(6, asset.getUnitAssetPrice());
			pt.setString(7, asset.getRemarks());

			pt.setInt(8, asset.getAssetID());

			pt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --------------------Table- List Asset------------------------------------//

	@Override
	public ArrayList<Asset> ListAsset() {
		// TODO Auto-generated method stub

		ArrayList<Asset> asset = new ArrayList<>();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from asset");
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				Asset assets = new Asset();

				assets.setAssetID(result.getInt(1));
				assets.setSupplierID_asst(result.getString(2));
				assets.setAsset_desc(result.getString(3));
				//assets.setCategory_asst(result.getString(4));
				assets.setMakeType(result.getString(4));
				assets.setModel(result.getString(5));
				assets.setMaxStock(result.getInt(6));
				assets.setUnitAssetPrice(result.getFloat(7));
				assets.setRemarks(result.getString(8));

				asset.add(assets);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return asset;

	}

	// ====================Inventory======================================//

	// ----------------Add Inventory-------------------------------------//

	@Override
	public void addInventory(Inventory inv) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement(
					"insert into inventory(supplierID_inv,inventory_desc,maxStock_inv,orderQty_inv,unitPrice_inv,totalPrice,availableStatus,frequency,remarks_inv) values(?,?,?,?,?,?,?,?,?)");
			pt.setString(1, inv.getSupplierID_inv());
			pt.setString(2, inv.getInventory_desc());
			//pt.setString(3, inv.getCategory_inv());
			pt.setInt(3, inv.getMaxStock_inv());
			pt.setInt(4, inv.getOrderQty_inv());
			pt.setFloat(5, inv.getUnitPrice_inv());
			pt.setFloat(6, inv.getTotalPrice());
			pt.setString(7, inv.getAvailableStatus());
			pt.setString(8, inv.getFrequency());
			pt.setString(9, inv.getRemarks_inv());

			pt.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ----------------Retrieve Inventory-------------------------------------//

	@Override
	public Inventory getInventory(int inventoryID) {
		// TODO Auto-generated method stub

		Inventory inv = new Inventory();
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from inventory where inventoryID=?");
			pt.setInt(1, inventoryID);
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				inv.setInventoryID(result.getInt(1));
				inv.setSupplierID_inv(result.getString(2));
				inv.setInventory_desc(result.getString(3));
				//inv.setCategory_inv(result.getString(4));
				inv.setMaxStock_inv(result.getInt(4));
				inv.setOrderQty_inv(result.getInt(5));
				inv.setUnitPrice_inv(result.getFloat(6));
				inv.setTotalPrice(result.getFloat(7));
				inv.setAvailableStatus(result.getString(8));
				inv.setFrequency(result.getString(9));
				inv.setRemarks_inv(result.getString(10));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inv;

	}

	// ----------------Delete Inventory-------------------------------------//

	@Override
	public void DeleteInventory(int inventoryID) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();

			pt = connection.prepareStatement("delete from Inventory where inventoryID=?");
			pt.setInt(1, inventoryID);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------Update Inventory-------------------------------------//

	@Override
	public void updateInventory(Inventory inv) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("update inventory set supplierID_inv=?,inventory_desc=?,maxStock_inv=?,orderQty_inv=?,unitPrice_inv=?,totalPrice=?,availableStatus=?,frequency=?,remarks_inv=?  where inventoryID=?");

			pt.setString(1, inv.getSupplierID_inv());
			pt.setString(2, inv.getInventory_desc());
			//pt.setString(3, inv.getCategory_inv());
			pt.setInt(3, inv.getMaxStock_inv());
			pt.setInt(4, inv.getOrderQty_inv());
			pt.setFloat(5, inv.getUnitPrice_inv());
			pt.setFloat(6, inv.getTotalPrice());
			pt.setString(7, inv.getAvailableStatus());
			pt.setString(8, inv.getFrequency());
			pt.setString(9, inv.getRemarks_inv());

			pt.setInt(10, inv.getInventoryID());

			pt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------Table -List Inventory-------------------------------------//

	@Override
	public ArrayList<Inventory> ListInventory() {
		// TODO Auto-generated method stub
		ArrayList<Inventory> inv = new ArrayList<>();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from inventory");
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				Inventory invs = new Inventory();

				invs.setInventoryID(result.getInt(1));
				invs.setSupplierID_inv(result.getString(2));
				invs.setInventory_desc(result.getString(3));
				//invs.setCategory_inv(result.getString(4));
				invs.setMaxStock_inv(result.getInt(4));
				invs.setOrderQty_inv(result.getInt(5));
				invs.setUnitPrice_inv(result.getFloat(6));
				invs.setTotalPrice(result.getFloat(7));
				invs.setAvailableStatus(result.getString(8));
				invs.setFrequency(result.getString(9));
				invs.setRemarks_inv(result.getString(10));

				inv.add(invs);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inv;
	}

	// ====================Place Asset Order======================================//

	// ----------------Add Asset Order-------------------------------------//

	@Override
	public void addOrder(AssetOrder order) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement(
					"insert into supplier_orders(supplierID,asset_ID,orderAssetQty,totalAssetPrice,dateOrdered) values(?,?,?,?,?)");
			pt.setString(1, order.getSupplierID());
			pt.setInt(2, order.getAssetID());
			pt.setInt(3, order.getOrderAssetQty());
			pt.setFloat(4, order.getTotalAssetPrice());
			pt.setString(5, order.getDateOrdered());

			pt.execute();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------Retrieve Asset Order-------------------------------------//

	@Override
	public AssetOrder getOrder(int supp_orderID) {

		AssetOrder order = new AssetOrder();
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from supplier_orders where supp_orderID=?");
			pt.setInt(1, supp_orderID);
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				order.setSupp_orderID(result.getInt(1));
				order.setSupplierID(result.getString(2));
				order.setAssetID(result.getInt(3));
				order.setOrderAssetQty(result.getInt(4));
				order.setTotalAssetPrice(result.getFloat(5));
				order.setDateOrdered(result.getString(6));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}

	// ----------------Delete Asset Order-------------------------------------//

	@Override
	public void DeleteOrder(int supp_orderID) {
		// TODO Auto-generated method stub

		try {
			connection = DBConnection.initializedb();

			pt = connection.prepareStatement("delete from supplier_orders where supp_orderID=?");
			pt.setInt(1, supp_orderID);
			pt.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------Update Asset Order-------------------------------------//

	@Override
	public void updateOrder(AssetOrder order) {
		// TODO Auto-generated method stub
		
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("update supplier_orders set supplierID=?,asset_ID=?,orderAssetQty=?,totalAssetPrice=?,dateOrdered=? where supp_orderID=?");

			pt.setString(1,order.getSupplierID());
			pt.setInt(2,order.getAssetID());
			pt.setInt(3,order.getOrderAssetQty());
			pt.setFloat(4, order.getTotalAssetPrice());
			pt.setString(5, order.getDateOrdered());
			
			pt.setInt(6,order.getSupp_orderID());
			

			pt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ----------------Table-List Asset Order-------------------------------------//

	@Override
	public ArrayList<AssetOrder> ListAssetOrder() {
		// TODO Auto-generated method stub
		ArrayList<AssetOrder> order = new ArrayList<>();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from supplier_orders");
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				AssetOrder orders = new AssetOrder();

				orders.setSupp_orderID(result.getInt(1));
				orders.setSupplierID(result.getString(2));
				orders.setAssetID(result.getInt(3));
				orders.setOrderAssetQty(result.getInt(4));
				orders.setTotalAssetPrice(result.getFloat(5));
				orders.setDateOrdered(result.getString(6));

				order.add(orders);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}
	
	//-----------get UnitPrice- Asset Order--------------//

	@Override
	public float getUnitPrice(int asset_ID) {
		
		float unitAssetPrice = 0;
		
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select * from asset where assetID=?");
			pt.setInt(1, asset_ID);
			
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				unitAssetPrice = result.getInt(7);
			}
		}catch (Exception e) {
				
			}
		return unitAssetPrice;
	}

	//-------------------generate report-------------------------//
	
	@Override
	public ArrayList<AssetOrder> generateReport(String supp_ID) {
		// TODO Auto-generated method stub
	
			ArrayList<AssetOrder> order = new ArrayList<>();
		
		try {
			connection=DBConnection.initializedb();
			pt=connection.prepareStatement("select supp_orderID,supplierID,asset_ID,orderAssetQty,totalAssetPrice,dateOrdered from supplier_orders where supplierID=?");
			pt.setString(1, supp_ID);
			ResultSet result=pt.executeQuery();
			
			while(result.next()){
				
				AssetOrder order1 = new AssetOrder();
				
				order1.setSupp_orderID(result.getInt(1));
				order1.setSupplierID(result.getString(2));
				order1.setAssetID(result.getInt(3));
				order1.setOrderAssetQty(result.getInt(4));
				order1.setTotalAssetPrice(result.getFloat(5));
				order1.setDateOrdered(result.getString(6));
				
				order.add(order1);
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
					
						e.printStackTrace();
		}
		return order;
	}

	
	//---------------to get supplier list from DB-----------------//
	
	@Override
	public ArrayList<Supplier> ListSupplier() {
		
		ArrayList<Supplier> order = new ArrayList<>();

		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from supplier");
			ResultSet result = pt.executeQuery();

			while (result.next()) {

				Supplier orders = new Supplier();

				orders.setSupplier_ID(result.getString(1));
				orders.setSupplier_name(result.getString(2));
				orders.setItem_type(result.getString(3));
				
				order.add(orders);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}
}

