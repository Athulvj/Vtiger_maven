package com.crm.VtigerTestCases;

import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.BaseClass;
import com.crm.Vtiger.ObjectRepository.CreateLeadPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LeadPage;

public class TC_15_creatNewLeadByGivingValidInputToEmailAndSecondaryEmailTest extends BaseClass {
	@Test(groups="smoke")
	public void creatNewLeadByGivingValidInputToNoOfEmployeeTest() throws Throwable {

		//module data
		String Lastname = elib.getDataFromExcel("LeadData", 1, 1) + jlib.RandomNumber();
		String Companyname = elib.getDataFromExcel("LeadData", 2, 1) + jlib.RandomNumber();
		String email = elib.getDataFromExcel("LeadData", 5, 1);
		String secondaryemail = elib.getDataFromExcel("LeadData", 6, 1);

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
		clp.enterEmail(email);
		clp.entersecondaryEmail(secondaryemail);
		clp.clickOnSaveBtn();


	}

}
