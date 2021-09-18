import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.BaseClass;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LeadPage;

public class HoverMsgCapture extends BaseClass {

	@Test
	public void hoverMsgCapture() {

		HomePage hp =new HomePage(driver);
		hp.clickonLead();

		LeadPage lp = new LeadPage(driver);

		WebElement btn = lp.getCreateleadLink();
		System.out.println(btn.getAttribute("title"));


	}

}
