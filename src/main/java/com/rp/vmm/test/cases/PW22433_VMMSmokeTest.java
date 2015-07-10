package com.rp.vmm.test.cases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;

import com.rp.automation.framework.ExcelService;
import com.rp.automation.framework.WaitType;
import com.rp.automation.framework.WebDriverBase;
import com.rp.automation.framework.atuReports;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;




//Import the related Page Classes
import com.rp.pw.pages.LoginPage;
import com.rp.vmm.pages.Vmm_ContactsPage;
import com.rp.vmm.pages.Vmm_Loginpage;



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


public class PW22433_VMMSmokeTest extends WebDriverBase{
	
    @DataProvider(name="DataProvider")   
    public Iterator<Object[]> dataprovider(){
       return new ExcelService().readTestDataFromExcel(WebDriverBase._prop.getString("PWWorkBook"),"VMMSmoke_Test");
    }

    @Test(dataProvider ="DataProvider", groups = {"VMMTestGroup"})

    public void vvmSmokeTest(Map<String,String> data){
    	 
    	System.out.println("*********Begining of VMM Smoke Test Case**********************");
    	//Updating the Author Information in Atu Reports
    	atuReports.setAuthorInfoForReports();
    	//Opening the Browser
        WebDriver driver = getDriver();
        //Navigating to PW Login page
        driver.get(WebDriverBase._prop.getString("VMMSitUrl"));
        Vmm_Loginpage VmmSmokeTest = new Vmm_Loginpage(driver);
        //Entering the Login Details
        VmmSmokeTest.VMMLogin(data);
        //Assining the Driver to Dash Board Page
        Vmm_ContactsPage VmmSmokeTest1 = new Vmm_ContactsPage(driver);
        //Creating Project
        //VmmSmokeTest1.ProjectsCreation(data);
        //Verifying the Contact Verification
        VmmSmokeTest1.ContactsVerification(data);
        
       System.out.println("********End of the VMM Smoke Test Case***********************");
    }

}
