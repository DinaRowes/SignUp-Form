package com.google.Selenium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class factoryValidSignUp {
	ExcelFileReader Er=new ExcelFileReader("src/test/java/testdataa.xlsx");
	ChromeDriver driver ;
	
	@BeforeTest
	  public void OpenURL() {
		  
		     driver=new ChromeDriver();
			 driver.navigate().to("https://merchant.kashier.io/signup");
	     }
	
  @Test
  public void signupsuccess( ) throws InterruptedException 
  {
	  String  fullName=  Er.getCellValue(0, 1, 0);
	  String  storeName= Er.getCellValue(0, 1, 1);
	  String  mobile_number =Er.getCellValue(0, 1, 2);
	  String  email= Er.getCellValue(0, 1, 3);
	  String  password=Er.getCellValue(0, 1, 4);
	  
	 
	    driver.findElement(By.cssSelector("[name='full_name']")).sendKeys(fullName);
		driver.findElement(By.cssSelector("[name='store_name']")).sendKeys(storeName);	
		driver.findElement(By.cssSelector("[name='mobile_number']")).sendKeys(mobile_number);
		driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("#register-password")).sendKeys(password);
		driver.findElement(By.cssSelector("#r-register-password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signup-span")).click();
		Thread.sleep(15000);
		String CurrentURL=driver.getCurrentUrl();
		assertTrue(CurrentURL.contains("kashier dashboard"));
		System.out.println("logged Successflly");
  }
  @AfterTest()
  public void CloseDriver() {
	  driver.quit();
  }

}
