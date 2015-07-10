package com.rp.vmm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;
import com.rp.automation.framework.WaitType;
import com.rp.automation.framework.WebDriverHelper;
import com.rp.automation.framework.atuReports;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/*
@ Description:		
@ 					
@ 					
@ 					
@ Created By:		Gkoppuravuri
@ Created On:		04/14/2015
@ Modified By:	
@ Modified On:		
@ Modifications:	
@ Reviewed By:		
@ Reviewed On:
@ Review Comments :			
*/

public class Pw_Loginpage extends Page {
	
	 
    public Pw_Loginpage(WebDriver driver) {
        super(driver, Pw_Loginpage.class.getSimpleName());
    }
    
    //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
    //UserName Field
    private PageElement UserName() {
    	return new PageElement(By.xpath("//input[@name='email']"), "UserName Field");
    	
    }

    //PassWord Field
    private PageElement PassWord() {
    	return new PageElement(By.xpath("//input[@name='password']"), "PassWord Field");
    	
    }
    
    //Sign In Link
    private PageElement SignInButton() {
    	return new PageElement(By.xpath("//input[@value='Sign Me In']"), "Sign In Button");
    	
    }
    
    //Desktop Element
    private PageElement DesktopElement() {
    	return new PageElement(By.xpath("//a[contains(text(),'Desktop')]"), "Desktop Element");
    	
    }
    
    private WebElement DesktopElementDisplay(){
    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(DesktopElement()),300);
    }
    
   /* private void setCredentials(){
    	WaitType Wait = WaitType.WAIT_FOR_ELEMENT_TO_BE_CLICKABLE;
    	PageElement.this.setWaitType(Wait);
    }*/
     
  //************************End of the Declaration of Pageelements and Webelements******************//
    
  //************************Operation of the Elements***********************************************//
  //PW Login Operation
    public void VMMLogin(Map<String, String> data) {
    	driverManage();
    	sendKeys(UserName(),data.get("PWUserId"));
    	sendKeys(PassWord(),data.get("PwPassword"));
    	click(SignInButton());
    	DesktopElementDisplay();
    }
    
        
    
    
    
  //************************************End of the Operations of Elements*****************************************************//      
}