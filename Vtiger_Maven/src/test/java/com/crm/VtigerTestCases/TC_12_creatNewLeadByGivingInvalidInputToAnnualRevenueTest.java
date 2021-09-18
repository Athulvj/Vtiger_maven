package com.crm.VtigerTestCases;

import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.BaseClass;
import com.crm.Vtiger.ObjectRepository.CreateLeadPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LeadPage;

public class TC_12_creatNewLeadByGivingInvalidInputToAnnualRevenueTest extends BaseClass  {
	
	@Test(groups="Regression")
	public void creatNewLeadByGivingInvalidInputToAnnualRevenueTest() throws Throwable {
	
		//module data
		String Lastname = elib.getDataFromExcel("LeadData", 1, 1) + jlib.RandomNumber();
		String Companyname = elib.getDataFromExcel("LeadData", 2, 1) + jlib.RandomNumber();
		//String AnnualRevenue = jslib.JsonLib("AnnualRevenue");
		String AnnualRevenue = elib.getDataFromExcel("LeadData", 3, 2);
		
		//From homepage to lead
		HomePage hp = new HomePage(driver);
		hp.clickonLead();
		
		//Create Lead page
		LeadPage ldp = new LeadPage(driver);
		ldp.clickonCreateLead();
		
		//Fill the CreateleadForm
		CreateLeadPage clp = new CreateLeadPage(driver);
		clp.enterlastName(Lastname);
		clp.enterCompany(Companyname);
		clp.enterAnnualRevenue(AnnualRevenue);
		clp.clickOnSaveBtn();

		//Verify the leadNo
		wdlib.getalertText(driver);
		wdlib.acceptAlert(driver);
		
		
	}
}
