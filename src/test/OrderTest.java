package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.MainMenu;
import main.Order;
import main.OrderArrayList;

import org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class OrderTest 
{
	Scanner scanner;
		// Test quantity less than 1 && more than 100
		public Object[] getInvalidParameter() throws Exception
		{
			File file = new File("MainMenuInvalidTest.txt");
			this.scanner = new Scanner(file);
	        
	        ArrayList<Object> printingList = new ArrayList<Object>();
	        
	        while(this.scanner.hasNextLine()) {
				String[] data = this.scanner.nextLine().split(",");
				ArrayList<Object> param =  new ArrayList<Object>();
				param.add(Integer.parseInt(data[0].trim()));
				param.add(Boolean.parseBoolean(data[1].trim()));
				param.add(Boolean.parseBoolean(data[2].trim()));
				printingList.add(param.toArray());
			}
			return printingList.toArray();
			
	    }

		@Test(expected = IllegalArgumentException.class)
		@Parameters(method ="getInvalidParameter")
		public void TestIInvalid01(int quantity, boolean quality, boolean design)
		{
			Order order;
			OrderArrayList orderList = new OrderArrayList();
			
			order= new Order(quantity,quality,design);
			orderList.add(order);
		}	
		
		
		 // test valid quantity is >= 1 and quantity <= 99.
		public Object[] getValidParameter() throws Exception
		{
			File file = new File("MainMenuValidTest.txt");
			this.scanner = new Scanner(file);
	        
	        ArrayList<Object> printingList = new ArrayList<Object>();
	        
	        while(this.scanner.hasNextLine()) {
				String[] data = this.scanner.nextLine().split(",");
				ArrayList<Object> param =  new ArrayList<Object>();
				param.add(Integer.parseInt(data[0].trim()));
				param.add(Boolean.parseBoolean(data[1].trim()));
				param.add(Boolean.parseBoolean(data[2].trim()));
				printingList.add(param.toArray());
			}
			return printingList.toArray();
			
	    }
		
		@Test	// 1 valid order
		@Parameters(method ="getValidParameter")
		public void TestIValid01(int quantity, boolean quality, boolean design)
		{
			Order actualOrder = new Order(quantity, quality, design);
			OrderArrayList orderList = new OrderArrayList();
			orderList.add(actualOrder);
			
			OrderArrayList expectedOrderList = new OrderArrayList();
			Order expectedOrder = new Order(50,true,false);
		    expectedOrderList.add(expectedOrder);
		  
		    assertEquals(expectedOrderList.getquantity(),orderList.getquantity());
		    assertEquals(expectedOrderList.getquality(),orderList.getquality());
		    assertEquals(expectedOrderList.getdesign(),orderList.getdesign());
		    
		}
		
	}

