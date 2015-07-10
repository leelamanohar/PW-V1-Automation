package com.rp.automation.framework;

import org.apache.log4j.Logger;
import org.testng.Reporter;



/**
 * FrameworkServices class
 * 
 * @author PW TA Team
 */
public class FrameworkServices {

	/**
	 * logMessage method
	 * 
	 * @param message
	 */
	public void logMessage(String message) {
		Logger logger = Logger.getLogger(FrameworkServices.class);
		logger.info(message);
		Reporter.log(message);
	}
}