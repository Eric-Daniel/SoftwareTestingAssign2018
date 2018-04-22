package main;

import java.util.ArrayList;
import java.util.List;

public class OrderArrayList 
{
	private ArrayList<Order> order;
	Order aOrder;
	public OrderArrayList() 
	{
		order = new ArrayList<Order>();
	}
	
	public void add(Order theOrder) 
	{	
		this.aOrder =theOrder;
		order.add(theOrder);
	}
	public ArrayList<Order> getOrders()
	{
		return order;
	}
	public int getquantity()
	{
		int quantity = aOrder.getquantity();
		return quantity;
	}
	
	public boolean getquality()
	{
	
		boolean highquality = aOrder.getquality();
		return highquality;
	}
	
	public boolean getdesign()
	{
		boolean designeffect = aOrder.getdesign();
		return designeffect;
	}
	public int size() 
	{
		return order.size();
	}

	public Order get(int i) 
	{
		return order.get(i);
	}
}
