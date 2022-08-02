package com.davivienda.sv.challenge.controller;

import java.util.logging.Logger;
import com.davivienda.sv.challenge.service.SalesCounter;
import com.davivienda.sv.challenge.service.SalesReader;
import com.davivienda.sv.challenge.util.LogUtil;

public class Program {
	
	private static final Logger LOG = LogUtil.getLogger(Program.class);
	

	public static void main(String[] args) {
		SalesReader reader = new SalesReader();
		SalesCounter counter = new SalesCounter();
		try 
		{
			counter.setSales(reader.getSales(reader.getCSVStream()));
			LOG.info("Oldest Date: " + SalesReader.SDF.format(counter.getOldestDate()));
			LOG.info("Most Expensive Item: " + counter.getMostExpensiveItem());
			LOG.info("Country With Most Sales: " + counter.getCountryWithMostSales());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<SalesBean> sales = new SalesReader().getSales(Program.class.getResourceAsStream(SalesReader.FILE_NAME));
//		SalesCounter counter = new SalesCounter(sales);
//		
//		
//		System.out.println(counter.getOldestDate());
//		System.out.println(counter.getMostExpensiveItem());
//		System.out.println(counter.getCountryWithMostSales());
	}

}
