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

public class Vmm_Loginpage extends Page {
	
	 
    public Vmm_Loginpage(WebDriver driver) {
        super(driver, Vmm_Loginpage.class.getSimpleName());
    }
    
    //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
    //UserName Field
    private PageElement UserName() {
    	return new PageElement(By.xpath("//input[@id='user_email']"), "UserName Field");
    	
    }

    //PassWord Field
    private PageElement PassWord() {
    	return new PageElement(By.xpath("//input[@id='user_password']"), "PassWord Field");
    	
    }
    
    //Sign In Link
    private PageElement SignInButton() {
    	return new PageElement(By.xpath("//input[@class='btn btn-primary']"), "Sign In Button");
    	
    }
    
    //Projects Field
    private PageElement ProjectsElement() {
    	return new PageElement(By.xpath("//span[contains(text(),'Projects')]"), "Projects  Options");
    	
    }
    
    private WebElement ProjectElementDisplay(){
    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(ProjectsElement()),300);
    }
    
   /* private void setCredentials(){
    	WaitType Wait = WaitType.WAIT_FOR_ELEMENT_TO_BE_CLICKABLE;
    	PageElement.this.setWaitType(Wait);
    }*/
     
  //************************End of the Declaration of Pageelements and Webelements******************//
    
  //************************Operation of the Elements***********************************************//
  //VMM Login Operation
    public void VMMLogin(Map<String, String> data) {
    	driverManage();
    	sendKeys(UserName(),data.get("EmailId"));
    	sendKeys(PassWord(),data.get("PassWord"));
    	click(SignInButton());
    	ProjectElementDisplay();
    }
    
        
    
    
    
  //************************************End of the Operations of Elements*****************************************************//      
}