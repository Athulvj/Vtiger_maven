package org.vtiger.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genericUtility.JsonFileUtility;

public class Sample2Test {
	@Test
	public  void selectAllCheckBox() throws Throwable {
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

		List<WebElement> checkboxlist = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));

		for (WebElement webElement : checkboxlist) {

			webElement.click();
		}
		//deselect the LAST ONE
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@id='125']")).click();


	}

}


