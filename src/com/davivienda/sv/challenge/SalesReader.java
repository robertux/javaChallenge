package com.davivienda.sv.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SalesReader {
	public static String FILE_NAME = "sales.csv";
	
	public List<SalesBean> getSales(InputStream stream) {
		String linea = "";
		List<SalesBean> sales = new ArrayList<SalesBean>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		 try {
			reader.readLine();
			while ((linea = reader.readLine()) != null) {
				SalesBean sale = new SalesBean(linea);
				//System.out.println("Sales Bean : "+sale.toString());
				sales.add(sale);
			 }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return sales;
	}
	
}
