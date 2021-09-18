import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {
	WebDriver driver;
	String URL;
	String USERNAME;
	String PASSWORD;
	String browser;
	@Test
	public void sampleTest(){

		URL=System.getProperty("url");
		USERNAME=System.getProperty("username");
		PASSWORD=System.getProperty("password");
		browser=System.getProperty("browser");
		
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver(); 
		}

		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("invalid browser");
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//td[@class='sep1']/../td[2]//a/img[1]")).click();

		String LastName =System.getProperty("lastname");
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.className("crmButton.small.save")).click();
		driver.quit();
	}
}
