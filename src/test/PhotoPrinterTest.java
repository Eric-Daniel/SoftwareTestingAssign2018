package test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import main.Order;
import main.OrderArrayList;
import main.PhotoPrinter;

import org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class PhotoPrinterTest 
{

	@Test
	public void testQueueRequest()
	{
		
		PhotoPrinter printer = new PhotoPrinter();
		PhotoPrinter spyprinter = spy(printer);
		
		Order order1 = new Order(10,false,true);
		Order order2 = new Order(20,true,true);
		Order order3 = new Order(30,true,true);
		
		OrderArrayList orderList = new OrderArrayList();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		
		spyprinter.queueRequest(orderList);
		
		verify(spyprinter, times(3)).sendOrder();
	}
}
