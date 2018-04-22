package main;

import java.util.List;

public class Charge 
{
	private OrderArrayList order;
	
	public double calculateCharge(OrderArrayList newOrderList)
	{
		if (newOrderList.size() == 0) 
		{
			throw new IllegalArgumentException();
		}
		order = newOrderList;
		
		Order[] thisOrder = new Order[order.size()];
		
		double chargePerPiece = 0;
		double chargeForHighQualityPaper; 
		double chargeForDesignEffect;
		double totalCharge = 0;
		
		for(int i = 0 ; i < order.size() ; i ++)
		{
			
			thisOrder[i] = order.get(i);
		
			int Quantity = thisOrder[i].getquantity();
			
			if(Quantity >= 1 && Quantity < 5)
				chargePerPiece = 1.0;
			
			else if(Quantity >= 5 &&Quantity <11)
				chargePerPiece = 0.9;
			
			else if(Quantity >= 11 &&Quantity <21)
				chargePerPiece = 0.7;
			
			else if(Quantity >= 21 &&Quantity <51)
				chargePerPiece = 0.5;
			
			else
				if(Quantity >= 51 &&Quantity <101)
				chargePerPiece = 0.1;
			
			else
				throw new IllegalArgumentException();
			
			boolean HighQualityPaper = thisOrder[i].getquality();
			
			if(HighQualityPaper)
			{
				chargeForHighQualityPaper = 0.1;
			}
			else
			{
				chargeForHighQualityPaper = 0.0;
			}
			
			boolean designEffect = thisOrder[i].getdesign();
			
			if(designEffect)
			{
				chargeForDesignEffect = 0.1;
			}
			else
			{
				chargeForDesignEffect = 0.0;
			}
			
			totalCharge = totalCharge+(chargePerPiece + chargeForHighQualityPaper + chargeForDesignEffect)*Quantity;
		}
		return totalCharge;
	}
}
