package com.rp.automation.framework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.rp.automation.framework.exceptions.ElementNotDisappearedInException;
import com.rp.automation.framework.exceptions.ElementNotLoadedInSpecifiedTimeException;
import com.rp.automation.framework.exceptions.UnsuccessfulServiceException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Page class
 * 
 * @author Created by Propertyware Automation Team
 */
public abstract class Page {

	// Class variables
	protected WebDriver driver;
	protected WebDriverHelper webDriverHelper;
	protected FrameworkServices frameworkServices;
	protected String pageName;
	public String value;

	/**
	 * Page method, class constructor
	 * 
	 * @param driver
	 * @param pageName
	 */
	public Page(WebDriver driver, String pageName) {
		this.driver = driver;
		this.pageName = pageName;
		webDriverHelper = new WebDriverHelper(driver);
		frameworkServices = new FrameworkServices();
	}

	/**
	 * waitForElementAndReturnElement method
	 * 
	 * @param pageElement
	 * @return pageElement
	 */
	protected WebElement waitForElementAndReturnElement(PageElement pageElement) {

		switch (pageElement.getWaitType()) {
		case WAIT_FOR_ELEMENT_TO_BE_CLICKABLE:
			try {
				return webDriverHelper.waitForElementToBeClickable(pageElement.getBy(), pageElement.getTimeOut());
			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}

		case WAIT_FOR_ELEMENT_TO_BE_ENABLED:

			try {
				return webDriverHelper.waitForElementToBeEnabled(pageElement.getBy(), pageElement.getTimeOut());
			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}

		case WAIT_FOR_ELEMENT_TO_BE_DISPLAYED:

			try {
				return webDriverHelper.waitForElementToBeDisplayed(pageElement.getBy(), pageElement.getTimeOut());
			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}

		default:
			return driver.findElement(pageElement.getBy());

		}

	}

	/**
	 * waitForPageElement method
	 * 
	 * @param pageElement
	 */
	protected void waitForPageElement(PageElement pageElement) {

		boolean isWebElementAvailableInPageElement = isWebElementAvailablesInPageElement(pageElement);
		switch (pageElement.getWaitType()) {
		case WAIT_FOR_ELEMENT_TO_BE_CLICKABLE:
			try {
				if (!isWebElementAvailableInPageElement)
					webDriverHelper.waitForElementToBeClickable(pageElement.getBy(), pageElement.getTimeOut());
				else
					webDriverHelper.waitForElementToBeClickable(pageElement.getWebElement(), pageElement.getTimeOut());

			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}
			break;
		case WAIT_FOR_ELEMENT_TO_BE_ENABLED:

			try {
				if (!isWebElementAvailableInPageElement)
					webDriverHelper.waitForElementToBeEnabled(pageElement.getBy(), pageElement.getTimeOut());
				else
					webDriverHelper.waitForElementToBeEnabled(pageElement.getWebElement(), pageElement.getTimeOut());

			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}
			break;
		case WAIT_FOR_ELEMENT_TO_BE_DISPLAYED:

			try {
				if (!isWebElementAvailableInPageElement)
					webDriverHelper.waitForElementToBeDisplayed(pageElement.getBy(), pageElement.getTimeOut());
				else
					webDriverHelper.waitForElementToBeDisplayed(pageElement.getWebElement(), pageElement.getTimeOut());

			} catch (TimeoutException e) {
				throw new ElementNotLoadedInSpecifiedTimeException(pageElement.getName(), pageElement.getTimeOut(), e);
			}
			break;

		case WAIT_FOR_ELEMENT_TO_DISAPPEAR:
			try {
				if (!isWebElementAvailableInPageElement)
					webDriverHelper.waitForElementToDisappear(pageElement.getBy(), pageElement.getTimeOut());
				else {
					webDriverHelper.waitForElementToDisappear(pageElement.getWebElement(), pageElement.getTimeOut());
				}

			} catch (TimeoutException e) {
				throw new ElementNotDisappearedInException(pageElement.getName(), pageElement.getTimeOut(), e);
			}
			break;
		default:
			break;
		}

	}

	/**
	 * isWebElementAvailablesInPageElement method
	 * 
	 * @param pageElement
	 * @return pageElement
	 */
	private boolean isWebElementAvailablesInPageElement(PageElement pageElement) {
		return !(pageElement.getWebElement() == null);
	}

	/**
	 * getWebElement method
	 * 
	 * @param pageElement
	 * @return pageElement
	 */
	protected WebElement getWebElement(PageElement pageElement) {

		if (pageElement.isSlowLoadableComponent()) {
			return waitForElementAndReturnElement(pageElement);

		} else
			return driver.findElement(pageElement.getBy());

	}

	/**
	 * sendKeys method
	 * 
	 * @param pageElement
	 * @param value
	 */
	protected void sendKeys(PageElement pageElement, String value) {
		try {
			value = (value == null) ? "" : value;
			if (!isWebElementAvailablesInPageElement(pageElement))
				getWebElement(pageElement).sendKeys(value);

			else
				pageElement.getWebElement().sendKeys(value);
			//frameworkServices.logMessage("Typed Value: " + value + "' in " + pageElement.getName());
			atuReports.passResults1("SendKeys: " + pageElement.getName(), value, value, value);
		} catch (Exception exception) {
			atuReports.failResults("Failed to type value: " + pageElement.getName(), value, value, "--");
			throw new UnsuccessfulServiceException("Failed to type value: '" + value + "' in " + pageElement.getName()
					+ " on : '" + pageName + "'", exception);
		}
	}

	/**
	 * sendKeys method
	 * 
	 * @param pageElement
	 * @param key
	 */
	protected void sendKeys(PageElement pageElement, Keys key) {
		try {

			if (!isWebElementAvailablesInPageElement(pageElement))
				getWebElement(pageElement).sendKeys(key);
			else
				pageElement.getWebElement().sendKeys(key);
			frameworkServices.logMessage("Typed Value: " + key + "' in " + pageElement.getName());
			atuReports.passResults1("SendKeys: " + pageElement.getName(), key.toString(), key.toString(),
					key.toString());
		} catch (Exception exception) {
			atuReports.failResults("Failed to press the Key: " + pageElement.getName(), key.toString(), key.toString(),
					"--");
			throw new UnsuccessfulServiceException("Failed to press : '" + key + "' in " + pageElement.getName()
					+ " on : '" + pageName + "'", exception);
		}
	}

	/**
	 * clearAndSendKeys method
	 * 
	 * @param pageElement
	 * @param value
	 */
	protected void clearAndSendKeys(PageElement pageElement, String value) {
		try {
			WebElement element;
			if (!isWebElementAvailablesInPageElement(pageElement))
				element = getWebElement(pageElement);
			else
				element = pageElement.getWebElement();
			element.clear();
			element.sendKeys(value);
			atuReports.passResults1("Cleared and Typed Value: " + pageElement.getName(), value, value, value);
			frameworkServices.logMessage("Cleared and Typed Value: " + value + "' in " + pageElement.getName());
		} catch (Exception exception) {
			atuReports.failResults("Failed to clear and  type value: " + pageElement.getName(), value, value, "--");
			throw new UnsuccessfulServiceException("Failed to clear and  type value: '" + value + "' in "
					+ pageElement.getName() + " on : '" + pageName + "'", exception);
		}
	}

	/**
	 * click method
	 * 
	 * @param pageElement
	 */
	protected void click(PageElement pageElement) {
		try {

			WebElement element;
			if (!isWebElementAvailablesInPageElement(pageElement))
				element = getWebElement(pageElement);
			else
				element = pageElement.getWebElement();
			element.click();
			frameworkServices.logMessage("Clicked on: " + pageElement.getName());
			atuReports.passResults1("Clicked on: " + pageElement.getName(), "--", pageElement.getName()
					+ " Should be clicked", pageElement.getName() + " is clicked");

		} catch (Exception exception) {
			atuReports.failResults("Failed to click on : " + pageElement.getName(), "--", pageElement.getName()
					+ " Should be clicked", pageElement.getName() + " is not clicked");
			throw new UnsuccessfulServiceException("Failed to click on : '" + pageElement.getName() + "' on : '"
					+ pageName + "' ", exception);

		}
	}

	/**
	 * check method
	 * 
	 * @param pageElement
	 */
	protected void check(PageElement pageElement) {
		try {

			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			if (!webElement.isSelected())
				webElement.click();
			frameworkServices.logMessage("Checked  " + pageElement.getName());
			atuReports.passResults1("Checked " + pageElement.getName(), "Checked On", pageElement.getName()
					+ " : Should be Checked On", pageElement.getName() + " : is Checked On");
		} catch (Exception exception) {
			atuReports.failResults("Failed to check: " + pageElement.getName(), "Checked On", pageElement.getName()
					+ " : Should be Checked On", pageElement.getName() + " : is not Checked On");
			throw new UnsuccessfulServiceException("Failed to check: '" + pageElement.getName() + " on : '" + pageName
					+ "' ", exception);
		}
	}

	/**
	 * unCheck method
	 * 
	 * @param pageElement
	 */
	protected void unCheck(PageElement pageElement) {
		try {

			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			if (webElement.isSelected())
				webElement.click();
			frameworkServices.logMessage("Unchecked  " + pageElement.getName());
			atuReports.passResults1("Unchecked " + pageElement.getName(), "Checked Off", pageElement.getName()
					+ " : Should be Checked Off", pageElement.getName() + ": is Checked Off");
		} catch (Exception exception) {
			atuReports.failResults("Failed to un check: " + pageElement.getName(), "Checked Off", pageElement.getName()
					+ " : Should be Checked Off", pageElement.getName() + ": is not Checked Off");
			throw new UnsuccessfulServiceException("Failed to un check: '" + pageElement.getName() + " on : '"
					+ pageName + "' ", exception);
		}
	}

	/**
	 * acceptAlertAndReturnConfirmationMessage method
	 * 
	 * @return
	 */
	protected String acceptAlertAndReturnConfirmationMessage() {
		try {
			String confirmationMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			frameworkServices.logMessage("fetched text: " + confirmationMessage + " from alert box and accepted");
			atuReports.passResults1("fetched text: " + confirmationMessage + " from alert box and accepted", "",
					confirmationMessage + " Should be displayed", confirmationMessage + " is displayed");
			return confirmationMessage;

		} catch (Exception exception) {
			atuReports.failResults("failed to  accept alert on " + pageName, "--",
					"Confirmation message Should be displayed", "Confirmation Message is not displayed");
			throw new UnsuccessfulServiceException("failed to  accept alert on " + pageName + "' ", exception);
		}
	}

	/**
	 * dismissAlertAndReturnConfirmationMessage method
	 * 
	 * @return confirmationMessage
	 */
	protected String dismissAlertAndReturnConfirmationMessage() {
		try {
			String confirmationMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().dismiss();
			frameworkServices.logMessage("fetched text: " + confirmationMessage + " from alert box and accepted");
			atuReports.passResults1("fetched text: " + confirmationMessage + " from alert box and dismissed", "",
					"Alert Should be Dismissed", "Alert is Dismissed");
			return confirmationMessage;
		} catch (Exception exception) {
			atuReports.failResults("failed to dismiss alert on " + pageName, "--", "Alert Should be dismissed",
					"Alert Failes to Dismiss");
			throw new UnsuccessfulServiceException("failed to  dismiss alert on " + pageName + "' ", exception);
		}
	}

	/**
	 * switchToFrameByName method
	 * 
	 * @param value
	 */
	protected void switchToFrameByName(String value) {
		try {
			// webDriverHelper.WAIT_FOR_FRAME_TO_BE_DISPLAYED(driver,
			// timeOutPeriod, value);
			webDriverHelper.WAIT_FOR_FRAME_TO_BE_DISPLAYED(driver, 1000, value);
			// driver.switchTo().frame(value);
			frameworkServices.logMessage("switched the frame:" + value);
			atuReports.passResults1("switched the frame:", "", "Frame Should be Switched to: " + value,
					"Frame is  Switched to: " + value);
		} catch (Exception exception) {
			atuReports.failResults("failed to  switch to frame on " + pageName, "--", "Frame Should be Switched to :"
					+ value, "Frame is not Switched to :" + value);
			throw new UnsuccessfulServiceException("failed to  switch to frame on " + pageName + "' ", exception);
		}

	}

	/**
	 * driverManage method
	 */
	protected void driverManage() {
		try {
			driver.manage().window().maximize();
			atuReports.passResults1("window maximized", "", "Window Should be Maximized", "Window is Maximized");
			frameworkServices.logMessage(pageName + "window maximized");
		} catch (Exception exception) {
			atuReports.failResults("failed to  maximize the window name has " + pageName, "--",
					"Window Should be Maximized", "Window is not Maximized");
			throw new UnsuccessfulServiceException("failed to  maximize the window name has " + pageName + "' ",
					exception);
		}

	}

	/**
	 * randomText method
	 * 
	 * @param value
	 * @return sum of value + rndnum
	 */
	protected String randomText(String value) {
		try {
			long rndnum = System.currentTimeMillis();
			frameworkServices.logMessage("randome text as " + value + rndnum);
			atuReports.passResults1("randome text generated as", "", "randome text should be generated as " + value
					+ rndnum, "randome text is generated as " + value + rndnum);
			return value + rndnum;
		} catch (Exception exception) {
			atuReports.failResults("failed to  generate randomtext " + pageName, "--",
					"randome text should be Generated", "randome text is not generated");
			throw new UnsuccessfulServiceException("failed to  generate randomtext " + pageName + "' ", exception);
		}

	}

	/**
	 * switchToDefault method
	 */
	protected void switchToDefault() {
		try {

			driver.switchTo().defaultContent();
			frameworkServices.logMessage("switched to the Deafult Window or Frame or Content");
			atuReports.passResults1("switched to the Deafult Window or Frame or Content", "",
					"Browser should switched to the Deafult Window or Frame or Content",
					"Browser is switched to the Deafult Window or Frame or Content");
		} catch (Exception exception) {
			atuReports.failResults("failed to  switch to default content on" + pageName, "--",
					"Browser should switched to the Deafult Window or Frame or Content",
					"Browser is not switched to the Deafult Window or Frame or Content");
			throw new UnsuccessfulServiceException("failed to  switch to default content on " + pageName + "' ",
					exception);
		}

	}

	/**
	 * switchToDefaultWindow method
	 * 
	 * @param sWindowName
	 */
	protected void switchToDefaultWindow(String sWindowName) {
		try {
			sWindowName = captureCurrentWindow();
			driver.switchTo().window(sWindowName);
			frameworkServices.logMessage("switched to the Deafult Window " + sWindowName);
			atuReports.passResults1("switched to the Deafult Window ", "--", "Window Should be Switched to "
					+ sWindowName, "Window is Switched to " + sWindowName);
		} catch (Exception exception) {
			atuReports.failResults("failed to  switch to default window having the Titile" + sWindowName + " on "
					+ pageName, "--", "Window Should be Switched to " + sWindowName, "Window is not Switched to "
					+ sWindowName);
			throw new UnsuccessfulServiceException("failed to  switch to default window having the Titile "
					+ sWindowName + " on " + pageName + "' ", exception);
		}

	}

	/**
	 * captureCurrentWindow method
	 * 
	 * @return windowname
	 */
	protected String captureCurrentWindow() {
		String windowname = null;
		try {

			windowname = driver.getWindowHandle();
			frameworkServices.logMessage("Current window title is : " + windowname + " from new window");
			atuReports.passResults1("Current window title is :  ", "", "Window title Should be Captured as"
					+ windowname, "Window title is Captured as" + windowname);
			return windowname;

		} catch (Exception exception) {
			atuReports.failResults("failed to  capture current window Title on " + pageName, "--",
					"Window Title Should be Captured", "Window Title is not Captured");
			throw new UnsuccessfulServiceException("failed to  capture current window Title on " + pageName + "' ",
					exception);
		}

	}

	/*
	 * protected String switchToWindow(){ String windowname = null;
	 * 
	 * try {
	 * 
	 * driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);
	 * 
	 * Set<String> WindowHandles=driver.getWindowHandles(); Iterator<String>
	 * LoopIterator = WindowHandles.iterator(); while (LoopIterator.hasNext()){
	 * //windowname = driver.switchTo().window(LoopIterator.next()).getTitle();
	 * windowname=LoopIterator.next(); } driver.switchTo().window(windowname);
	 * frameworkServices.logMessage("Switched window title is : " + windowname +
	 * " from new window");
	 * atuReports.passResults1("Switched window title is :", "",
	 * "Window Should be Swithced to "+windowname,
	 * "Window is Swithced to "+windowname); //Printing the Switching window
	 * System.out.println("Window Name "+windowname ); return windowname;
	 * 
	 * }catch (Exception exception) {
	 * atuReports.failResults("failed to  switch to window on " + pageName, "",
	 * "Window Should be Swithced ", "Window is not Swithced "); throw new
	 * UnsuccessfulServiceException( "failed to  switch to window on " +
	 * pageName + "' ", exception); }
	 * 
	 * 
	 * }
	 */

	/**
	 * switchToWindow method
	 * 
	 * @return windowname
	 */
	protected String switchToWindow() {
		String windowname = null;

		try {

			driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.SECONDS);

			Set<String> WindowHandles = driver.getWindowHandles();
			Iterator<String> LoopIterator = WindowHandles.iterator();
			while (LoopIterator.hasNext()) {
				// windowname =
				// driver.switchTo().window(LoopIterator.next()).getTitle();
				windowname = LoopIterator.next();
			}
			driver.switchTo().window(windowname);
			frameworkServices.logMessage("Switched window title is : "
					+ driver.switchTo().window(windowname).getTitle() + " from new window");
			atuReports.passResults1("Switched window title is :", "", "Window Should be Swithced to "
					+ driver.switchTo().window(windowname).getTitle(), "Window is Swithced to "
					+ driver.switchTo().window(windowname).getTitle());
			// Printing the Switching window
			System.out.println("Window Name " + driver.switchTo().window(windowname).getTitle());
			return windowname;

		} catch (Exception exception) {
			atuReports.failResults("failed to  switch to window on " + pageName, "", "Window Should be Swithced ",
					"Window is not Swithced ");
			throw new UnsuccessfulServiceException("failed to  switch to window on " + pageName + "' ", exception);
		}

	}

	/**
	 * sliderJSexecutor method
	 * 
	 * @param attributeIdentifier
	 * @param attributeName
	 * @param value
	 */
	protected void sliderJSexecutor(String attributeIdentifier, String attributeName, String value) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.getElementById('theSlider').setAttribute(attributeName,value)");
			js.executeScript("document.getElementById('" + attributeIdentifier + "').setAttribute('" + attributeName
					+ "','" + value + "')");
			frameworkServices.logMessage("Slider Element Move to the value : " + value);
			atuReports.passResults1("Slider Element Moves:", "", "Slider Should move to the Value " + value,
					"Slider is move to the Value " + value);

		} catch (Exception exception) {
			atuReports.failResults("Slider Element Moves:", "", "Slider Should move to the Value " + value,
					"Slider is not moved to the Value " + value);
			throw new UnsuccessfulServiceException("failed to  move the slider of id " + attributeIdentifier + " in"
					+ pageName + "' ", exception);
		}

	}

	/**
	 * dropdownJSexecutor method
	 * 
	 * @param attributeName
	 * @param value
	 */
	protected void dropdownJSexecutor(String attributeName, String value) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("document.getElementById('selNoTradeline').value='value';");
			js.executeScript("document.getElementById('" + attributeName + "').value='" + value + "';");
			frameworkServices.logMessage("dropdown selection : " + value);
			atuReports.passResults1("dropdown item selection", "", "dropdown item should select the value as " + value,
					"dropdown item is selected the value as " + value);

		} catch (Exception exception) {
			atuReports.failResults("dropdown item selection", "", "dropdown item should select the value as " + value,
					"dropdown item is not selected the value as " + value);
			throw new UnsuccessfulServiceException("failed to  select the dropdown id  " + attributeName + " in "
					+ pageName + "' ", exception);
		}

	}

	/**
	 * verifyTableCellData method
	 * 
	 * @param pageElement
	 * @param value
	 * @return Actualvalue
	 */
	protected String verifyTableCellData(PageElement pageElement, String value) {
		boolean flag = false;
		String Actualvalue = null;
		try {

			List<WebElement> rows = (getWebElement(pageElement)).findElements(By.tagName("tr"));
			for (int nrowLoop = 1; nrowLoop <= rows.size(); nrowLoop++) {
				List<WebElement> cols = rows.get(nrowLoop).findElements(By.tagName("td"));
				for (int nColumnLoop = 1; nColumnLoop <= cols.size(); nColumnLoop++) {
					if (cols.get(nColumnLoop).getText().equals(value)) {
						frameworkServices.logMessage("Value is compleared in the table: "
								+ cols.get(nColumnLoop).getText());
						atuReports.passResults1("Value is compleared in the table:", value, value, cols
								.get(nColumnLoop).getText());
						flag = true;
						Actualvalue = cols.get(nColumnLoop).getText();
						break;
					}
				}
				if (flag == true) {
					break;

				}
			}

		} catch (Exception exception) {
			atuReports.failResults("Failed to compare the table text: " + "on :" + pageName, value, value, Actualvalue);
			throw new UnsuccessfulServiceException("Failed to compare the table text: '" + " on : '" + pageName + "' ",
					exception);

		}
		return Actualvalue;
	}

	/**
	 * Close method
	 */
	protected void Close() {
		try {
			driver.close();
			atuReports.passResults1("Browser Close Operation ", "--", " Browser Should be closed", "Browser is closed");
		} catch (Exception exception) {
			atuReports.failResults("Browser Close Operation ", "--", " Browser Should be closed",
					"Browser is not closed");
			throw new UnsuccessfulServiceException("failed to  close the Browser " + pageName + "' ", exception);
		}

	}

	/**
	 * doubleClick method
	 * 
	 * @param pageElement
	 */
	protected void doubleClick(PageElement pageElement) {
		try {

			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			Actions actionBuilder = new Actions(driver);
			actionBuilder.doubleClick(webElement).build().perform();
			frameworkServices.logMessage("Double Clicked on: " + pageElement.getName());
			atuReports.passResults1("Double Clicked on: " + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Double Clicked ", pageElement.getName() + " is Double Clicked ");
		} catch (Exception exception) {
			atuReports.failResults("Failed to doubleclick: '" + "' on " + pageElement.getName() + " on : '" + pageName,
					"--", pageElement.getName() + " Should be Double Clicked ", pageElement.getName()
							+ " is not Double Clicked ");
			throw new UnsuccessfulServiceException("Failed to doubleclick: '" + "' on " + pageElement.getName()
					+ " on : '" + pageName + "' ", exception);
		}
	}

	/**
	 * getText method
	 * 
	 * @param pageElement
	 * @return text
	 */
	protected String getText(PageElement pageElement) {
		String text = new String();
		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();

			text = webElement.getText().trim();
			frameworkServices.logMessage("Fetched text: " + text + " of " + pageElement.getName());
			atuReports.passResults1("Fetched text:  of " + pageElement.getName(), "", "text Should be Captured as "
					+ text, "text is Captured as " + text);
		} catch (Exception exception) {
			atuReports.failResults("Failed to fetch text: " + " of " + pageElement.getName() + " on : '" + pageName,
					"--", "text Should be Captured as " + text, "text is not Captured as " + text);
			throw new UnsuccessfulServiceException("Failed to fetch text: '" + "' of " + pageElement.getName()
					+ " on : '" + pageName + "' ", exception);

		}
		return text;
	}
	
	
	//*******************************
	
	/**
	 * VerifyText method
	 * 
	 * @param pageElement
	 * @return text
	 */
	protected void verifyText(PageElement pageElement,String value, String attributuName) {
		String text = new String();
		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			

			text = webElement.getAttribute(attributuName).trim();
			//text.contains(value)
			//text.equalsIgnoreCase(value)
			if(text.equalsIgnoreCase(value)){
				frameworkServices.logMessage("Verified text Successfully  : " + value + " of " + pageElement.getName());
				atuReports.passResults1("Verified text:  of " + pageElement.getName(), "", "text Should be verified as "
						+ value, "text is Captured as " + text);
			}else{
				frameworkServices.logMessage("Failed to Verify text : " + value + " of " + pageElement.getName());
				atuReports.failResults("Fails to Verify text: " + " of " + pageElement.getName() + " on : '" + pageName,
						"--", "text Should be Captured as " + value, "text is  Captured as " + text);
					
				}
				
		} catch (Exception exception) {
			frameworkServices.logMessage("Failed to Verify text : " + value + " of " + pageElement.getName());
			atuReports.failResults("Fails to Verify text: " + " of " + pageElement.getName() + " on : '" + pageName,
					"--", "text Should be Captured as " + value, "text is  Captured as " + text);
			throw new UnsuccessfulServiceException("Failed to verify text: '" + "' of " + pageElement.getName()
					+ " on : '" + pageName + "' ", exception);

		}
		
	}
	
	//*************************************
	
	

	/**
	 * getAttribute method
	 * 
	 * @param pageElement
	 * @param attributeName
	 * @return attributeValue
	 */
	protected String getAttribute(PageElement pageElement, String attributeName) {
		String attributeValue = new String();
		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();

			attributeValue = webElement.getAttribute(attributeName).trim();
			frameworkServices.logMessage("Fetched " + attributeName + ":" + attributeValue + " of "
					+ pageElement.getName());
			atuReports.passResults1("Fetched " + attributeName + ": of " + pageElement.getName(), "",
					"Attribute Value Should be Captured as " + attributeValue, "Attribute Value is Captured as "
							+ attributeValue);

		} catch (Exception exception) {
			atuReports.failResults("Failed to fetch '" + attributeName + "' of " + pageElement.getName() + " on : '"
					+ pageName, "--", attributeName + "Attribute Should be Captured", attributeName
					+ " Attribute is not Captured");
			throw new UnsuccessfulServiceException("Failed to fetch '" + attributeName + "' of "
					+ pageElement.getName() + " on : '" + pageName + "' ", exception);

		}
		return attributeValue;
	}

	/**
	 * isElementDisplayed method
	 * 
	 * @param pageElement
	 * @return
	 */
	protected boolean isElementDisplayed(PageElement pageElement) {

		boolean isElementDisplayed = false;

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			isElementDisplayed = webElement.isDisplayed();
			frameworkServices.logMessage(pageElement.getName() + " is Displayed ");
			atuReports.passResults1("Element Display" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Displayed ", pageElement.getName() + " is Displayed ");
		} catch (Exception e) {
			atuReports.failResults("Element Display" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Displayed ", pageElement.getName() + " is not Displayed ");
			frameworkServices.logMessage(pageElement.getName() + " is not Displayed ");
		}
		return isElementDisplayed;

	}

	/**
	 * isElementSelected method
	 * 
	 * @param pageElement
	 * @return isElementDisplayed
	 */
	protected boolean isElementSelected(PageElement pageElement) {

		boolean isElementDisplayed = false;

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			isElementDisplayed = webElement.isSelected();
			frameworkServices.logMessage(pageElement.getName() + " is Displayed ");
			atuReports.passResults1("Element Selection" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Selected ", pageElement.getName() + " is  Selected ");
		} catch (Exception e) {
			atuReports.failResults("Element Selection" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Selected ", pageElement.getName() + " is not Selected ");
			frameworkServices.logMessage(pageElement.getName() + " is not Displayed ");
		}
		return isElementDisplayed;

	}

	/**
	 * isElementEnabled method
	 * 
	 * @param pageElement
	 * @return isElementEnabled
	 */
	protected boolean isElementEnabled(PageElement pageElement) {

		boolean isElementEnabled = false;

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			isElementEnabled = webElement.isEnabled();
			frameworkServices.logMessage(pageElement.getName() + " is Enabled ");
			atuReports.passResults1("Element Enabled Property" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Enabled ", pageElement.getName() + " is  Enabled ");
		} catch (Exception e) {
			atuReports.failResults("Element Enabled Property" + pageElement.getName(), "--", pageElement.getName()
					+ " Should be Enabled ", pageElement.getName() + " is not Enabled ");
			frameworkServices.logMessage(pageElement.getName() + " is not Enabled ");
		}
		return isElementEnabled;

	}

	/**
	 * selectValueFromList method
	 * 
	 * @param pageElement
	 * @param value
	 */
	protected void selectValueFromList(PageElement pageElement, String value) {
		try {

			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			Select select = new Select(webElement);
			select.selectByVisibleText(value);
			frameworkServices.logMessage("Selected Value: " + value + "' in " + pageElement.getName());
			atuReports.passResults1("Selected Value From List in" + pageElement.getName(), "--", value, value);
		} catch (Exception exception) {
			atuReports.failResults("Failed to Select value From the List : of " + pageElement.getName() + " on : '"
					+ pageName, "--", value, "--");
			throw new UnsuccessfulServiceException("Failed to Select value: '" + value + "' of "
					+ pageElement.getName() + " on : '" + pageName + "'", exception);
		}
	}

	/**
	 * mouseOver method
	 * 
	 * @param pageElement
	 */
	protected void mouseOver(PageElement pageElement) {
		try {

			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();

			Actions actionBuilder = new Actions(driver);
			actionBuilder.moveToElement(webElement).build().perform();
			atuReports.passResults1("Hoverd mouse on: " + pageElement.getName(), "--", "Hoverd mouse should be on: "
					+ pageElement.getName(), "Hoverd mouse is on: " + pageElement.getName());
			frameworkServices.logMessage("Hoverd mouse on: " + pageElement.getName());
		} catch (Exception exception) {
			atuReports.failResults("Hoverd mouse on: " + pageElement.getName(), "--", "Hoverd mouse should be on: "
					+ pageElement.getName(), "Hoverd mouse is not on: " + pageElement.getName());
			throw new UnsuccessfulServiceException("Failed to hover mouse: '" + "' on " + pageElement.getName()
					+ " on : '" + pageName + "' ", exception);
		}
	}

	/**
	 * getSelectedValueFromList method
	 * 
	 * @param pageElement
	 * @return selectedValue
	 */
	protected String getSelectedValueFromList(PageElement pageElement) {

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();

			Select selectType = new Select(webElement);
			String selectedValue = selectType.getFirstSelectedOption().getText();
			atuReports.passResults1("Fethced value from List Box of  " + pageElement.getName(), "--", selectedValue,
					selectedValue);
			frameworkServices.logMessage("Fetched " + selectedValue + "  " + " of " + pageElement.getName());
			return selectedValue;
		} catch (Exception exception) {
			atuReports.failResults("Failes Fetch value from List Box of  " + pageElement.getName(), "--",
					"Value Should be Fetched", "Value is not Fetched");
			throw new UnsuccessfulServiceException("Failed to fetch " + "Selected Value" + "' of "
					+ pageElement.getName() + " on : '" + pageName + "' ", exception);
		}
	}

	/**
	 * getAllOptionsInList method
	 * 
	 * @param pageElement
	 * @return optionList
	 */
	protected ArrayList<String> getAllOptionsInList(PageElement pageElement) {

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();
			Select selectList = new Select(webElement);
			ArrayList<String> optionList = new ArrayList<String>();
			for (WebElement option : selectList.getOptions()) {
				optionList.add(option.getText().trim());
			}
			atuReports.passResults1("Fetched Options List of   " + pageElement.getName(), "--", optionList.toString(),
					optionList.toString());
			frameworkServices.logMessage("Fetched " + optionList + "  " + " of " + pageElement.getName());
			return optionList;
		} catch (Exception exception) {
			atuReports.failResults("Failes Fetch Options List of  " + pageElement.getName(), "--",
					"Values Should be Fetched", "Values are not Fetched");
			throw new UnsuccessfulServiceException("Failed to fetch " + "option Value" + "' of "
					+ pageElement.getName() + " on : '" + pageName + "' ", exception);
		}
	}
 
	/**
	 * bringElementInView method
	 * 
	 * @param pageElement
	 */
	protected void bringElementInView(PageElement pageElement) {

		try {
			WebElement webElement;
			if (!isWebElementAvailablesInPageElement(pageElement))
				webElement = getWebElement(pageElement);
			else
				webElement = pageElement.getWebElement();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
			atuReports.passResults1("Bringing the Element current browser view ", "--", pageElement.getName() + "  "
					+ "Element Should  brought to current browser view ", pageElement.getName()
					+ "Element brought into the  current browser view ");
			frameworkServices.logMessage("Brought  " + pageElement.getName() + "  " + " in the current browser view ");

		} catch (Exception exception) {
			atuReports.failResults("Bringing the Element current browser view ", "--", pageElement.getName() + "  "
					+ "Element Should  brought to current browser view ", pageElement.getName()
					+ "Element failes to brought into the  current browser view ");
			throw new UnsuccessfulServiceException("Failed to bring Element  " + pageElement.getName() + "  "
					+ " in the current browser view " + " on : '" + pageName + "' ", exception);
		}

	}

}
