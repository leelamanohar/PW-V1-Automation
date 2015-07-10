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


public class Vmm_ContactsPage extends Page {
	
		
	
	 public Vmm_ContactsPage(WebDriver driver) {
	        super(driver, Vmm_ContactsPage.class.getSimpleName());
	    }
	 //*********************Beginning of the Declaration of the Page elements and Web elements*****************//
	    //Projects Field
	    private PageElement ProjectsElement() {
	    	return new PageElement(By.xpath("//span[contains(text(),'Projects')]"), "Projects  Options");
	    	
	    }

	  //New Projects Button Field
	    private PageElement NewProjectsButton() {
	    	return new PageElement(By.xpath("//a[@class='btn btn-primary']"), "NewProjects  Button");
	    	
	    }
	    
	  //Description Object
	    private PageElement DescriptionObject() {
	    	return new PageElement(By.xpath("//textarea[@id='project_description']"), "Description Field");
	    	
	    } 
	    
	   //Add Change Location
	    private PageElement AddChangeLocation(){
	    	return new PageElement(By.xpath("//div[@class='row-fluid buttons']/div[1]/button"),"AddChange Location");
	    }
	    
	  //SearchField Option
	    private PageElement SearchField(){
	    	return new PageElement(By.xpath("//input[@id='location_query']"),"SearchField");
	    }
	    
	  //Search Button
	    private PageElement SearchButton(){
	    	return new PageElement(By.xpath("//button[@class='btn btn-primary location_search_btn']"),"Search Button");
	    } 
	    
	   //AttachPortfolio Button
	    private PageElement AttachButtonportfolio(){
	    	return new PageElement(By.xpath("//button[@class='btn-mini btn-primary attach_portfolio_row']"),"Attach PortFolio Button");
	    }
	    //Contacts Button
	    private PageElement ContactsButton(){
	    	return new PageElement(By.xpath("//ul[@style='display: block;']/li/a[@href='/a/real-time-property-services/groups/clients/contacts']"),"Contacts Button");
	    }
	    
	  //Contacts Search Button
	    private PageElement ContactsSearchButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Search')]"),"Contacts Search Button");
	    }
	    
	  //Contacts Search Button Display  
	    private WebElement ContactSearchDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(ContactsSearchButton()),300);
	    }
	    
	  //Contact SearchEdit
	    private PageElement ContactsSearchQuery(){
	    	return new PageElement(By.xpath("//input[@ng-model='query.text']"),"Contacts Search Query");
	    }
	    
	  //Contacts Table Last Name
	    private PageElement ContactTable(){
	    	return new PageElement(By.xpath("//td[contains(text(),'LastName')]"),"Table Display Element");
	    }
	   
	  //Contacts Table Display  
	    private WebElement TableDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(ContactTable()),4000);
	    } 
	    
	    
	  //DesiredContact
	    private PageElement DesiredContactButton(){
	    	return new PageElement(By.xpath("//span[@class='icon-white icon-edit']"),"DesiredContact Button");
	    }
	 
	    //**
	  //OwnerFirstName-ContactsModule
	    private PageElement ContOwnerFirstName(){
	    	return new PageElement(By.xpath("//label[text()='First Name *required']/parent::div//input"),"Contact FirstName Field");
	    } 
	    
	  //Contacts Details Display  
	    private WebElement contactDetailsDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(ContOwnerFirstName()),4000);
	    } 
	    
	  
	  //OwnerLastName-ContactsModule
	    private PageElement ContOwnerLastName(){
	    	return new PageElement(By.xpath("//label[text()='Last Name *required']/parent::div//input"),"Contact LastName Field");
	    } 
	    
	    //OwnerPhoneNumber-ContactsModule
	    private PageElement ContPhoneNumber(){
	    	return new PageElement(By.xpath("//label[text()='Phone']/parent::div//input"),"Contact Phone Number Field");
	    } 
	    
	  //OwnerAddress-ContactsModule
	    private PageElement ContAddress(){
	    	return new PageElement(By.xpath("//label[text()='Address']/parent::div//input"),"Contact Address Field");
	    } 
	   
	  //OwnerAltPhoneNumber-ContactsModule
	    private PageElement ContAltPhone(){
	    	return new PageElement(By.xpath("//label[text()='Alt Phone']/parent::div//input"),"Contact Alt Phone Field");
	    } 
	    
	  //OwnerAddress2-ContactsModule
	    private PageElement ContAddress2(){
	    	return new PageElement(By.xpath("//label[text()='Address2']/parent::div//input"),"Contact Address2 Field");
	    } 
	    
	   
	  //OwnerMobilePhone-ContactsModule
	    private PageElement ContOwnerMobilePhone(){
	    	return new PageElement(By.xpath("//label[text()='Mobile Phone']/parent::div//input"),"Contact MobilePhone Field");
	    } 
	    
	  //OwnerCity-ContactsModule
	    private PageElement ContOwnerCity(){
	    	return new PageElement(By.xpath("//label[text()='City']/parent::div//input"),"Contact City Field");
	    } 
	  //OwnerWorkPhone-ContactsModule
	    private PageElement ContOwnerWorkPhone(){
	    	return new PageElement(By.xpath("//label[text()='Work Phone']/parent::div//input"),"Contact WorkPhone Field");
	    }
	    
	    //OwnerState-ContactsModule
	    private PageElement ContState(){
	    	return new PageElement(By.xpath("//label[text()='State']/parent::div//input"),"Contact State Field");
	    }  
	    
	  //OwnerZipCode-ContactsModule
	    private PageElement ContZipCode(){
	    	return new PageElement(By.xpath("//label[text()='Zip Code']/parent::div//input"),"Contact ZipCode Field");
	    }  
	  
	  //OwnerClose-ContactsModule
	    private PageElement CloseButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Close')]"),"Contact Close Button");
	    }
	    
	 //VendorTab-VendorModule
	    private PageElement vendorTab(){
	    	return new PageElement(By.xpath("//a/span[contains(text(),'Vendors')]"),"VendorTab");
	    }
	    
	  //VendorTab-VendorSearchField
	    private PageElement vendorSearchField(){
	    	return new PageElement(By.xpath("//input[@ng-model='query.text']"),"VendorSearch Field");
	    }
	  //VendorTab-VendorSearchButton
	    private PageElement vendorSearchButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Search')]"),"VendorSearch Button");
	    }
	    
	  //VendorTab-VendorDesireButton
	    private PageElement vendorDesireButton(){
	    	return new PageElement(By.xpath("//span[@class='icon-white icon-edit']"),"VendorDesired Button");
	    }  
	    
	  //VendorTab-VendorDisplay Element
	    private PageElement vendorDisplayElement(){
	    	return new PageElement(By.xpath("//tr[@ng-repeat='contact in ctrl.contacts']/td[2]"),"VendorDisplay Element");
	    } 
	    
	  //VendorTab - VendorDisplayDetails
	    private WebElement vendorTableDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(vendorDisplayElement()),4000);
	    } 
	    
	  //VendorTab - VendorDetailsDetails
	    private WebElement vendorDetailsDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(vendorName()),4000);
	    } 
	    
	    //VendorTab-VendorName
	    private PageElement vendorName(){
	    	return new PageElement(By.xpath("//label[text()='Business Name *required']/parent::div//input"),"VendorName Element");
	    } 
	    
	    //VendorTab-VendorAddress
	    private PageElement vendorAddress(){
	    	return new PageElement(By.xpath("//label[text()='Address']/parent::div//input"),"VendorAddress Element");
	    }
	    
	  //VendorTab-VendorAddress2
	    private PageElement vendorAddress2(){
	    	return new PageElement(By.xpath("//label[text()='Address2']/parent::div//input"),"VendorAddress2 Element");
	    }
	    
	    //VendorTab-VendorCity
	    private PageElement vendorCity(){
	    	return new PageElement(By.xpath("//label[text()='City']/parent::div//input"),"VendorCity Element");
	    }
	    
	  //VendorTab-VendorState
	    private PageElement vendorState(){
	    	return new PageElement(By.xpath("//label[text()='State']/parent::div//input"),"VendorState Element");
	    }
	    
	  //VendorTab-VendorZipCode
	    private PageElement vendorZipCode(){
	    	return new PageElement(By.xpath("//label[text()='Zip Code']/parent::div//input"),"VendorZipCode Element");
	    }
	    
	  //VendorTab-VendorEmail
	    private PageElement vendorEmail(){
	    	return new PageElement(By.xpath("//label[text()='E-mail']/parent::div//input"),"VendorEmail Element");
	    }
	    
	  //VendorTab-VendorPhone
	    private PageElement vendorPhone(){
	    	return new PageElement(By.xpath("//label[text()='Phone']/parent::div//input"),"VendorPhone Element");
	    }
	  //VendorTab-VendorAltPhone
	    private PageElement vendorAltPhone(){
	    	return new PageElement(By.xpath("//label[text()='Alt Phone']/parent::div//input"),"VendorAltPhone Element");
	    }
	    //VendorTab-VendorMobilePhone
	    private PageElement vendorMobilePhone(){
	    	return new PageElement(By.xpath("//label[text()='Mobile Phone']/parent::div//input"),"VendorMobilePhone Element");
	    }
	    
	    //VendorTab-VendorWorkPhone
	    private PageElement vendorWorkPhone(){
	    	return new PageElement(By.xpath("//label[text()='Work Phone']/parent::div//input"),"VendorWorkPhone Element");
	    }
	    
	    //VendorTab-VendorDeafultDiscount
	    private PageElement vendorDefaultDiscount(){
	    	return new PageElement(By.xpath("//label[text()='Default Markup/Discount']/parent::div//input"),"Vendor Default Discount Element");
	    }
	    
	  //TenantsTab- Tenants Tab
	    private PageElement tenantsTab(){
	    	return new PageElement(By.xpath("//span[contains(text(),'Tenants')]"),"Tenants Tab");
	    }
	    
	    
	    
	  //TenantsTab-TenantSearchField
	    private PageElement TenantSearchField(){
	    	return new PageElement(By.xpath("//input[@ng-model='query.text']"),"TenantsSearch Field");
	    }
	  //TenantsTab-TenantSearchButton
	    private PageElement TenantSearchButton(){
	    	return new PageElement(By.xpath("//button[contains(text(),'Search')]"),"TenantsSearch Button");
	    }
	    
	  //TenantsTab-TenantDesireButton
	    private PageElement TenantDesireButton(){
	    	return new PageElement(By.xpath("//span[@class='icon-white icon-edit']"),"TenantsDesired Button");
	    }  
	    
	  //TenantsTab-TenantDisplay Element
	    private PageElement TenantDisplayElement(){
	    	return new PageElement(By.xpath("//tr[@ng-repeat='contact in ctrl.contacts']/td[2]"),"TenantsDisplay Element");
	    } 
	    
	  //TenantsTab - TenantDisplayDetails
	    private WebElement TenantTableDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(TenantDisplayElement()),4000);
	    } 
	    	    
	    
	  //TenantsFirstName-ContactsModule
	    private PageElement TenantFirstName(){
	    	return new PageElement(By.xpath("//label[text()='First Name *required']/parent::div//input"),"Tenants FirstName Field");
	    } 
	    
	  //Tenants Details Display  
	    private WebElement TenantDetailsDisplay(){
	    	return webDriverHelper.waitForElementToBeDisplayed(getWebElement(TenantFirstName()),4000);
	    } 
	    
	    //TenantsTab-TenantsEmail
	    private PageElement TenantEmail(){
	    	return new PageElement(By.xpath("//label[text()='E-mail']/parent::div//input"),"Tenants Email Element");
	    } 
	  
	  //TenantsLastName-ContactsModule
	    private PageElement TenantLastName(){
	    	return new PageElement(By.xpath("//label[text()='Last Name *required']/parent::div//input"),"Tenants LastName Field");
	    } 
	    
	    //TenantsPhoneNumber-ContactsModule
	    private PageElement TenantPhoneNumber(){
	    	return new PageElement(By.xpath("//label[text()='Phone']/parent::div//input"),"Tenants Phone Number Field");
	    } 
	    
	  //TenantsAddress-ContactsModule
	    private PageElement TenantAddress(){
	    	return new PageElement(By.xpath("//label[text()='Address']/parent::div//input"),"Tenants Address Field");
	    } 
	   
	  //TenantsAltPhoneNumber-ContactsModule
	    private PageElement TenantAltPhone(){
	    	return new PageElement(By.xpath("//label[text()='Alt Phone']/parent::div//input"),"Tenants Alt Phone Field");
	    } 
	    
	  //TenantsAddress2-ContactsModule
	    private PageElement TenantAddress2(){
	    	return new PageElement(By.xpath("//label[text()='Address2']/parent::div//input"),"Tenants Address2 Field");
	    } 
	    
	   
	  //TenantsMobilePhone-ContactsModule
	    private PageElement TenantMobilePhone(){
	    	return new PageElement(By.xpath("//label[text()='Mobile Phone']/parent::div//input"),"Tenants MobilePhone Field");
	    } 
	    
	  //TenantsCity-ContactsModule
	    private PageElement TenantCity(){
	    	return new PageElement(By.xpath("//label[text()='City']/parent::div//input"),"Tenants City Field");
	    } 
	  //TenantsWorkPhone-ContactsModule
	    private PageElement TenantWorkPhone(){
	    	return new PageElement(By.xpath("//label[text()='Work Phone']/parent::div//input"),"Tenants WorkPhone Field");
	    }
	    
	    //TenantsState-ContactsModule
	    private PageElement TenantState(){
	    	return new PageElement(By.xpath("//label[text()='State']/parent::div//input"),"Tenants State Field");
	    }  
	    
	  //TenantsZipCode-ContactsModule
	    private PageElement TenantZipCode(){
	    	return new PageElement(By.xpath("//label[text()='Zip Code']/parent::div//input"),"Tenants ZipCode Field");
	    }  
	  
	 
	    
	  //************************End of the Declaration of Pageelements and Webelements******************//
	    
	  //************************Operation of the Elements***********************************************//
	 
	   
	    public void ProjectsCreation(Map<String,String> data){
	    	click(ProjectsElement());
	    	click(NewProjectsButton());
	    	click(DescriptionObject());
	    	sendKeys(DescriptionObject(),data.get("Description"));
	    	click(AddChangeLocation());
	    	sendKeys(SearchField(),data.get("PortFolioName"));
	    	click(SearchButton());
	    	click(AttachButtonportfolio());
	    }
	    
	    public void ContactsVerification(Map<String,String> data){
	    	click(ContactsButton());
	    	ContactSearchDisplay();
	    	click(ContactsSearchQuery());
	    	sendKeys(ContactsSearchQuery(),data.get("OwnerSearchKey"));
	    	click(ContactsSearchButton());
	    	webDriverHelper.explicitWait(2);
	    	TableDisplay();
	    	click(DesiredContactButton());
	    	webDriverHelper.explicitWait(2);
	    	contactDetailsDisplay();
	    	verifyText(ContOwnerFirstName(),data.get("OwnerFirstName"),"value");
	    	verifyText(ContOwnerLastName(),data.get("OwnerLastName"),"value");
	    	verifyText(ContPhoneNumber(),data.get("OwnerPhone"),"value");
	    	verifyText(ContAddress(),data.get("OwnerAddress1"),"value");
	    	verifyText(ContAltPhone(),data.get("OwnerAltPhoneNo"),"value");
	    	verifyText(ContAddress2(),data.get("OwnerAddress2"),"value");
	    	verifyText(ContOwnerMobilePhone(),data.get("OwnerMobileNo"),"value");
	    	verifyText(ContOwnerCity(),data.get("OwnerCity"),"value");
	    	verifyText(ContOwnerWorkPhone(),data.get("OwnerWorkPhone"),"value");
	    	verifyText(ContState(),data.get("OwnerState"),"value");
	    	verifyText(ContZipCode(),data.get("OwnerZipCode"),"value");
	    	click(CloseButton());
	    	
	    }
	    
	    
	    public void VendorsVerification(Map<String,String> data){
	    	click(vendorTab());
	    	vendorTableDisplay();
	    	sendKeys(vendorSearchField(),data.get("VendorName"));
	    	click(vendorSearchButton());
	    	webDriverHelper.explicitWait(2);
	    	vendorTableDisplay();
	    	click(vendorDesireButton());
	    	webDriverHelper.explicitWait(2);
	    	vendorDetailsDisplay();
	    	verifyText(vendorName(),data.get("VendorName"),"value");
	    	verifyText(vendorAddress(),data.get("VendorAddress1"),"value");
	    	verifyText(vendorAddress2(),data.get("VendorAddress2"),"value");
	    	verifyText(vendorCity(),data.get("VendorCity"),"value");
	    	verifyText(vendorState(),data.get("VendorState"),"value");
	    	verifyText(vendorZipCode(),data.get("VendorZipCode"),"value");
	    	verifyText(vendorEmail(),data.get("VendorEmail"),"value");
	    	verifyText(vendorPhone(),data.get("VendorPhone"),"value");
	    	verifyText(vendorAltPhone(),data.get("VendorAltPhone"),"value");
	    	verifyText(vendorMobilePhone(),data.get("VendorMobilePhone"),"value");
	    	verifyText(vendorWorkPhone(),data.get("VendorWorkPhone"),"value");
	    	verifyText(vendorDefaultDiscount(),data.get("VendorDefaultDiscount"),"value");
	    	click(CloseButton());
	    }
	    
	    
	   public void TenantsVerification(Map<String,String> data){
		   click(tenantsTab());
		   TenantTableDisplay();
	    	sendKeys(TenantSearchField(),data.get("VendorName"));
	    	click(TenantSearchButton());
	    	webDriverHelper.explicitWait(2);
	    	TenantTableDisplay();
	    	click(TenantDesireButton());
	    	webDriverHelper.explicitWait(2);
	    	TenantDetailsDisplay();
	    	verifyText(TenantFirstName(),data.get("TenantsFirstName"),"value");
	    	verifyText(TenantLastName(),data.get("TenantsLastName"),"value");
	    	verifyText(TenantAddress(),data.get("TenantsAddress"),"value");
	    	verifyText(TenantAddress2(),data.get("TenantsAddress1"),"value");
	    	verifyText(TenantCity(),data.get("TenantsCity"),"value");
	    	verifyText(TenantState(),data.get("TenantsState"),"value");
	    	verifyText(TenantZipCode(),data.get("TenantsZipCode"),"value");
	    	verifyText(TenantEmail(),data.get("TenantsEmail"),"value");
	    	verifyText(TenantPhoneNumber(),data.get("TenantsPhone"),"value");
	    	verifyText(TenantAltPhone(),data.get("TenantsAltPhone"),"value");
	    	verifyText(TenantMobilePhone(),data.get("TenantsMobilePhone"),"value");
	    	verifyText(TenantWorkPhone(),data.get("TenantsWorkPhone"),"value");
	    	click(CloseButton());
		   
	   }
	    
	    
	  //************************************End of the Operations of Elements*****************************************************//      
	} 
	 

