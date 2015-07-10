package com.rp.vmm.pages;	

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;
import com.rp.automation.framework.WaitType;



/*
 @ Description:		
 @ 					
 @ 					
 @ 					
 @ Created By:		Gkoppuravuri
 @ Created On:		04/13/2015
 @ Modified By:	
 @ Modified On:		
 @ Modifications:	
 @ Reviewed By:		
 @ Reviewed On:
 @ Review Comments :			
 */


public class Vmm_PropertiesPage extends Page {
	
		
	
	 public Vmm_PropertiesPage(WebDriver driver) {
	        super(driver, Vmm_PropertiesPage.class.getSimpleName());
	    }
	 //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
	   
	 
	    //Proprties Button
	    private PageElement PropertiesButton(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Properties')]"),"Properties Button Button");
	    }
	    
	  //Portfolios Tab
	    private PageElement PortfoliosTab(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Portfolios')]"),"Portfolios Tab");
	    }
	    
	  //Buildings Tab
	    private PageElement BuildingsTab(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Buildings')]"),"Buildings Tab");
	    }
	    
	  //Units Tab
	    private PageElement UnitsTab(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Units')]"),"Units Tab");
	    }
	    
	  //Leases Tab
	    private PageElement LeasesTab(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Leases')]"),"Leases Tab");
	    }  
	    
	   //SearchField Option
	    private PageElement SearchField(){
	    	return new PageElement(By.xpath("//input[@ng-model='query.text']"),"SearchField");
	    }
	    
	  //Search Button
	    private PageElement SearchButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Search')]"),"Search Button");
	    } 
	    
	    
	  //Search Button Display  
	    private WebElement SearchDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(SearchButton()),300);
	    }
	    
	  
	    
	  //PortFolioTable Element
	    private PageElement PortFolioTableElement(){
	    	return new PageElement(By.xpath("//div[@class='well well-small']/table/tbody/tr[2]/td[1]"),"Table Element");
	    }
	   
	 //Contacts Table Display  
	    private WebElement PortFolioTableDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(PortFolioTableElement()),4000);
	    } 
	    
	 
	 
	 /***/   
	  //PortFolioTab-PortFolioName
	    private PageElement PortFolioName(){
	    	return new PageElement(By.xpath("//div[contains(text(),'Name')]/div"),"PortFolioName");
	    } 
	    
	  //PortFolio Details Display  
	    private WebElement portFolioDetailsDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(PortFolioName()),4000);
	    } 
	    
	  
	  //PortFolioTab-Abbreviation
	    private PageElement portFolioAbbreviation(){
	    	return new PageElement(By.xpath("//div[contains(text(),'Abbreviation')]/div"),"PortFolio Abbreviation");
	    }
	    
	    //PortFolioTab-OwerName
	    private PageElement portOwnerName(){
	    	return new PageElement(By.xpath("//tr[@ng_repeat='owner in owners']/td[1]"),"Port Folio Owner Name");
	    } 
	    
	  //PortFolioTab-OwnerWorkPhoneNumber
	    private PageElement portOwnerWorkPhone(){
	    	return new PageElement(By.xpath("//tr[@ng_repeat='owner in owners']/td[2]"),"Port Folio Owner Work Phone");
	    } 
	   
	  //PortFolioTab-OwnerHomePhoneNumber
	    private PageElement portOwnerHomePhone(){
	    	return new PageElement(By.xpath("//tr[@ng_repeat='owner in owners']/td[3]"),"Port Folio Owner Home Phone");
	    } 
	    
	  //PortFolioTab-OwnerMobilePhoneNumber
	    private PageElement portOwnerMobilePhone(){
	    	return new PageElement(By.xpath("//tr[@ng_repeat='owner in owners']/td[4]"),"Port Folio Owner Mobile Phone");
	    } 
	    
	   
	  //PortFolioTab-OwnerEmail
	    private PageElement portOwnerEmail(){
	    	return new PageElement(By.xpath("//tr[@ng_repeat='owner in owners']/td[5]"),"Port Folio Owner Email");
	    } 
	    
	    
	  
	  //Close Button
	    private PageElement CloseButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Close')]"),"Close Button");
	    }
	    
	 
	 
	    
	  //************************End of the Declaration of Pageelements and Webelements******************//
	    
	  //************************Operation of the Elements***********************************************//
	 
	   
	    
	    public void PortFolioVerification(Map<String,String> data){
	    	click(PropertiesButton());
	    	webDriverHelper.explicitWait(2);
	    	click(PortfoliosTab());
	    	webDriverHelper.explicitWait(2);
	    	SearchDisplay();
	    	PortFolioTableDisplay();
	    	sendKeys(SearchField(),data.get("PortFolioName"));
	    	click(SearchButton());
	    	webDriverHelper.explicitWait(2);
	    	PortFolioTableDisplay();
	    	click(PortFolioTableElement());
	    	webDriverHelper.explicitWait(2);
	    	portFolioDetailsDisplay();
	    	verifyText(PortFolioName(),data.get("PortFolioName"),"value");
	    	verifyText(portFolioAbbreviation(),data.get("PortFolioAbbrevation"),"value");
	    	verifyText(portOwnerName(),data.get("PortFolioOwnerName"),"value");
	    	verifyText(portOwnerWorkPhone(),data.get("OwnerWorkPhone"),"value");
	    	verifyText(portOwnerHomePhone(),data.get("OwnerPhone"),"value");
	    	verifyText(portOwnerMobilePhone(),data.get("OwnerMobileNo"),"value");
	    	verifyText(portOwnerEmail(),data.get("PortOwnerEmailAddress"),"value");
	    	click(CloseButton());
	    	
	    }
	    
	  
	    
	  //************************************End of the Operations of Elements*****************************************************//      
	} 
	 

