package com.davivienda.sv.challenge;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SalesCounter {
	private List<SalesBean> sales;
	
	public SalesCounter() {
		this.sales = new ArrayList<SalesBean>();
	}
	
	public SalesCounter(List<SalesBean> sales) {
		this.sales = sales;
	}
	
	public Date getOldestDate() throws ParseException {
		//TODO: Implementar fecha de la venta más antigua
		
		Comparator<SalesBean> saleDateComparator = Comparator.comparing(SalesBean::getOrderDate);
		SalesBean saleOldestDate = getSales().stream().min(saleDateComparator).get();
		
		return saleOldestDate.getOrderDate();
	}
	
	public String getMostExpensiveItem() {
		//TODO: Implementar nombre del item más caro en las ventas
		
		Comparator<SalesBean> expensiveItemComparator = Comparator.comparing(SalesBean::getUnitPrice);
		SalesBean expensiveItem = getSales().stream().max(expensiveItemComparator).get();
	
		return expensiveItem.getItemType();
	}
	
	public String getCountryWithMostSales() {
		//TODO: Implementar país que haya tenido más ventas
		  String country= ""; 
		  BigDecimal sumaTP = new BigDecimal(0);
		  BigDecimal sumaTS= new BigDecimal(0);
		  int i; int j=1; 
		  for(i= 1; i< sales.size(); i++) { 
			  for(j= 2; j < (sales.size()-1); j++) {
				  if(sales.get(i).getCountry().equals(sales.get(j).getCountry())){ 
					  sumaTP = sumaTP.add(sales.get(i).getTotalRevenue());
					  }
				  }
			  int resul= 0;
			  resul= sumaTP.compareTo(sumaTS);
			  if (resul == 1){			  
				  sumaTS = sumaTS.add(sumaTP);
				  country= sales.get(i).getCountry();
			  }	
		 }
		return country;
	}
	
	public List<SalesBean> getSales() {		
		return sales;
	}

	public void setSales(List<SalesBean> sales) {
		this.sales = sales;
	}
}
