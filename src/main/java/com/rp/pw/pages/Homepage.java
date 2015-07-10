package com.rp.pw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;
import com.rp.automation.framework.atuReports;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description:		This class has the Declaration & Operation of the Page & Web Elements on PW Main/Home Page 
 * Created By:		LKomma
 * Created On:		12/08/2014
 * Modified By:		NA
 * Modified On:		NA
 * Modifications:	NA
 * Reviewed By:		TBD
 * Reviewed On:		NA
 */

public class Homepage extends Page {

    public Homepage(WebDriver driver) {
        super(driver, Homepage.class.getSimpleName());
    }
    
    //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
    //Desktop Link
    private PageElement desktopLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Desktop')]"), "Desktop Link");
    	
    }

    //Dashboards Link
    private PageElement dashboardsLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Dashboards')]"), "Dashboards Link");
    	
    }
    
    //Properties Link
    private PageElement propertiesLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Properties')]"), "Properties Link");
    	
    }
    
    //Marketing Link
    private PageElement marketingLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Marketing')]"), "Marketing Link");
    	
    }
    
    //Leases Link
    private PageElement leasesLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Leases')]"), "Leases Link");
    	
    }
    
    //Contacts Link
    private PageElement contactsLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Contacts')]"), "Contacts Link");
    	
    }
    
    //Money In Link
    private PageElement moneyInLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Money In')]"), "Money In Link");
    	
    }
    
    //Money Out Link
    private PageElement moneyOutLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Money Out')]"), "Money Out Link");
    	
    }
    
    //Banking Link
    private PageElement bankingLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Banking')]"), "Banking Link");
    	
    }
    
    //Maintenance Link
    private PageElement maintenanceLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Maintenance')]"), "Maintenance Link");
    	
    }
    
    //Inspections Link
    private PageElement inspectionsLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Inspections')]"), "Inspections Link");
    	
    }
    
    //Management Link
    private PageElement managementLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Management')]"), "Management Link");
    	
    }
    
    //Sites Link
    private PageElement sitesLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Sites')]"), "Sites Link");
    	
    }
    
    //Portals Link
    private PageElement portalsLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Portals')]"), "Portals Link");
    	
    }
    
    //Reports Link
    private PageElement reportsLink() {
    	return new PageElement(By.xpath("//div[@id='appHeader']/ul/li/a[contains(text(),'Reports')]"), "Reports Link");
    	
    }
 
    //Setup Link
    private PageElement setUpLink() {
    	return new PageElement(By.xpath("//div[@id='appHeaderLinksContainer']/a/span[contains(text(), 'Setup')]"), "Setup Link");
    	
    }
    
    //Help Link
    private PageElement helpLink() {
    	return new PageElement(By.xpath("//div[@class='pageHelp']"), "Help Link");
    	
    }
     
  //************************End of the Declaration of Pageelements and Webelements******************//
    
  //************************Operation of the Elements***********************************************//
  //Navigating through the modules in PW
    public void GotoDashboards() {
    	click(dashboardsLink());    	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoProperties() {
    	click(propertiesLink());   	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoMarketing() {
    	click(marketingLink());   	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoLeases() {
    	click(leasesLink());
    	webDriverHelper.explicitWait(5);
    }
    
    public void GotoContacts() {
    	click(contactsLink());   	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoMoneyIn() {
    	click(moneyInLink());	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoMoneyOut() {
    	click(moneyOutLink());	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoBanking() {
    	click(bankingLink());  	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoMaintenance() {
    	click(maintenanceLink());  	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoInspections() {
    	click(inspectionsLink());   	
        webDriverHelper.explicitWait(5);
    }

    public void GotoManagement() {
    	click(managementLink());
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoSites() {
    	click(sitesLink());	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoPortals() {
    	click(portalsLink());  	
    	webDriverHelper.explicitWait(5);
    }

    public void GotoReports() {
    	click(reportsLink());    	
        webDriverHelper.explicitWait(5);
    }
    
    public void GotoDesktop() {
    	click(desktopLink());   	
        webDriverHelper.explicitWait(5);
    }
 
    public void GotoSetup(){
    	boolean checkSetup = isElementDisplayed(setUpLink());
    	if(checkSetup) {
    		click(setUpLink());
            webDriverHelper.explicitWait(5);
    	}
    }
    
    public void VerifyHelp(){
    	isElementDisplayed(helpLink());
    }
    
    
    public void navigateToModules(){  	
    	System.out.println("*****Start - Navigate To All Modules******** ");   	
    	//PW_Homepage NavigateModules = new PW_Homepage(driver); 

        //Verify if the user is able to navigate through all the modules
        GotoDashboards();
        GotoProperties();
        GotoMarketing();
        GotoLeases();
        GotoContacts();
        GotoMoneyIn();
        GotoMoneyOut();
        GotoBanking();
        GotoMaintenance();
        GotoInspections();
        GotoManagement();
        GotoSites();
        GotoPortals();
        GotoReports();
        GotoSetup();
        GotoDesktop();
        //Verify if Help link is displayed
    	VerifyHelp();        
        System.out.println("*****End - Navigate To All Modules******** ");         
    }
    
    
  //************************************End of the Operations of Elements*****************************************************//      
}