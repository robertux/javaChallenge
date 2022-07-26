package com.davivienda.sv.challenge;

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
		//TODO: Implementar
		return null;
	}
	
	public String getMostExpensiveItem() {
		//TODO: Implementar
		return null;
	}
	
	public String getCountryWithMostSales() {
		//TODO: Implementar
		return null;
	}
	
	public List<SalesBean> getSales() {
		return sales;
	}

	public void setSales(List<SalesBean> sales) {
		this.sales = sales;
	}
}
