package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage( WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href=\"index.php?module=Leads&action=index\"]")
	private WebElement LeadLink;
	
	
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutDropDown;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutLink;
	
	//getters
	
	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getLeadLink() {
		return LeadLink;
	}
	
	public WebElement getSignoutDropDown() {
		return signoutDropDown;
	}
	//business logic
	public void clickonLead() {
		getLeadLink().click();
	}
	
	public void signOut(WebDriver driver) {
		
		waitForElementVisibility(driver,getSignoutDropDown());
		mouseOver(driver, getSignoutDropDown());
		getSignOutLink().click();
	}

	
}
