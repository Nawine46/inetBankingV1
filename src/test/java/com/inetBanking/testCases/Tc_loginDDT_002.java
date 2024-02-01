package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.XLUtils;
import com.inetBanking.pageObjects.LoginPage;



public class Tc_loginDDT_002 extends BaseClass {

	
	@Test(dataProvider ="loginData")
	public void loginDDT () throws InterruptedException {
		
		LoginPage LP =new LoginPage(driver);
		
		
		LP.setPassword(userName);
		
		extentReports.createTest("Username isProvided");
		
		LP.setPassword(passWord);
		
		extentReports.createTest("Password is Provided");
		
		LP.clickBtn();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)    {
			
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
			
			org.testng.Assert.assertTrue(false);
			
			logger.warning("login failed");
			
			
		}
		
		else {
			
			
			org.testng.Assert.assertTrue(true);
			
			Thread.sleep(3000);
			
			LP.logBtn();
			
			driver.switchTo().alert().accept();
			
			driver.switchTo().defaultContent();
			
			extentReports.createTest("login Passed");
			
		}
		
	}
		
	
	public boolean isAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
		
		}
		catch (NoAlertPresentException e) {
			
			return false;
		}
		
	}

	
	@DataProvider(name ="loginData")
	
	public String[][] getData () throws IOException {
		
		
		//String path=System.getProperty("user.dir")+"//src//test//java//com//inetBanking//testData//Naveen.xlsx";
		
		//String path="C:\\Users\\Naveen\\eclipse-workspace\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\testDatas\\Naveen.xlsx";
		
		String path="C:/Users/Naveen/eclipse-workspace/inetBankingV1/src/test/java/com/inetBanking/testDatas/Naveen.xlsx";
		
		int rowCount =XLUtils.getRowCount(path, "Sheet1");
		
		int colCount =XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata [] []=new String[rowCount][colCount];
		
		
		for (int i = 1; i < rowCount; i++) {
			
			
			for (int j = 0; j <colCount; j++) {
				
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", 1, 0);	
				
			}
			
		}
		
		return logindata;
		
	}
	
	
}
