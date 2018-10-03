package com.business.giftrbeta.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScriptBase extends DriverBase {
	
	@BeforeMethod
	public void browserSetup() {
//	PropertyReaderService startbrowser=PropertyReaderService.getInstance();
//	String selbrowser=startbrowser.getProperty("browser");
	String br=PropertyReaderService.browserTorun();

	if(br.toLowerCase().contentEquals("chrome")) {
		WebDriverManager.chromedriver().arch32().setup();
		
		//---------------
		//For initiating headless browser testing
//		ChromeOptions options=new ChromeOptions();
		//---Below line has to be added for compatibility with mobile browsers---
//		options.addArguments("window-size=1400,800");
//		options.addArguments("headless");
//		driver=new ChromeDriver(options);
		//---------------
		
		driver=new ChromeDriver();
	
	}
	
	String web=PropertyReaderService.websiteTotest();
	driver.get(web);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void browserQuit() {
//	driver.close();
//	driver.quit();
	}
	
}
