package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class LeadInfoPage extends WebDriverUtility {
	public LeadInfoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Lead No']/following-sibling::td")
	private WebElement LeadNoInfo;
	
	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement DDSignOutLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutlink;
	
	@FindBy(xpath="//td[text()='Company']/following-sibling::td[1]")
	private WebElement ActCompanyName;
	
	@FindBy(xpath="//td[text()='Industry']/following-sibling::td[1]")
	private WebElement ActIndustry;
	
	
	
	
	
	//getters
	
	public WebElement getActCompanyName() {
		return ActCompanyName;
	}
	public WebElement getActIndustry() {
		return ActIndustry;
	}
	public WebElement getLeadNoInfo() {
		return LeadNoInfo;
	}
	public WebElement getDDSignOutLink() {
		return DDSignOutLink;
	}
	
	public WebElement getSignOutlink() {
		return SignOutlink;
	}
	// business logic
	public void getLeadNo() {
		System.out.println("Generated Lead No. - "+getLeadNoInfo().getText());
	}
	
	public void signout(WebDriver driver) {
		waitForElementVisibility(driver, getDDSignOutLink());
		mouseOver(driver, getDDSignOutLink());
		getSignOutlink().click();	
	}
}
