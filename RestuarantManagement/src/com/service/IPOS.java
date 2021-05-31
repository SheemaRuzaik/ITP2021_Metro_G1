package com.service;

import java.util.ArrayList;


import com.model.POS;

public interface IPOS {
	
	//pos 
	public void addPOS(POS ps);
	
	public ArrayList<POS> POSList();	
	
	public POS getPOS(int posPayId);
		
	public void updatePOS(POS ps);
	
	public void deletePOS(int posPayId);	
	
	
	//pos products
	public void addPOSProd(POS psp);
	
	public ArrayList<POS> POSpList();
	
	public POS getpPOS(String foodDesc);
	
	public void deletepPOS(int Id);	


}

