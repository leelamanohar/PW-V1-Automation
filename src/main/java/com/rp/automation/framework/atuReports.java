package com.rp.automation.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

/**
 * atuReports class
 * 
 * @author PW TA Team
 *
 */
@Listeners({ ATUReportsListener.class, ConfigurationListener.class, MethodListener.class })
public class atuReports {

	// Set Property for ATU Reporter Configuration
	{
		System.setProperty("atu.reporter.config", "D:\\AutomationWorkspace\\atuReports\\atu.properties");
		System.out.println(System.getProperty("atu.proj.header.logo"));
		// System.setProperty("atu.reports.dir",System.getProperty("user.dir")+"\\Results1\\"
		// );
		// System.out.println("results root is "+System.getProperty("user.dir")+"\\Results1");
		// System.setProperty("atu.proj.header.logo",System.getProperty("user.dir")+"\\logo\\RealpageLogo.png"
		// );
		setIndexPageDescription();
	}

	/**
	 * setWebdriver method
	 * 
	 * @param driver
	 */
	public static void setWebdriver(WebDriver driver) {
		ATUReports.setWebDriver(driver);
	}

	/**
	 * setAuthorInfoForReports method
	 */
	public static void setAuthorInfoForReports() {
		ATUReports.setAuthorInfo("Propertyware Automation Team", Utils.getCurrentTime(), "1.0");
	}

	/**
	 * setIndexPageDescription method
	 */
	public static void setIndexPageDescription() {
		ATUReports.indexPageDescription = "<b>Propertyware Web Application Automation</b>";
		ATUReports.currentRunDescription = "PW Smoke Test Suite";
	}

	/**
	 * setCurrentRunDescription method
	 * 
	 * @param Desc
	 */
	public static void setCurrentRunDescription(String Desc) {
		ATUReports.currentRunDescription = Desc;
	}

	/**
	 * setTestCaseReqCoverage method
	 * 
	 * @param Desc
	 */
	public static void setTestCaseReqCoverage(String Desc) {
		ATUReports.setTestCaseReqCoverage(Desc);
	}

	/**
	 * passResults method
	 * 
	 * @param Desc
	 * @param InputValue
	 * @param ExpectedValue
	 * @param ActualValue
	 */
	public static void passResults(String Desc, String InputValue, String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false);
	}

	/**
	 * failResults method
	 * 
	 * @param Desc
	 * @param InputValue
	 * @param ExpectedValue
	 * @param ActualValue
	 */
	public static void failResults(String Desc, String InputValue, String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, LogAs.FAILED, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false)
	}

	/**
	 * passResults1 method
	 * 
	 * @param Desc
	 * @param InputValue
	 * @param ExpectedValue
	 * @param ActualValue
	 */
	@SuppressWarnings("deprecation")
	public static void passResults1(String Desc, String InputValue, String ExpectedValue, String ActualValue) {
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue,
		// LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, false);
	}

	/**
	 * failResults1 method
	 * 
	 * @param Desc
	 * @param InputValue
	 * @param ExpectedValue
	 * @param ActualValue
	 */
	@SuppressWarnings("deprecation")
	public static void failResults1(String Desc, String InputValue, String ExpectedValue, String ActualValue) {
		// ATUReports.add(Desc, InputValue,ExpectedValue,ActualValue,
		// LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, true);
	}

	/**
	 * infoResults method
	 * 
	 * @param Desc
	 */
	public static void infoResults(String Desc) {
		ATUReports.add(Desc, LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
	}

	/**
	 * warningResults method
	 * 
	 * @param Desc
	 * @param InputValue
	 * @param ExpectedValue
	 * @param ActualValue
	 */
	public static void warningResults(String Desc, String InputValue, String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, LogAs.WARNING, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
	}

}
