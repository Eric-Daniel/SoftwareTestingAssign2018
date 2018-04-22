package main;

public class Order 
{
	private int numberOfRequest;
	
	public int getNumberOfRequest()
	{
//		if(numberOfRequest < 1 || numberOfRequest > 101)
//		{
//			throw new IllegalArgumentException("Invalid quantity value");
//		}
		return numberOfRequest;
	}
	
	private int quantity;
	
	public int getquantity()
	{
		return quantity;
	}
	
	public boolean quality;
	
	public boolean getquality()
	{
		boolean highquality;
		
		if(quality)
		{
			highquality = true;
		}
		else
			if(!quality)
		{
			highquality = false;
		}
		else
		{
   	    	throw new IllegalArgumentException("Invalid quality");
		}
		
		return highquality;
	}
	
	public boolean design;
	
	public boolean getdesign()
	{
		
		boolean designeffect;
		
		if(design)
		{
			designeffect = true;
		}
		else
			if(!design)
		{
			designeffect = false;
		}
		else
		{
			throw new IllegalArgumentException("Invalid selection");
		}
		
		return designeffect;
	}
	public Order(int quantity,boolean quality,boolean design)
	{
		if(quantity <= 0 || quantity > 100)
		{
			throw new IllegalArgumentException("Invalid quantity value");
		}
		this.quantity = quantity;
		this.quality = quality;
		this.design = design;
	}

}

