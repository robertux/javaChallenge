package com.davivienda.sv.challenge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import com.davivienda.sv.challenge.service.SalesCounter;
import com.davivienda.sv.challenge.service.SalesReader;
import com.davivienda.sv.challenge.util.LogUtil;

import junit.framework.TestCase;

public class SalesCounterTest extends TestCase 
{
	private static final Logger LOG = LogUtil.getLogger(SalesCounterTest.class);
	
	private SalesCounter counter;
	private Date date;

	@Before
	public void setUp() {
		SalesReader reader = new SalesReader();
		this.counter = new SalesCounter();
		try {
			this.counter.setSales(reader.getSales(reader.getCSVStream()));
			this.date = new SimpleDateFormat("dd/MM/yyyy").parse("02/02/2010");
		} catch (Exception e) {
			System.out.println("ParseException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOldestSale() {
		LOG.info("Oldest Date... ");
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		Date d = counter.getOldestDate();
		assertEquals("Oldest sale debe ser del 2 de febrero de 2010", date,d );
		LOG.info("Oldest Date: " + SalesReader.SDF.format(d));
		LOG.info("Oldest Date... OK");
	}
	
	@Test
	public void testMostExpensiveItem() {
		LOG.info("Most Expensive Item... ");
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		String item = counter.getMostExpensiveItem();
		assertEquals("Item debe ser Household", "Household",item );
		LOG.info("Most Expensive Item: " +item);
		LOG.info("Most Expensive Item... OK");
	}
	
	@Test
	public void testCountryWithMostSales() {
		LOG.info("Country With Most Sales...");
		assertNotNull("date no debe ser nulo", date);
		assertNotNull("counter no debe ser nulo", counter);
		assertEquals("counter debe tener 100 sales", 100, counter.getSales().size());
		String coutry = counter.getCountryWithMostSales();
		assertEquals("Pais debe ser The Gambia", "The Gambia", coutry);
		LOG.info("Country With Most Sales: " + coutry);
		LOG.info("Country With Most Sales... OK");
	}
}
