package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class LeadPage extends WebDriverUtility{
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createleadLink;
	
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement DDSignOutLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutlink;

	//getters
	public WebElement getDDSignOutLink() {
		return DDSignOutLink;
	}
	
	public WebElement getSignOutlink() {
		return SignOutlink;
	}
	
	public WebElement getCreateleadLink() {
		return createleadLink;
	}
	
	//Busniess logic
	
	public void clickonCreateLead() {
		getCreateleadLink().click();
	}
	
	public void signout(WebDriver driver) {
		waitForElementVisibility(driver, getDDSignOutLink());
		mouseOver(driver, getDDSignOutLink());
		getSignOutlink().click();	
	}
}
