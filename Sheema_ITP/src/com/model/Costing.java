package com.model;

public class Costing {
	
	

	private String Product_ID;
	private String prod_type;
	private String food_description;
	private float cost_price;
	private float profit;
	private float prod_price;
	

	public String getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(String product_ID) {
		Product_ID = product_ID;
	}
	public String getProd_type() {
		return prod_type;
	}
	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}
	public String getFood_description() {
		return food_description;
	}
	public void setFood_description(String food_description) {
		this.food_description = food_description;
	}
	public Float getCost_price() {
		return cost_price;
	}
	public void setCost_price(Float cost_price) {
		this.cost_price = cost_price;
	}
	public Float getProfit() {
		return profit;
	}
	public void setProfit(Float profit) {
		this.profit = profit;
	}
	public Float getProd_price() {
		return (getProfit()+getCost_price());
	}
	public void setProd_price(Float prod_price) {
		this.prod_price = prod_price;
	}
	
	public float calcProfit(float cost_price) {
		
		return (float) (0.5*cost_price);
		
		
	}

}
