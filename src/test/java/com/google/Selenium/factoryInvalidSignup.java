package com.google.Selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class factoryInvalidSignup {
	
	ExcelFileReader Er=new ExcelFileReader("src/test/java/testdataa.xlsx");
	ChromeDriver driver ;
	
	@BeforeTest
	  public void OpenURL() {
		  
		     driver=new ChromeDriver();
			 driver.navigate().to("https://merchant.kashier.io/signup");
	     }
	
  @Test
  public void missingdata() 
  {
	  String  fullName=  Er.getCellValue(0, 2, 0);
	  String  storeName= Er.getCellValue(0, 2, 1);
	  String  mobile_number =Er.getCellValue(0, 2, 2);
	  String  email= Er.getCellValue(0, 2, 3);
	  String  password=Er.getCellValue(0, 2, 4);
	  
	 
	    driver.findElement(By.cssSelector("[name='full_name']")).sendKeys(fullName);
		driver.findElement(By.cssSelector("[name='store_name']")).sendKeys(storeName);	
		driver.findElement(By.cssSelector("[name='mobile_number']")).sendKeys(mobile_number);
		driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("#register-password")).sendKeys(password);
		driver.findElement(By.cssSelector("#r-register-password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signup-span")).click();
		WebElement MobileErrorMsg= driver.findElement(By.cssSelector("#mobile_number-error"));
		String ActualResult =MobileErrorMsg.getText();
		assertTrue(ActualResult.contains("at least 11 char"));
		System.out.println("Success Invalid Mobile Number");
		WebElement EmailErrorMsg= driver.findElement(By.cssSelector("#email-error"));
		String ActualResult2 =EmailErrorMsg.getText();
		assertTrue(ActualResult2.contains(" enter a valid Email"));
		System.out.println("Success Invalid Email");
  }
  
  @AfterTest()
  public void CloseDriver() {
	  driver.quit();
  }
}
