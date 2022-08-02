package com.davivienda.sv.challenge.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.davivienda.sv.challenge.model.SalesBean;
import com.davivienda.sv.challenge.util.LogUtil;

public class SalesCounter {
	
	private static final Logger LOG = LogUtil.getLogger(SalesCounter.class);

	private List<SalesBean> sales;

	public SalesCounter() {
		this.sales = new ArrayList<SalesBean>();
	}
	
	public SalesCounter(List<SalesBean> sales) {
		this.sales = sales;
	}
	
	public Date getOldestDate() {
		LOG.info("Ordenando Ventas por fecha de orden...");
		sales.sort(Comparator.comparing(SalesBean::getOrderDate));
		for (SalesBean sale : sales) {
			LOG.info(String.format("ID: %d\t Date:%s", sale.getOrderId(), sale.getOrderDate().toString()));
        }
		LOG.info("Ordenando Ventas por fecha de orden... OK");
		return sales.get(0).getOrderDate();
	}
	
	public String getMostExpensiveItem() {
		LOG.info("Ordenando Ventas por precio de unidad...");
		sales.sort(Comparator.comparing(SalesBean::getUnitPrice).reversed());
		for (SalesBean sale : sales) {
			LOG.info(String.format("ID: %d\t Item:%-30s Price:%f", sale.getOrderId(), sale.getItemType(),sale.getUnitPrice()));
        }
		LOG.info("Ordenando Ventas por precio de unidad... OK");
		return sales.get(0).getItemType();
	}
	
	public String getCountryWithMostSales() 
	{
		LOG.info("Ordenando Ventas por pais...");
		Map<String,Long> salesByConuntry = sales
				.stream()
				.collect(Collectors.groupingBy(SalesBean::getCountry , Collectors.counting()))
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		salesByConuntry.entrySet().forEach(sale -> {
			LOG.info(String.format("Country: %-50S Sales:%s", sale.getKey(),sale.getValue()));
        });
		LOG.info("Ordenando Ventas por pais...");
		return salesByConuntry.entrySet().stream().findFirst().get().getKey();
	}
	
	public List<SalesBean> getSales() {
		return sales;
	}

	public void setSales(List<SalesBean> sales) {
		this.sales = sales;
	}
}
