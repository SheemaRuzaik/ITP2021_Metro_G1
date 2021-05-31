package com.model;

public class POS {
	
	private int posPayId;
	private String foodDesc;
	private int qty;
	private float price;
	private float total;
	private String category;
	private String date;
	private String method;
	private String cardType;
	private String cardNo;
	private String cardHoldName;
	//private float givenAmount;
	private float totAmount;
	//private float balAmount;
	
	public int getPosPayId() {
		return posPayId;
	}
	public void setPosPayId(int posPayId) {
		this.posPayId = posPayId;
	}
	public String getFoodDesc() {
		return foodDesc;
	}
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotal() {	    
	    return total;
	}
	public void setTotal(float total) {
		this.total = total;
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
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardHoldName() {
		return cardHoldName;
	}
	public void setCardHoldName(String cardHoldName) {
		this.cardHoldName = cardHoldName;
	}
	/*public float getGivenAmount() {
		return givenAmount;
	}
	public void setGivenAmount(float givenAmount) {
		this.givenAmount = givenAmount;
	}*/
	public float getTotAmount() {
		return totAmount;
	}
	public void setTotAmount(float totAmount) {
		this.totAmount = totAmount;
	}
	/*public float getBalAmount() {
		return balAmount;
	}
	public void setBalAmount(float balAmount) {
		this.balAmount = balAmount;
	}*/
	
	public float calTotal(int qty, float price) {
		return qty * price;
	}
	
	public float calTotAmount(float total) {
		return totAmount =+ total;
	}
	

}
