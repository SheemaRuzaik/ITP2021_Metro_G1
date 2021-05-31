package com.service;

import java.util.ArrayList;

import com.model.Expense;

public interface IExpense {
	
    public void addExpense(Expense ex);
	
	public ArrayList<Expense> ExpenseList();
	
	public Expense getExpense(int expenseId);
	
	public void updateExpense(Expense ex);
	
	public void deleteExpense(int expenseId);
	
	

}
