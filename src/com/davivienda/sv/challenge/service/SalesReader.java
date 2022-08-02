package com.davivienda.sv.challenge.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.davivienda.sv.challenge.model.SalesBean;
import com.davivienda.sv.challenge.util.LogUtil;

public class SalesReader 
{
	private static final Logger LOG = LogUtil.getLogger(SalesReader.class);
	
	public static final String FILE_NAME = "sales.csv";
	public static final String SEPARATOR = ",";
	public static final DateFormat SDF = new SimpleDateFormat("MM/dd/yyyy");
	
	public InputStream getCSVStream()
	{
		LOG.info("Obteniendo csv...");
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		LOG.info("Obteniendo csv... OK");
		return stream;
	}

	public List<SalesBean> getSales(InputStream stream) throws Exception {
		String registro;
		String [] datos;
		int i = 0;
		List<SalesBean> ventas = new ArrayList<>();
		BufferedReader csv = new BufferedReader(new InputStreamReader(stream));
        LOG.info("Leyendo csv...");
        if(csv.readLine()==null)
        	throw new Exception("El archivo esta vacio");
		while ((registro = csv.readLine()) != null) {
			datos = registro.split(SEPARATOR);
            //LOG.info(String.format("[Registro][%d]: %s",++i,registro));
            //LOG.info(String.format("[datos][%d]: %s",i,Arrays.toString(datos)));
            SalesBean venta = new SalesBean();
            try {
            	//Region 0
            	if(datos[0] != null)
            		venta.setRegion(datos[0].trim());
            	//Country 1
            	if(datos[1] != null)
            		venta.setCountry(datos[1].trim());
            	//ItemType 2
            	if(datos[2] != null)
            		venta.setItemType(datos[2].trim());
            	//Sales Channel 3
            	//Order Priority 4
            	if(datos[4] != null)
            		venta.setOrderPriority(datos[4].trim());
            	//Order Date 5
            	if(datos[5] != null)
            		venta.setOrderDate(SDF.parse(datos[5].trim()));
            	//Order ID 6
            	if(datos[6] != null && datos[6].trim().matches("[0-9]+"))
            		venta.setOrderId(Long.parseLong(datos[6].trim()));
            	//Ship Date 7
            	//Units Sold 8
            	if(datos[8] != null && datos[8].trim().matches("[0-9]+"))
            		venta.setUnitsSold(Long.parseLong(datos[8].trim()));
            	//Unit Price 9
            	if(datos[9] != null)
            		venta.setUnitPrice(new BigDecimal(datos[9].trim()));
            	//Unit Cost 10
            	//Total Revenue 11
            	//Total Cost 12
            	//Total Profit 13
            	ventas.add(venta);
            	//LOG.info(String.format("[Parse][%d]: %s",i,venta));
			} catch (Exception e) {
	            LOG.info(String.format("El registro %d no pudo ser leido %s",i, venta));
			}
         }
        LOG.info("ventas size: " + ventas.size());
        LOG.info("Leyendo csv... OK");
		return ventas;
	}
}
