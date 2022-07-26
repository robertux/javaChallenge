package com.davivienda.sv.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class SalesCounterTest extends TestCase {
	private SalesCounter counter;
	private Date date;

	@Before
	public void setUp() {
		this.counter = new SalesCounter(new SalesReader().getSales(Program.class.getResourceAsStream(SalesReader.FILE_NAME)));
		try {
			this.date = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2010");
		} catch (ParseException e) {
			System.out.println("ParseException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOldestSale() {
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		assertEquals("Oldest sale debe ser del 2 de febrero de 2010", date, counter.getOldestDate());
	}
	
	@Test
	public void testMostExpensiveItem() {
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		assertEquals("Item debe ser Household", "Household", counter.getMostExpensiveItem());
	}
	
	@Test
	public void testCountryWithMostSales() {
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		assertEquals("Pais debe ser The Gambia", "The Gambia", counter.getCountryWithMostSales());
	}
}
