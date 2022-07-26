package com.davivienda.sv.challenge;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<SalesBean> sales = new SalesReader().getSales(Program.class.getResourceAsStream(SalesReader.FILE_NAME));
		SalesCounter counter = new SalesCounter(sales);
		System.out.println(counter.getOldestDate());
		System.out.println(counter.getMostExpensiveItem());
		System.out.println(counter.getCountryWithMostSales());
	}

}
