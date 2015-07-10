package com.rp.pw.pages.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;

/**
 * AdministrativeSetup class
 * 
 * @author MHarsh
 *
 */
public class AdministrativeSetup extends Page {

	/**
	 * AdministrativeSetup method, class constructor
	 * 
	 * @param driver
	 */
	public AdministrativeSetup(WebDriver driver) {
		super(driver, AdministrativeSetup.class.getSimpleName());
	}

	/* Page element declarations */

	/**
	 * getAdministrativeSetupLink method
	 * 
	 * @return Administrative Setup Link
	 */
	private PageElement getAdministrativeSetupLink() {
		return new PageElement(
				By.xpath("//div[@id='sideMenu']//div[text()='Administration Setup']/preceding::div[1]"),
				"Administrative Setup Link");
	}

	/**
	 * getCompanyInfoLink method
	 * 
	 * @return Company Info Link
	 */
	private PageElement getCompanyInfoLink() {
		return new PageElement(
				By.xpath("//div[@id='sideMenu']//a[text()='Company Info']"),
				"Company Info Link");
	}

	/**
	 * getEditButton method
	 * 
	 * @return Edit Button
	 */
	private PageElement getEditButton() {
		return new PageElement(By.xpath("//input[@value='Edit']"),
				"Edit Button");
	}

	/* Business Logic */

	/**
	 * navAdministrativeSetupLink method, navigates Administrative Setup Link
	 */
	public void navAdministrativeSetupLink() {
		click(getAdministrativeSetupLink());
		webDriverHelper.explicitWait(5);
	}

	/**
	 * navCompanyInfoLink method, navigates Company Info Link
	 */
	public void navCompanyInfoLink() {
		click(getCompanyInfoLink());
		webDriverHelper.explicitWait(5);
	}

	/**
	 * clickEditButton method, clicks Edit Button
	 */
	public void clickEditButton() {
		click(getEditButton());
		webDriverHelper.explicitWait(5);
	}

	/**
	 * selectManagementCompanyListBoxToYes method, selects Management Company
	 * List Box To Yes. No need for getter.
	 */
	public void selectManagementCompanyListBoxToYes() {
		Select dropdown = new Select(driver.findElement(By
				.id("//select[@id='mgmtCompany']")));
		dropdown.selectByValue("Yes");
		webDriverHelper.explicitWait(5);
	}

}
