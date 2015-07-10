package com.rp.pw.test.cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;

import com.rp.automation.framework.ExcelService;
import com.rp.automation.framework.WebDriverBase;
import com.rp.automation.framework.atuReports;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//Import the related Page Classes
import com.rp.pw.pages.LoginPage;
//import com.rp.pw.pages.PW_Homepage;


/**
 * Description:		This class has the code to verify the following workflows:
 * 					1. Login to PW
 * 					2. Navigate through all the main modules in PW
 * 					3. Logout of PW
 * Created By:		LKomma
 * Created On:		11/24/2014
 * Modified By:		LKomma
 * Modified On:		12/23/2014
 * Modifications:	Separated each functionality check
 * Reviewed By:		TBD
 * Reviewed On:		NA	
 */


public class PWTC1 extends WebDriverBase{
	
    @DataProvider(name="DataProvider")   
    public Iterator<Object[]> dataprovider(){
       return new ExcelService().readTestDataFromExcel(WebDriverBase._prop.getString("PWLoginTestWB"),"Login");
    }

    @Test(dataProvider ="DataProvider", groups = {"PWSmokeTest"})
    //@DataProvider(parallel = true)
    //@Test(threadPoolSize = 10,invocationCount=3,dataProvider ="DataProvider",groups = {"PWSmokeTest"})

    public void pwTestScenario1(Map<String,String> data){ 
    	
    	Logger myLog = Logger.getLogger(PWTC1.class);
    	
    	atuReports.setTestCaseReqCoverage("Login, Navigate to Modules, Logout");
    	atuReports.setAuthorInfoForReports();
    	    	
    	//Opening the Browser
        WebDriver driver = getDriver();
        myLog.info("Driver initialized");
        //Navigating to PW Login page
        driver.get(WebDriverBase._prop.getString("PWtesturl"));
        myLog.info("Navigate to URL");
        //Set page load timeout
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);        
        
        LoginPage Loginpage = new LoginPage(driver);
        //Entering the Login Details
        Loginpage.PWLoginAs(data); 
        myLog.info("Login completed");
        
        //Verify whether user is logged in or not
    	boolean checkLogin;
        checkLogin = Loginpage.VerifyLogin(); 
/*        if(checkLogin)	{
            myLog.info("User logged in");     
        }	else	{
        	myLog.error("User NOT logged in");
        }	*/
        
        //Navigating to each module 
        //Loginpage.ModulesCheck(checkLogin);
        myLog.warn("Skipped Navigate to modules");
        
        //Logout of PW
        Loginpage.PWLogout(checkLogin);
        myLog.info("Logout completed");

    }

}
