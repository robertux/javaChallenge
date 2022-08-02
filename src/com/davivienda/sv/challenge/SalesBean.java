package com.davivienda.sv.challenge;

import java.math.BigDecimal;
//import java.text.DateFormat;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesBean {
	private String region;
	private String country;
	private String itemType;
	private String orderPriority;
	private Date orderDate;
	private long orderId;
	private long unitsSold;
	private BigDecimal unitPrice;
	private BigDecimal totalRevenue;
	private BigDecimal totalProfit;
	
	public BigDecimal getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(BigDecimal totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	//private DateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
	
	public SalesBean(String csvLine) throws ParseException {
		//TODO: Implementar
	}
	
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getOrderPriority() {
		return orderPriority;
	}
	public void setOrderPriority(String orderPriority) {
		this.orderPriority = orderPriority;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUnitsSold() {
		return unitsSold;
	}
	public void setUnitsSold(long unitsSold) {
		this.unitsSold = unitsSold;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	@Override
	public String toString() {
		return "SalesBean [region=" + region + ", country=" + country + ", itemType=" + itemType + ", orderPriority="
				+ orderPriority + ", orderDate=" + orderDate + ", orderId=" + orderId + ", unitsSold=" + unitsSold
				+ ", unitPrice=" + unitPrice + "]";
	}
}
