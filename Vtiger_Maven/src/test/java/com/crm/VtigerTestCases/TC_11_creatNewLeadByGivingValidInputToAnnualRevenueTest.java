package com.crm.VtigerTestCases;

import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.BaseClass;
import com.crm.Vtiger.ObjectRepository.CreateLeadPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LeadInfoPage;
import com.crm.Vtiger.ObjectRepository.LeadPage;
public class TC_11_creatNewLeadByGivingValidInputToAnnualRevenueTest extends BaseClass {
	
	@Test(groups="smoke")
	public void creatNewLeadByGivingValidInputToAnnualRevenueTest() throws Throwable{
		
	
		
		//module data
		String Lastname = elib.getDataFromExcel("LeadData", 1, 1) + jlib.RandomNumber();
		String Companyname = elib.getDataFromExcel("LeadData", 2, 1) + jlib.RandomNumber();
		//String AnnualRevenue = jslib.JsonLib("AnnualRevenue");
		String AnnualRevenue = elib.getintDataFromExcel("LeadData", 3, 1);
		
	
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
		LeadInfoPage lip = new LeadInfoPage(driver);
		lip.getLeadNo();
		
	
		
	}

	
}
