package com.rp.pw.pages.setup;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;
import com.rp.pw.pages.LoginPage;

/**
 * PersonalSetup class
 * 
 * @author MHarsh
 *
 */
public class PersonalSetup extends Page {

	// Initiating Logger
	Logger personalsetuplogger = Logger.getLogger(LoginPage.class);

	/**
	 * PersonalSetup method, class constructor
	 * 
	 * @param driver
	 */
	public PersonalSetup(WebDriver driver) {
		super(driver, PersonalSetup.class.getSimpleName());
	}

	
	
}
