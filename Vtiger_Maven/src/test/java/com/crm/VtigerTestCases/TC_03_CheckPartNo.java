package com.crm.VtigerTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.Vtiger.GenericUtilities.ExcelUtility;
import com.crm.Vtiger.GenericUtilities.JSONFileUtility;
import com.crm.Vtiger.GenericUtilities.JavaUtility;
import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class TC_03_CheckPartNo {
	
	static String PartNUM1 = "BC150";

	public static void main(String[] args) throws Throwable {
		JSONFileUtility jfu = new JSONFileUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wdu = new  WebDriverUtility();
		ExcelUtility eu =new ExcelUtility();

		// common data
		String  Username = jfu.JsonLib("username");
		String Password = jfu.JsonLib("password");
		String URL = jfu.JsonLib("url");
		String Browser = jfu.JsonLib("browser");

		//module data
		String ProductName = eu.getDataFromExcel("ProductInfo", 1, 1);
		String PN = eu.getDataFromExcel("ProductInfo", 2, 1);
		String PartNum = PN ;

		WebDriver driver=null;
		driver= wdu.selectBrowser(Browser);
		
		wdu.waitUntilPageLoad(driver);
		wdu.launchBrowser(driver, URL);
		wdu.maximize(driver);

		//login to app
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();

		//Create Product
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//img[@title='Create Product...']")));
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProductName);
		driver.findElement(By.name("productcode")).sendKeys(PartNum);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Product No Fetching
		String GenProductNum = driver.findElement(By.xpath("//td[text()='Product No']/following-sibling::td")).getText().trim();

		//Go to ProductPage
		driver.findElement(By.xpath("//table[@class='hdrTabBg']/tbody/tr//tbody/tr/td/a[text()='Products']")).click();

		//Validate the Product
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(PartNum);
		wdu.selectByValue(driver.findElement(By.xpath("//select[@name='search_field']")), "productcode");
		driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.textToBePresentInElementValue((By)driver.findElement(By.xpath("//tr[@class='lvtColData']/td[4]")), PN));
		//wdu.waitForElementPresence(driver, By.xpath("//tr[@class='lvtColData']/td[4][contains(text(),'"+PN+"')"));
		//Thread.sleep(2000);
		System.out.println("-----");

		String actPartNum =driver.findElement(By.xpath("//tr[@class='lvtColData']/td[4]")).getText();
		System.out.println("-----");

		if(actPartNum.equals(PartNum)) {
			System.out.println("Part Number Validated");
		}
		System.out.println("-----");
		
		String ProductNum = driver.findElement(By.xpath("//tr[@class='lvtColData']/td[2]")).getText();
		
		if(ProductNum.equals(GenProductNum)) {
			System.out.println("Product Number validated");
			
		}

		driver.close();
	}
}
