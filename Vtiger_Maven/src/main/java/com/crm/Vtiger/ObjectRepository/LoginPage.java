package com.crm.Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Athul
 *
 */
public class LoginPage { 
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement SubmitBtn;
	
	//getters

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	//business logic
	public void Login(String username, String password  ) {
		
		getUsernameEdt().sendKeys(username);
		getPasswordEdt().sendKeys(password);
		getSubmitBtn().click();
	}
	
	
}
