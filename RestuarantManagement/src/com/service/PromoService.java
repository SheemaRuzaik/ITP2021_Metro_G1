package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.*;
import com.util.DBConnection;

public class PromoService {

	private int success;

	public void addPromo(Promotion promotion) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnection.initializedb();
			
			//insert value
			preparedStatement = connection.prepareStatement("INSERT INTO promotion (code, u_name, sdate, edate, type, r_price, d_price, description) VALUES (?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, promotion.getCode());
			preparedStatement.setString(2, promotion.getU_name());
			preparedStatement.setString(3, promotion.getSdate());
			preparedStatement.setString(4, promotion.getEdate());
			preparedStatement.setString(5, promotion.getType());
			preparedStatement.setDouble(6, promotion.getR_price());
			preparedStatement.setDouble(7, promotion.getD_price());
			preparedStatement.setString(8, promotion.getDescription());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			setSuccess(1);
				
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
			setSuccess(0);
		}

	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
	public ArrayList<Promotion> getAllPromotion() {
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnection.initializedb();
			preparedStatement = connection.prepareStatement("SELECT * FROM promotion");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Promotion promo = new Promotion();
				
				promo.setId(resultSet.getInt(1));
				promo.setCode(resultSet.getString(2));
				promo.setU_name(resultSet.getString(3));
				promo.setSdate(resultSet.getString(4));
				promo.setEdate(resultSet.getString(5));
				promo.setType(resultSet.getString(6));
				promo.setR_price(resultSet.getDouble(7));
				promo.setD_price(resultSet.getDouble(8));
				promo.setDescription(resultSet.getString(9));
				
				promotionList.add(promo);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return promotionList;
	}

	public ArrayList<Promotion> getPromo(int id) {

		ArrayList<Promotion> promoList = new ArrayList<Promotion>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnection.initializedb();
			preparedStatement = connection.prepareStatement("SELECT * FROM promotion WHERE id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Promotion promo = new Promotion();
				
				promo.setId(resultSet.getInt(1));
				promo.setCode(resultSet.getString(2));
				promo.setU_name(resultSet.getString(3));
				promo.setSdate(resultSet.getString(4));
				promo.setEdate(resultSet.getString(5));
				promo.setType(resultSet.getString(6));
				promo.setR_price(resultSet.getDouble(7));
				promo.setD_price(resultSet.getDouble(8));
				promo.setDescription(resultSet.getString(9));
				
				promoList.add(promo);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return promoList;
	}
	
	public ArrayList<PromoReport> getReport(String year,String month){

		ArrayList<PromoReport> promoList = new ArrayList<PromoReport>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnection.initializedb();
			preparedStatement = connection.prepareStatement("SELECT p.code,p.u_name,sum(o.quantity) FROM orders o,promotion p WHERE o.promocode=p.code and o.year=? and o.month=? GROUP by p.code");
			preparedStatement.setInt(1, Integer.parseInt(year));
			preparedStatement.setInt(2, Integer.parseInt(month));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				PromoReport promo = new PromoReport();
				
				promo.setCode(resultSet.getString(1));
				promo.setUname(resultSet.getString(2));
				promo.setCount(resultSet.getInt(3));
				
				promoList.add(promo);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return promoList;
		
	}

	public void updatePromo(Promotion promotion) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnection.initializedb();
				
			preparedStatement = connection.prepareStatement("UPDATE promotion SET code=?, u_name=?, sdate=?, edate=?, type=?, r_price=?, d_price=?, description=? where id=?");
			preparedStatement.setString(1, promotion.getCode());
			preparedStatement.setString(2, promotion.getU_name());
			preparedStatement.setString(3, promotion.getSdate());
			preparedStatement.setString(4, promotion.getEdate());
			preparedStatement.setString(5, promotion.getType());
			preparedStatement.setDouble(6, promotion.getR_price());
			preparedStatement.setDouble(7, promotion.getD_price());
			preparedStatement.setString(8, promotion.getDescription());
			preparedStatement.setInt(9, promotion.getId());
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			setSuccess(1);
				
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
			System.out.println(e);
		}
		
	}

	public void deletePromo(int id) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnection.initializedb();
			
			//delete Promotion
			preparedStatement = connection.prepareStatement("DELETE FROM promotion WHERE id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			
			setSuccess(1);
		
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
		}
		
	}
}
