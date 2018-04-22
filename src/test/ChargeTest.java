package test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;
import main.Charge;
import main.Order;
import main.OrderArrayList;

@RunWith(JUnitParamsRunner.class)
public class ChargeTest
{
	Scanner scanner;
	
		public Object[] getParameterOrder() throws Exception
		{
			
			File file = new File("SingleChargeTest.txt");
			this.scanner = new Scanner(file);
	        
	        ArrayList<Object> printingList = new ArrayList<Object>();
	        
	        while(this.scanner.hasNextLine()) {
				String[] data = this.scanner.nextLine().split(",");
				ArrayList<Object> param =  new ArrayList<Object>();
				param.add(Integer.parseInt(data[0].trim()));
				param.add(Boolean.parseBoolean(data[1].trim()));
				param.add(Boolean.parseBoolean(data[2].trim()));
				param.add(Double.parseDouble(data[3].trim()));
				printingList.add(param.toArray());
			}
			return printingList.toArray();
	        
	        
	        
		}
		@Parameters(method = "getParameterOrder")
		@Test
		public void testcalculateCharge(int quantity,boolean quality,boolean design, double expectedFees)
		{
			Order order = new Order(quantity, quality, design);
			OrderArrayList orderList = new OrderArrayList();
    		orderList.add(order);
			Charge charge = new Charge();
			double result = charge.calculateCharge(orderList);
			
			Assert.assertEquals(expectedFees, result, 0.0001);
		}
		
		public Object[] getParameterCharge() throws Exception
		{
			File file = new File("MultipleChargeTest.txt");
			this.scanner = new Scanner(file);
	        
	        ArrayList<Object> printingList = new ArrayList<Object>();
	        
	        while(this.scanner.hasNextLine()) {
				String[] data = this.scanner.nextLine().split(",");
				ArrayList<Object> param =  new ArrayList<Object>();
				param.add(Integer.parseInt(data[0].trim()));
				param.add(Boolean.parseBoolean(data[1].trim()));
				param.add(Boolean.parseBoolean(data[2].trim()));
				param.add(Integer.parseInt(data[3].trim()));
				param.add(Boolean.parseBoolean(data[4].trim()));
				param.add(Boolean.parseBoolean(data[5].trim()));
				param.add(Double.parseDouble(data[6].trim()));
				printingList.add(param.toArray());
			}
			return printingList.toArray();
			
		}
		
		@Test
		@Parameters(method="getParameterCharge")
		public void testCalTotalCharge(int quantity1,boolean quality1,boolean design1,int quantity2,boolean quality2,boolean design2, double expectedFees)
		{
			Order order1 = new Order(quantity1, quality1, design1);
			Order order2 = new Order(quantity2, quality2, design2);
			OrderArrayList orderList = new OrderArrayList();
    		orderList.add(order1);
    		orderList.add(order2);
			Charge charge = new Charge();
			double calCharge = charge.calculateCharge(orderList);
			
			Assert.assertEquals(expectedFees, calCharge, 0.0001);
		}
		
}
		