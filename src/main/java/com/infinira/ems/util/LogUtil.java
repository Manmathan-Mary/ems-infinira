package com.infinira.ems.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;  
import java.net.URL;
import java.text.MessageFormat;

public class LogUtil {
	private static final String LOGGER_CONFIG = "emslog.conf";
	private static LogUtil instance = null;
	private Logger logger;
	
	private LogUtil() {
		URL url = Thread.currentThread().getContextClassLoader().getResource(LOGGER_CONFIG);
		if(url == null) {
			throw new RuntimeException(MessageFormat.format(MSG_0001, LOGGER_CONFIG));
		}
		try {
			DOMConfigurator.configure(url);
			this.logger = Logger.getLogger(LogUtil.class);
		}catch(Exception ex) {
			throw new RuntimeException(MessageFormat.format(MSG_0002, LOGGER_CONFIG), ex);
		}	
	}
	
	public static LogUtil getInstance() {
		if(instance == null ) {
			synchronized(LogUtil.class) {
				instance = new LogUtil();
			}
		}
		return instance;
	}
	
	public  Logger getLogger() {
		return this.logger;
	}
	private static final String MSG_0001 = "{0} file not found";
	private static final String MSG_0002 = "Failed to initialize logger configuration for {0}";
	private static final String MSG_0003 = "Failed to get Logger Instance due to invalid fields in {0} file";
}
