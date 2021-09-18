package com.crm.VtigerTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.JSONFileUtility;
import com.crm.Vtiger.GenericUtilities.JavaUtility;
import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class TC_01_CreateOrganization {

	@Test
	public void CreateOrganization() throws Throwable {
		JSONFileUtility jfu = new JSONFileUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wdu = new  WebDriverUtility();
		// common data
		String  Username = jfu.JsonLib("username");
		String Password = jfu.JsonLib("password");
		String URL = jfu.JsonLib("url");
		String Browser = jfu.JsonLib("browser");
		String OrgName = jfu.JsonLib("orgname")+ju.RandomNumber();
		
		
		WebDriver driver=null;
		driver= wdu.selectBrowser(Browser);
		//wdu.selectBrowser(driver, Browser);
		wdu.waitUntilPageLoad(driver);
		wdu.launchBrowser(driver, URL);
		wdu.maximize(driver);
		
		//login to app
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//Create on organisation
		driver.findElement(By.xpath("//table[@class='hdrTabBg']//tbody/tr/td/a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Entering valid values in mandatory Field & saving it
		driver.findElement(By.xpath("//input [@name='accountname']")).sendKeys(OrgName);
		wdu.select(driver.findElement(By.xpath("//select[@name='industry']")), "Education");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Logout from application
		wdu.waitForElementtobeClickable(driver, driver.findElement(By.xpath("//input[@title='Duplicate [Alt+U]']")));
		wdu.mouseOver(driver, driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]")));
		wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//td[@class='small']/img[@src='themes/softed/images/user.PNG']")));
		wdu.mouseOver(driver, driver.findElement(By.xpath("//td[@class='small']/img[@src='themes/softed/images/user.PNG']")));
		//wdu.waitForElementtobeClickable(driver, driver.findElement(By.xpath("//div[@class='drop_mnu_user']/table/tbody/tr/td/a[text()='Sign Out']")));
		//wdu.waitForElementPresence(driver, By.xpath("//a[text()='Sign Out']"));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();		
	}




}
