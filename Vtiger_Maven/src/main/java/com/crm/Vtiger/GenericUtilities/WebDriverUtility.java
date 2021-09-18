package com.crm.Vtiger.GenericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility  {
		
		/**
		 * this method wait for 20 sec for page loading
		 * @param driver
		 */
	   public void waitUntilPageLoad(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   }
	   
	   /**
	    * This method is used to launch browser
	    * @param driver
	    * @param URL
	    */
	   public void launchBrowser(WebDriver driver, String url) {
		   driver.get(url);
		   
	   }
	   
	   /**
	    * This method wait for the element to be visible
	    * @param driver
	    * @param element
	    * 
	    */
	   public void waitForElementVisibility(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }

	   /**
	    * This method wait for the element to be Present
	    * @param driver
	    * @param locator
	    */
	   public void waitForElementPresence(WebDriver driver,By locator)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	   }
	   /**
	    * This method wait for the element to be clickable
	    * @param driver
	    * @param element
	    */
	   public void waitForElementtobeClickable(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.elementToBeClickable(element));
	   }
	   /**
	    * this methods enables user to handle dropdown using visible text
	    * @param element
	    * @param option
	    */
	       
	   public void select(WebElement element, String Value)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(Value);
		   
	   }
	   
	   /**
	    * this methods enables user to handle dropdown using Value
	    * @param element
	    * @param Value
	    */
	   
	   public void selectByValue(WebElement element, String Value)
	   {
		   Select select=new Select(element);
		   select.selectByValue(Value);
		   
	   }

	   /**
	    * this methods enables user to handle dropdown using index
	    * @param element
	    * @param index
	    */
	      
	   public void select(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }

	   /**
	    * This method helps to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
		  
	   }
	   
	   public void maximize(WebDriver driver) {
		   driver.manage().window().maximize();
	   }

	   /**
	    * Accept alert 
	    * @param driver
	    */
	   
	   public void acceptAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }

	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 


	    /**
	     * Browser selection method
	     * 
	     */
	   
	   public WebDriver selectBrowser( String browser) {
		   WebDriver driver = null;
		   if(browser.equals("chrome")) {
				driver = new ChromeDriver(); 
			}

			else if(browser.equals("firefox")) {
				driver = new FirefoxDriver();
			}

			else {
				System.out.println("invalid browser");
			}
		return driver;
		   
	   }
	   
	   /**
	    * This method will perform mouse over action
	    * @param driver
	    * @param element
	    */
	   
	   public void mouseOver(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	   
	   public void getalertText(WebDriver driver) {
		   // Switching to Alert        
	        Alert alert = driver.switchTo().alert();			
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText(); 
	        System.err.println(alertMessage);
	   }

	}


