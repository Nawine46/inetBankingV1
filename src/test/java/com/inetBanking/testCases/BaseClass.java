package com.inetBanking.testCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.Utilities.ReadingConfig;


public class BaseClass {
	
	ReadingConfig config =new ReadingConfig();
	
	public String baseURL =config.getApplicationURL();
	
	public String userName =config.getUsername();
	
	public String passWord =config.passWord();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	public ExtentReports extentReports;
	
	public ExtentSparkReporter extentsparkreporter;
	
	public ExtentTest testcases;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setUp (String bn) {
		
		extentReports =new ExtentReports();
		
		extentsparkreporter = new ExtentSparkReporter("ExtentReport.html");
		
		extentReports.attachReporter(extentsparkreporter);
		
		
		
		if(bn.equals("chrome"))  {
			
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Naveen\\eclipse-workspace\\inetBankingV1\\Driver\\chromedriver.exe");
			
			//System.setProperty("webdriver.chrome.driver",config.getChromePath());
			 driver =new ChromeDriver();
			
		}
		
		else if(bn.equals("firefox") )  {
			
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Naveen\\eclipse-workspace\\inetBankingV1\\Driver\\geckodriver.exe");
			
		driver =new FirefoxDriver();
			
		}
		
		else if(bn.equals("ie") )  {
			
		System.setProperty("webdriver.ie.driver","C:\\Users\\Naveen\\eclipse-workspace\\inetBankingV1\\Driver\\chromedriver.exe");
				
		driver =new InternetExplorerDriver();
				
			}
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		 logger =Logger.getLogger("ebanking");
		 
		 PropertyConfigurator.configure("Log4j.properties");
		 
	
		
	}
	
	public void captureScreenshot(WebDriver driver ,String file) throws IOException  {
		
		TakesScreenshot TK =(TakesScreenshot)driver;
		
		File src = TK.getScreenshotAs(OutputType.FILE);
		
		System.out.println(src);
		
		File dest =new File("D:\\Selenium Task");
		
		FileUtils.copyFile(src, dest);
		
	}
	
	
	
	
	
	@AfterClass
	public void tearDown() {
		
		
		//driver.quit();
		
		extentReports.flush();
		
		
	}
	
	
	

}
