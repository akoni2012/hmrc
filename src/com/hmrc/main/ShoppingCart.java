package com.hmrc.main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class ShoppingCart {
	
	private final double APPLE_PRICE=60.0;
	private final double ORANGE_PRICE=25.0;

	public String checkout(List<String> fruits) {
		// TODO Auto-generated method stub
		if(fruits.size()==0){
			return null;
		}
		double cost=0.0;
		for(int i=0; i<fruits.size(); i++){
			if(((String)fruits.get(i)).equalsIgnoreCase("Apple"))
				cost+=APPLE_PRICE;
			else if(((String)fruits.get(i)).equalsIgnoreCase("Orange"))
				cost+=ORANGE_PRICE;
			else
				return "incorrect Entry. Try again: 'Apples or Oranges' ";
		}
		NumberFormat formatter = new DecimalFormat("#0.00");
		return "£" + String.valueOf(formatter.format(cost/100.0));
	}

}
