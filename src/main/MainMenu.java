package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu 
{
	private static Scanner scanner = new Scanner(System.in);
	private static OrderArrayList oderList = new OrderArrayList();
	
	public static OrderArrayList Selection()
	{			
			System.out.println("Enter how many request you want: ");
			int numRequest = scanner.nextInt();
   		
			for(int i = 1 ; i <numRequest + 1 ; i++)
			{
				System.out.println("Order number "+ i +" enter the amount of quantity photo : ");
		   		int quantity = scanner.nextInt();
		   		
		        if(quantity <= 0 || quantity > 100) {
		            throw new IllegalArgumentException();
		        }
		   		
		   		System.out.println("Order number "+ i + " do you want high quality paper? (Y/N)");
		   		String skip = scanner.nextLine();
		   		String quality = scanner.nextLine().toLowerCase();
		   	    boolean highQuality;
		   	    
		   		if(quality.toUpperCase() == "y")
				{
		   			highQuality = true;
				}else
				{
					highQuality = false;
				}
		   		
		   	    System.out.println("Order number "+ i +" do you want design effect? (Y/N)");
		   	    String design = scanner.nextLine().toLowerCase();
		   	    boolean designEffect;
		   	    
		   		if(design.toUpperCase() == "y")
				{
		   			designEffect = true;
				}else
				{
					designEffect = false;
				}
		     	 
		     	Order newOrder= new Order(quantity,highQuality,designEffect);
		     	
		     	oderList.add(newOrder);
			}
			
			return oderList;
	}
	
	public void createOrders(int quantity,boolean quality,boolean effect) throws IllegalArgumentException
	{
		Order order = new Order(quantity,quality,effect);
		oderList.add(order);
	}
	
	public ArrayList<Order> getOrders()
	{
		return oderList.getOrders();
	}
	
	public OrderArrayList getOrderList()
	{
		return oderList;
	}
}
