package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgNewCustomViewTest {
	
	public OrgNewCustomViewTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="viewName")
	private WebElement ViewName;
	
	@FindBy(xpath="//div/input[@value='Save']")
	private WebElement Save;

	public WebElement getViewName() {
		return ViewName;
	}

	public WebElement getSave() {
		return Save;
	}
	
	//business logic
	public void simplefilter(String ViewName) {
		getViewName().sendKeys(ViewName);
		getSave().click();
		
	}
	

}


