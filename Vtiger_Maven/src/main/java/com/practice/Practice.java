package com.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Practice {
 
	@Test
	public void remoteExecutionTest() throws MalformedURLException {
	URL url = new URL("http://13.232.208.165:4444/wd/hub");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName("chrome"); 
	cap.setPlatform(Platform.WINDOWS); 
	RemoteWebDriver driver = new RemoteWebDriver(url, cap); 
	driver.get("http://gmail.com");
	}
}
