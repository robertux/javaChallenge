package com.davivienda.sv.challenge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public final class LogUtil {

	public static Logger getLogger(Class<?> clase) {
		try {
			InputStream stream = LogUtil.class.getClassLoader().getResourceAsStream("logger.properties");
			LogManager.getLogManager().readConfiguration(stream);
			return Logger.getLogger(clase.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Logger.getLogger(clase.getName());
	}

}
