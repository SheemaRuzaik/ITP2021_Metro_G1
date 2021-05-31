package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Expense;
import com.util.DBConnection;

public class ExpenseImpl implements IExpense {
	
	private static Connection connection;
	//private static CallableStatement ct;
	private static PreparedStatement pt;
	
	@Override
	public void addExpense(Expense ex) {
		
		try {
			
			connection = DBConnection.initializedb();
			pt=connection.prepareStatement("insert into expense(Category,eDate,Amount) values(?,?,?)");
							
			pt.setString(1, ex.getCategory());
			pt.setString(2, ex.getDate());
			pt.setFloat(3, ex.getAmount());

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
	public ArrayList<Expense> ExpenseList() {
		
		ArrayList<Expense> expense = new ArrayList<Expense>();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from expense");
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				
				Expense ex = new Expense();
				
				ex.setExpenseId(rs.getInt(1));
				ex.setCategory(rs.getString(2));
				ex.setDate(rs.getString(3));
				ex.setAmount(rs.getFloat(4));
				
				
				expense.add(ex);
			}


			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return expense;
	}

	@Override
	public Expense getExpense(int expenseId) {
		
		Expense ex = new Expense();
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("select * from expense where Expense_ID=?");
			pt.setInt(1,expenseId);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {			
								
				ex.setExpenseId(rs.getInt(1));
				ex.setCategory(rs.getString(2));
				ex.setDate(rs.getString(3));
				ex.setAmount(rs.getFloat(4));
				
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		
		return ex;
	}

	@Override
	public void updateExpense(Expense ex) {
		
		try {
			connection = DBConnection.initializedb();
			pt = connection.prepareStatement("update expense set Category=?,eDate=?,Amount=? where Expense_ID=?");
			
			pt.setString(1, ex.getCategory());
			pt.setString(2, ex.getDate());
			pt.setFloat(3, ex.getAmount());
			pt.setInt(4, ex.getExpenseId());
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
	public void deleteExpense(int expenseId) {
		
		try {
			connection = DBConnection.initializedb();
						
			pt = connection.prepareStatement("delete from expense where Expense_ID=?");
			pt.setInt(1,expenseId);
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
