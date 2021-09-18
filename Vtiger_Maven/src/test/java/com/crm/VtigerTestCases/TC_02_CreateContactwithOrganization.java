package com.crm.VtigerTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.Vtiger.GenericUtilities.ExcelUtility;
import com.crm.Vtiger.GenericUtilities.JSONFileUtility;
import com.crm.Vtiger.GenericUtilities.JavaUtility;
import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class TC_02_CreateContactwithOrganization {
	
	@Test
	public void  CreateContactwithOrganization() throws Throwable {
		JSONFileUtility jfu = new JSONFileUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wdu = new  WebDriverUtility();
		ExcelUtility eu =new ExcelUtility();
		
		// common data
		String  Username = jfu.JsonLib("username");
		String Password = jfu.JsonLib("password");
		String URL = jfu.JsonLib("url");
		String Browser = jfu.JsonLib("browser");
		String lastname = eu.getDataFromExcel("NewContact", 1, 1) + ju.RandomNumber();
		System.out.println(lastname);
		String OrganizationName = eu.getDataFromExcel("NewContact", 2, 1);
		System.out.println(OrganizationName);
		
		
		WebDriver driver=null;
		driver= wdu.selectBrowser(Browser);

		wdu.waitUntilPageLoad(driver);
		wdu.launchBrowser(driver, URL);
		wdu.maximize(driver);

		//login to app
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//creata a contact 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Entering valid values in mandatory Field & add organization
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/../img[@src='themes/softed/images/select.gif']")).click();
		wdu.switchToWindow(driver, "Accounts");
		wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//input[@name='search_text']")));
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrganizationName, Keys.ENTER);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		wdu.switchToWindow(driver, "Contacts&action");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		//Logout from application
		wdu.waitForElementtobeClickable(driver, driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]")));
		wdu.mouseOver(driver, driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]")));
		wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//td[@class='small']/img[@src='themes/softed/images/user.PNG']")));
		wdu.mouseOver(driver, driver.findElement(By.xpath("//td[@class='small']/img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}
}

