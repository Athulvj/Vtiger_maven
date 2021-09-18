package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Vtiger.GenericUtilities.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility {
		WebDriver driver;


	public CreateLeadPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@name=\"company\"]")
	private WebElement companynameEdt;
	
	@FindBy(name="annualrevenue")
	private WebElement AnnualRevenueEdit;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//td[text()='No Of Employees ']/following-sibling::td[1]/input")
	private WebElement NoOfEmplyess;
	
	@FindBy(xpath="//td[text()='Email ']/following-sibling::td[1]/input")
	private WebElement Email;
	
	@FindBy(xpath="//td[text()='Secondary Email ']/following-sibling::td[1]/input")
	private WebElement SecondaryEmail;


	@FindBy(xpath="//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement DDSignOutLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutlink;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement selectIndustry;
	
	
	//getters
	
	public WebElement getEmail() {
		return Email;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}

	public WebElement getSecondaryEmail() {
		return SecondaryEmail;
	}
	
	public WebElement getNoOfEmplyess() {
		return NoOfEmplyess;
	}
	
	public WebElement getDDSignOutLink() {
		return DDSignOutLink;
	}
	
	public WebElement getSignOutlink() {
		return SignOutlink;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCompanynameEdt() {
		return companynameEdt;
	}

	public WebElement getAnnualRevenueEdit() {
		return AnnualRevenueEdit;
	}
	
	//Business Logic
	public void enterlastName(String lastname) {
		getLastnameEdt().sendKeys(lastname);
	}
	
	public void enterCompany(String Company) {
		getCompanynameEdt().sendKeys(Company);
	}
	
	public void enterAnnualRevenue(String AnnualRevenue) {
		getAnnualRevenueEdit().sendKeys(AnnualRevenue);
	}
	
	public void clickOnSaveBtn() {
		getSaveBtn().click();
	}
	
	public void enterNoOfEmplyess(String NoofEmployess) {
		getNoOfEmplyess().sendKeys(NoofEmployess);
	}
	public void enterEmail(String email) {
		getEmail().sendKeys(email);
	}
	public void entersecondaryEmail(String Secondaryemail) {
		getSecondaryEmail().sendKeys(Secondaryemail);
	}
	
	public void signout(WebDriver driver) {
		waitForElementVisibility(driver, getDDSignOutLink());
		mouseOver(driver, getDDSignOutLink());
		getSignOutlink().click();	
	}
	
	public void selectIndustry(String Value) {
		selectByValue(getSelectIndustry(), Value);
	}
}
