package com.rp.pw.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import atu.testng.reports.ATUReports;

import com.rp.automation.framework.Page;
import com.rp.automation.framework.PageElement;
import com.rp.automation.framework.WebDriverHelper;
import com.rp.automation.framework.atuReports;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.rp.pw.pages.Homepage;
import com.rp.pw.test.cases.PWTC1;

/**
 * Description:		This class has the Declaration & Operation of the Page & Web Elements on PW Login Page 
 * Created By:		LKomma
 * Created On:		11/24/2014
 * Modified By:		LKomma
 * Modified On:		12/23/2014
 * Modifications:	Separated each functionalities based on successful Login
 * Reviewed By:		TBD
 * Reviewed On:		NA
 */
public class LoginPage extends Page {

	/**
	 * LoginPage method, class constructor
	 * 
	 * @param driver
	 */
    public LoginPage(WebDriver driver) {
        super(driver, LoginPage.class.getSimpleName());
    }
    
    //Initiating Logger
    Logger loginpageLog = Logger.getLogger(LoginPage.class);
    
    
    //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
    //Email Field
    private PageElement emailTextBox() {
    	return new PageElement(By.xpath("//input[@name='email']"), "PW Login Email");
    	
    }
    
    //Password Field
    private PageElement passwordTextBox() {
    	return new PageElement(By.xpath("//input[@name='password']"), "PW Login Password");
    	
    }  
    
    //Sign Me In Button
    private PageElement signMeInButton() {
    	return new PageElement(By.xpath("//input[@value='Sign Me In']"), "PW Login Button");
    	
    } 
    
    //Logout Button  
    private PageElement logoutButton() {
    	//return new PageElement(By.xpath("//div[@id='appHeaderLinksContainer']/a/span[contains(text(), 'Logout')]"), "PW Logout Button");
    	return new PageElement(By.xpath("//a/span[contains(text(),'Logout')]"), "PW Logout Button");
    }    
    
    
    
  //Wait for WebElements on the page
    public WebElement waitForsignMeInButton() {
    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(signMeInButton()), 50000);
    }
    
    public WebElement waitForLogoutButton() {
    	//waitForPageElement(logoutButton());
    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(logoutButton()), 50000);    	
    	//return webDriverHelper.waitForElementToBeClickable(getWebElement(logoutButton()), 50000);
    }
    
    public WebElement waitForEmailTextBox() {    	
    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(emailTextBox()), 50000);
    }
    
  //************************End of the Declaration of Page elements and Web elements******************//
    
  //************************Operation of the Elements***********************************************//
  //Entering the User Name and Password
    public void PWLoginAs(Map<String, String> data) {
    	System.out.println("*****Start - PW Login********");  
    	loginpageLog.info("*****Start - PW Login********");
    	//Window Maximize
    	driverManage();
    	//Wait for page to load      	
    	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);  	 
        webDriverHelper.explicitWait(5);
    	//waitForEmailTextBox();
        boolean checkLoginPage = false;
        checkLoginPage = VerifyLoginPage();
        System.out.println("check login page value: " +checkLoginPage);
        loginpageLog.info("check login page value: " +checkLoginPage);
        if(checkLoginPage == true)	{       	
        	//Click on emailTextBox
        	click(emailTextBox());
        	//Entering Login Email
        	sendKeys(emailTextBox(), data.get("Username"));
        	//Entering Login Password
        	sendKeys(passwordTextBox(), data.get("Password"));
        	//Clicking on Sign Me In Button
        	click(signMeInButton());
        	//Wait for login to complete
        	webDriverHelper.explicitWait(10);
        }
    	System.out.println("*****End - PW Login********"); 
        loginpageLog.info("*****End - PW Login********");    	
    }
   
    
    //Verify if the Login page is displayed
    public boolean VerifyLoginPage() {
    	if(isElementDisplayed(signMeInButton()) == true)	{
    		System.out.println("PW Login page is displayed");
            loginpageLog.info("PW Login page is displayed");    		
    	} else {
    		System.out.println("PW Login page is NOT displayed");
            loginpageLog.error("PW Login page is NOT displayed");
    		atuReports.failResults("Verification of Login Page", "", "PW Login page should be displayed", "PW Login page is NOT displayed");    		
    	}    	
		return isElementDisplayed(signMeInButton());
	}
    
    //Verify if Login is successful
    public boolean VerifyLogin() {
    	//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //waitForLogoutButton();
    	//webDriverHelper.explicitWait(10);
    	
    	//Check for Logout link
    	if(isElementDisplayed(logoutButton()) == true)	{
    		System.out.println("User is logged into the application");
            loginpageLog.info("User is logged into the application");
    	} else {
    		System.out.println("User is NOT logged into the application");
            loginpageLog.error("User is NOT logged into the application");
    		atuReports.failResults("Verification of User Login", "", "User should be logged in", "User is currently NOT logged in");    		
    	}
    	return isElementDisplayed(logoutButton());
	}    
    
    
    //Loginpage.waitForLogoutButton();
    public void ModulesCheck(boolean checkLogin){
    	//System.out.println("check login value: " +checkLogin );
    	System.out.println("*****Start - Modules Check********"); 
        loginpageLog.info("*****Start - Modules Check********");    	
        if(checkLogin==true)	{
            Homepage NavigateModules = new Homepage(driver);
            NavigateModules.navigateToModules();          	      
        }	else	{
        	//closeSession();
        	System.out.println("Navigate to Modules did NOT execute because User is currently NOT logged in");
            loginpageLog.warn("Navigate to Modules did NOT execute because User is currently NOT logged in");        	
        	atuReports.failResults("Navigate to Modules", "Verify Login", "User should be logged in", "User is currently NOT logged in");
        }
    	System.out.println("*****End - Modules Check********"); 
        loginpageLog.info("*****End - Modules Check********");      	
    }
    
    
    //Logout from Application
    public void PWLogout(boolean checkLogin) {	
    	System.out.println("*****Start - PW Logout********"); 
        loginpageLog.info("*****Start - PW Logout********");      	
    	System.out.println("check login value: " +checkLogin);
        loginpageLog.info("check login value: " +checkLogin);      	
    	if(checkLogin == true)	{
    		System.out.println("Logout link is displayed");
            loginpageLog.info("Logout link is displayed");  
    		click(logoutButton());
    		//waitForsignMeInButton();
    		webDriverHelper.explicitWait(10);
    		
        	boolean checkLogout;
        	checkLogout = VerifyLoginPage();
        	if(checkLogout == true)	{
        		System.out.println("User successfully logged out of the application");
                loginpageLog.info("User successfully logged out of the application");  
        	} else {
        		System.out.println("User is NOT able to logout of the application");
                loginpageLog.error("User is NOT able to logout of the application");  
        		atuReports.failResults("Verification of Logout", "", "User should be logged out of the application", "User is NOT able to logout of the application");    		
        	}     		
    	} else {
    		System.out.println("Logout link is NOT displayed");
            loginpageLog.warn("Logout link is NOT displayed");  
        	atuReports.failResults("Attempting Logout", "", "Logout link should be displayed", "Logout link is NOT displayed");    		
    	}
    	System.out.println("*****End - PW Logout********");  
        loginpageLog.info("*****End - PW Logout********");  
    	atuReports.infoResults("*****End of user session*******");    	
	}
   

	//Closing the browser/session
    public void closeSession(){
    	Close();
    	System.out.println("*****Closed the browser/session********"); 
        loginpageLog.info("*****Closed the browser/session********");  
    	atuReports.infoResults("*****Closed the browser/session********");
    }    

    
  //************************************End of the Operations of Elements*****************************************************//      
}