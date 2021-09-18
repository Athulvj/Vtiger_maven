package com.crm.Vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.Vtiger.ObjectRepository.HomePage;
import com.crm.Vtiger.ObjectRepository.LoginPage;

public class BaseClass {

	public JSONFileUtility jslib = new JSONFileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wdlib = new WebDriverUtility();

	public WebDriver driver;
	public static WebDriver staticdriver;
	


	@BeforeSuite(groups= {"smoke","Regression"})
	public void connectToDB() {

		System.out.println("===DB Connected===");
	}
	//@Parameters("Browser")
	@BeforeClass(groups= {"smoke","Regression"})
	public void launchBrowser() throws Throwable {
		String Url = jslib.JsonLib("url");
		String Browser = jslib.JsonLib("browser");
		//wdlib.selectBrowser(Browser);

		if(Browser.equals("chrome")) {
			driver = new ChromeDriver(); 
		}

		else if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("invalid browser");
		}
		
		staticdriver=driver;
		driver.get(Url);
		wdlib.waitUntilPageLoad(driver);
		wdlib.maximize(driver);
		
		System.out.println("===Browser Launched===");
	}

	@BeforeMethod(groups= {"smoke","Regression"})
	public void login() throws Throwable {

		String username = jslib.JsonLib("username");
		String password = jslib.JsonLib("password");
		LoginPage lp = new LoginPage(driver);
		lp.Login(username, password);
		
		System.out.println("===Logged In===");
	}

	@AfterMethod(groups= {"smoke","Regression"})
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
		
		System.out.println("===Logged out===");

	}

	@AfterClass(groups= {"smoke","Regression"})
	public void closeBrowser() {
		driver.close();
		
		System.out.println("===Browser closed===");
	}

	@AfterSuite(groups= {"smoke","Regression"})
	public void closeDB() {
		System.out.println("===DB closed===");

	}
	
	public String getscreenshot(String screenshotname) throws IOException {
		System.out.println("ss_started");
		File srcfile = ((TakesScreenshot)  staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/screenshots/"+screenshotname+".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		return destfile;
	}

}
