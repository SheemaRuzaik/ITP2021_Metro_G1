package com.model;

public class Expense {
	
	private int expenseId;
	private String category;
	private String date;
	private Float amount;
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	
	public String getCategory() {
		return category;
	}
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public String getDate() {
		return date;
	}
    public void setDate(String date) {
    	this.date = date;
    }
    
    public Float getAmount() {
		return amount;
	}
    public void setAmount(Float amount) {
    	this.amount = amount;
    }
    
    

}
