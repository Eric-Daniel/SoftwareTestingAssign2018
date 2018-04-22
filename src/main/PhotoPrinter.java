package main;

	public class PhotoPrinter 
	{
		public void queueRequest(OrderArrayList orders) 
		{
			// code for photo printing class
			for(int i = 0; i < orders.getOrders().size(); i++)
				this.sendOrder();
			
		}
		
		public void sendOrder()
		{
			System.out.println("Order receive successfully");
		}
	}