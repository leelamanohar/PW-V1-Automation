package com.rp.pw.test.data.setup;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rp.automation.framework.ExcelService;
import com.rp.automation.framework.WebDriverBase;
import com.rp.pw.pages.Homepage;
import com.rp.pw.pages.LoginPage;
import com.rp.pw.pages.setup.AdministrativeSetup;

/**
 * OS_Startup class, houses the Startup component of OS data setup
 * 
 * @author MHarsh
 *
 */
public class OS_Startup extends WebDriverBase {

	/**
	 * dataprovider method
	 * @return iterator
	 */
	// TestNG DataProvider connectivity
	@DataProvider(name = "DataProvider")
	public Iterator<Object[]> dataprovider() {
		return new ExcelService().readTestDataFromExcel(
				WebDriverBase._prop.getString("PWWorkBookName"), "Login");
	}

	/**
	 * startup method
	 * 
	 * @param data
	 */
	// TestNG, harness, annotation
	@Test(dataProvider = "DataProvider", groups = { "OS_DataSetup" })
	public void startup(Map<String, String> data) {

		// log4j instantiation
		Logger logger = Logger.getLogger(OS_Startup.class);

		// Opening the Browser
		WebDriver driver = getDriver();
		logger.info("Driver initialized");
		// Navigating to PW Login page
		driver.get(WebDriverBase._prop.getString("PWtesturl"));
		logger.info("Navigate to URL");
		// Set page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Entering the Login Details
		LoginPage Loginpage = new LoginPage(driver);
		Loginpage.PWLoginAs(data);
		logger.info("Login completed");

		// Navigating to setup link
		Homepage homepage = new Homepage(driver);
		homepage.GotoSetup();
		logger.info("Setup page displayed");

		// Navigating to Administrative Setup page
		AdministrativeSetup administrativeSetup = new AdministrativeSetup(
				driver);
		administrativeSetup.navAdministrativeSetupLink();
		logger.info("Administrative Setup page is displayed");

		// Navigating to Company Info page
		administrativeSetup.navCompanyInfoLink();
		logger.info("Company Info Page is displayed");

		// Clicking Edit Button
		administrativeSetup.clickEditButton();
		logger.info("Clicking Edit Button");

		// Selecting Management Company List Box to Yes
		administrativeSetup.selectManagementCompanyListBoxToYes();
		logger.info("Selecting Management Company List Box to Yes");

		
		
		
		// Verify whether user is logged in or not
		boolean checkLogin;
		checkLogin = Loginpage.VerifyLogin();

		// Logout of PW
		Loginpage.PWLogout(checkLogin);
		logger.info("Logout completed");

	}
}
