package org.vtiger.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtility.JsonFileUtility;

public class DeleteRow {
	
	@Test
	public void deleteRow() throws Throwable  {
		WebDriver driver = null;

		JsonFileUtility jsu = new JsonFileUtility();
		String browser = jsu.JsonLib("browser");
		String username = jsu.JsonLib("username");
		String password = jsu.JsonLib("password");
		String url = jsu.JsonLib("url");
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver(); 
		}

		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("invalid browser");
		}

		//launch browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		//login to app
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//click on organisation
		driver.findElement(By.xpath("//table[@class='hdrTabBg']//tbody/tr/td/a[text()='Organizations']")).click();

		List<WebElement> DelBtnlist = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/a[text()='del']"));


		DelBtnlist.get(13).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		



	}
}
