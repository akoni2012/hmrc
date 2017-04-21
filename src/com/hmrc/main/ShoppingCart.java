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
		double appleCost=0.0;
		double orangeCost=0.0;
		int appleCount=0;
		int orangeCount=0;
		for(int i=0; i<fruits.size(); i++){
			if(((String)fruits.get(i)).equalsIgnoreCase("Apple"))
				appleCount++;
			else if(((String)fruits.get(i)).equalsIgnoreCase("Orange"))
				orangeCount++;
			else
				return "incorrect Entry. Try again: 'Apples or Oranges' ";
		}
		if (appleCount%2 ==0)
			appleCost=APPLE_PRICE*appleCount/2;
		else
			appleCost=APPLE_PRICE*(appleCount/2 + (appleCount%2));
		
		if (orangeCount%3 ==0)
			orangeCost=ORANGE_PRICE*orangeCount*2/3;
		else
			orangeCost=ORANGE_PRICE*(orangeCount/3 + (orangeCount%3));
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		return "£" + String.valueOf(formatter.format((appleCost+orangeCost)/100.0));
	}

}
