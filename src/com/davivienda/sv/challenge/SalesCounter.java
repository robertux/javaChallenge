package com.davivienda.sv.challenge;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesCounter {
	private List<SalesBean> sales;

	public SalesCounter() {
		this.sales = new ArrayList<SalesBean>();
	}
	
	public SalesCounter(List<SalesBean> sales) {
		this.sales = sales;
	}
	
	public Date getOldestDate() {
		List<Date> fechas = new ArrayList<Date>();
		for(SalesBean sale : sales) {
			fechas.add(sale.getOrderDate());
		}
		return Collections.min(fechas);
	}
	
	public String getMostExpensiveItem() {
		SalesBean sale = sales.stream().max(Comparator.comparing(SalesBean::getUnitPrice)).get();
		return sale.getItemType();
	}
	
	public String getCountryWithMostSales() {
		SalesBean sale = Collections.max(sales, Comparator.comparing(s -> s.getUnitsSold()));
		return sale.getCountry();
	}
	     
	public List<SalesBean> getSales() {
		return sales;
	}

	public void setSales(List<SalesBean> sales) {
		this.sales = sales;
	}
}
