package com.rp.automation.framework;

/**
 * BrowserType class
 * 
 * @author PW TA Team
 */
public enum BrowserType {
	FIREFOX("firefox"), CHROME("chrome"), IE("ie"), SAFARI("safari");

	// Class variables
	private final String browser;

	/**
	 * BrowserType method
	 * 
	 * @param browser
	 */
	BrowserType(String browser) {
		this.browser = browser;
	}

	/**
	 * getBrowser method, browser getter method
	 * 
	 * @return browser
	 */
	public String getBrowser() {
		return browser;
	}
}
