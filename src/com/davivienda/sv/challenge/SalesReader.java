package com.davivienda.sv.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SalesReader {
	public static String FILE_NAME = "sales.csv";
	private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<SalesBean> getSales(InputStream stream) throws ParseException{
		//TODO: implementar
		List<SalesBean> lista = new ArrayList<>();
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try {
		    br = new BufferedReader(Files.newBufferedReader(Paths.get("src/com/davivienda/sv/challenge/"+FILE_NAME)));
		    
		    boolean encabezado = true;
		    while ((line = br.readLine()) != null) {
		    	if (encabezado) {
		    		encabezado = false;
		    		continue;
		        }
		    	
		    	String[] dato = line.split(cvsSplitBy);
		    	
				SalesBean csvLine = (SalesBean) new SalesBean("");
				  
				csvLine.setRegion(dato[0]); 
				csvLine.setCountry(dato[1]);
				csvLine.setItemType(dato[2]); 
				csvLine.setOrderPriority(dato[4]);
				csvLine.setOrderDate(sdf.parse(dato[5]));
				csvLine.setOrderId(Long.parseLong(dato[6]));
				csvLine.setUnitsSold(Long.parseLong(dato[8]));
				csvLine.setUnitPrice(BigDecimal.valueOf(Double.valueOf(dato[9])));
				csvLine.setTotalRevenue(BigDecimal.valueOf(Double.valueOf(dato[11])));
				csvLine.setTotalProfit(BigDecimal.valueOf(Double.valueOf(dato[13])));
				  
				lista.add(csvLine);				 
		    }		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return lista;
	}
}
