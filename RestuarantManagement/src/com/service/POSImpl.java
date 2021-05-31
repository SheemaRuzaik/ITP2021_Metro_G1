package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.POS;
import com.util.DBConnection;

public class POSImpl implements IPOS {
	
	private static Connection connection;
	//private static CallableStatement ct;
	private static PreparedStatement pt;
	
	@Override
	public void addPOS(POS ps) {
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("insert into pos_payment(Category,pDate,Method,Card_Type,Card_No,Card_Hold_Name,Tot_Amount) values(?,?,?,?,?,?,?)");
					
			pt.setString(1, ps.getCategory());
			pt.setString(2, ps.getDate());
			pt.setString(3, ps.getMethod());
			pt.setString(4, ps.getCardType());
			pt.setString(5, ps.getCardNo());
			pt.setString(6, ps.getCardHoldName());
			pt.setFloat(7, ps.getTotAmount());
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void addPOSProd(POS psp) {
		
		try {
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("insert into pos_prod_purchased(Food_Desc,Quantity,Price,Total) values(?,?,?,?)");
			
			pt.setString(1, psp.getFoodDesc());
			pt.setInt(2, psp.getQty());
			pt.setFloat(3, psp.getPrice());
			pt.setFloat(4, psp.getTotal());
			pt.execute();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			
	}
	@Override
	public ArrayList<POS> POSList() {
		
		ArrayList<POS> pos = new ArrayList<POS>();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from pos_payment");
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				
				POS ps = new POS();
				
				ps.setPosPayId(rs.getInt(1));
				ps.setCategory(rs.getString(2));
				ps.setDate(rs.getString(3));
				ps.setMethod(rs.getString(4));
				ps.setCardType(rs.getString(5));
				ps.setCardNo(rs.getString(6));
				ps.setCardHoldName(rs.getString(7));
				ps.setTotAmount(rs.getFloat(8));
				
			    pos.add(ps);
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pos;
	}
	
	@Override
	public ArrayList<POS> POSpList() {
		
		ArrayList<POS> pos = new ArrayList<POS>();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from pos_prod_purchased");
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				
				POS psp = new POS();
				
				psp.setPosPayId(rs.getInt(1));
				psp.setFoodDesc(rs.getString(2));
				psp.setQty(rs.getInt(3));
				psp.setPrice(rs.getFloat(4));
				psp.setTotal(rs.getFloat(5));
										
			    pos.add(psp);
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pos;
	}
	
	
	
	@Override
	public POS getPOS(int posPayId) {		
		
		POS ps = new POS();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from pos_payment where PosPay_ID=?");
			pt.setInt(1,posPayId);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {		
				
				ps.setPosPayId(rs.getInt(1));
				ps.setCategory(rs.getString(2));
				ps.setDate(rs.getString(3));
				ps.setMethod(rs.getString(4));
				ps.setCardType(rs.getString(5));
				ps.setCardNo(rs.getString(6));
				ps.setCardHoldName(rs.getString(7));
				ps.setTotAmount(rs.getFloat(8));
					
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ps;
	}
	
	
	@Override
	public POS getpPOS(String foodDesc) {		
		
		POS psp = new POS();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from pos_prod_purchased where Food_Desc=?");
			pt.setString(1,foodDesc);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {		
				
				psp.setFoodDesc(rs.getString(1));
				psp.setQty(rs.getInt(2));
				psp.setPrice(rs.getFloat(3));
				psp.setTotal(rs.getFloat(4));					
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return psp;
	}
		
	@Override
	public void updatePOS(POS ps) {
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("update pos_payment set Category=?,pDate=?,Method=?,Card_Type=?,Card_No=?,Card_Hold_Name=?,Total_Amount=? where PosPay_ID=?");
		
			pt.setString(1, ps.getCategory());
			pt.setString(2, ps.getDate());
			pt.setString(3, ps.getMethod());
			pt.setString(4, ps.getCardType());
			pt.setString(5, ps.getCardNo());
			pt.setString(6, ps.getCardHoldName());
			pt.setFloat(7, ps.getTotAmount());
			pt.setInt(8, ps.getPosPayId());
			pt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}			
	
	@Override
	public void deletePOS(int posPayID) {
		
		try {
			connection = DBConnection.initializedb();
			
			pt = connection.prepareStatement("delete from pos_payment where PosPay_ID=?");
			pt.setInt(1,posPayID);
			pt.execute();
									
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	@Override
	public void deletepPOS(int Id) {
		
		try {
			connection = DBConnection.initializedb();
			
			pt = connection.prepareStatement("delete from pos_prod_purchased where Prod_ID=?");
			pt.setInt(1,Id);
			pt.execute();
			
			
									
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}
	

