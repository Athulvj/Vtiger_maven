import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.BaseClass;
import com.crm.Vtiger.ObjectRepository.CreateLeadPage;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LeadInfoPage;
import com.crm.Vtiger.ObjectRepository.LeadPage;

@Listeners(com.crm.Vtiger.GenericUtilities.ListenerS.class)

public class SampleMultiDataTest extends BaseClass {
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		return elib.getExcelTestData("Sheet1");
		
	}
	
	@Test(dataProvider="getData")
	public void SampleExcelTestDatapractice(String CompanyName, String IndType) throws Throwable {
		
		String Lastname = elib.getDataFromExcel("LeadData", 1, 1) + jlib.RandomNumber();
		
		//From homepage to lead
				HomePage hp = new HomePage(driver);
				hp.clickonLead();
				
				//Create Lead page
				LeadPage ldp = new LeadPage(driver);
				ldp.clickonCreateLead();
				
				//Fill the CreateleadForm
				CreateLeadPage clp = new CreateLeadPage(driver);
				clp.enterlastName(Lastname);
				clp.enterCompany(CompanyName);
				clp.selectIndustry(IndType);
				clp.clickOnSaveBtn();
				
				LeadInfoPage lip = new LeadInfoPage(driver);
				String ActualComName = lip.getActCompanyName().getText();
				String ActIndType = lip.getActIndustry().getText();
				
				//Validate
				Assert.assertTrue(ActualComName.contains(CompanyName));
				Assert.assertTrue(ActIndType.contains(IndType));
				
				Assert.assertEquals(false, true);
				
	}

}
