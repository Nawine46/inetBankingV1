package com.inetBanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;
import com.inetBanking.pageObjects.LoginPage;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_LoginTest_001 extends BaseClass{
	
	
	
	@Test
	public void LoginTest() throws IOException, InterruptedException {
		
		
		LoginPage LP =new LoginPage(driver);
		
		testcases =extentReports.createTest("OpenBrowser");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		
		logger.info("URL is Opened");
		
		driver.manage().window().maximize();
		
		LP.setUserName(userName);
		
		testcases =extentReports.createTest("Entered Usename");
		
		logger.info("Entered Usename");
		
		LP.setPassword(passWord);
		
		testcases =extentReports.createTest("Entered Password");
		
		//logger.info("Entered Password");
		
		LP.clickBtn();
		
		//driver.switchTo().alert().accept();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		
			testcases =extentReports.createTest("Verify title");
			
			Alert alert = driver.switchTo().alert();
			
			Thread.sleep(2000);
			
			alert.accept();
			
		}
		
		else {
			
			captureScreenshot(driver,"LoginTest");
			
			org.testng.Assert.assertTrue(false);
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	

}
