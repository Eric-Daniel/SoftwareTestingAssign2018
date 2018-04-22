package test;
import java.util.Scanner;

import main.Charge;
import main.MainMenu;
import main.Order;
import main.PhotoPrinter;

public class IntergrationTest 
{
	private static Scanner scanner;
	
	public static void main()
	{
		MainMenu.Selection();
		
		boolean quit = false;
		do{
			System.out.println("Please Select Option");
			System.out.println("[1] - Send in Order");
			System.out.println("[2] - Quit");
			
			String choice = scanner.nextLine();
			
			if(choice.equals("1"))
			{
				start();
			}
			else
			{
				quit = true;
			}
		}while(quit);
		
		System.exit(0);
	}
	public static void start(){
		
		MainMenu menu = new MainMenu();

		
		boolean quit = false;
		do{
			System.out.println("------------Ordering-----------------");
			System.out.println("[1] - Comfirm order");
			System.out.println("[2] - Finish");
			System.out.print("Choice: \t");
			String choice = scanner.nextLine();
			
			if(choice.equals("1"))
			{
				menu.Selection();
			}
			else
			{
				quit  = true;
			}
		}while(quit);
		
		Charge charge = new Charge();
		double fees = charge.calculateCharge(menu.getOrderList());
		System.out.println("Charge: RM" + charge);
		
		PhotoPrinter printer = new PhotoPrinter();
		printer.queueRequest(menu.getOrderList());
	}
}
