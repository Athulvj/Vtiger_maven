package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.findElement(By.className("search_input-bar")).click();
		String Suggestion = driver.findElement(By.xpath("//div[@class='trending']")).getText();
		System.out.println("=====Suggestion Content====="+"\n"+Suggestion);
		driver.close();
		
	}
	
 
	
	
}
