package com.business.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.business.giftrbeta.framework.PropertyReaderService;
import com.business.giftrbeta.framework.ScriptBase;

public class Giftcardmall_Login extends ScriptBase {
	
//	@Test
	public void Login() throws Exception {
		
	String web=PropertyReaderService.websiteTotest();
	driver.get(web);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	String user=PropertyReaderService.getInstance().getProperty("username");
	String password=PropertyReaderService.getInstance().getProperty("password");
		
	WebElement signIn= driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
	signIn.click();
	
	WebElement emailInput=driver.findElement(By.xpath("//input[@id='login-email']"));
	emailInput.sendKeys(user);
	
	WebElement passwordInput=driver.findElement(By.xpath("//input[@id='login-password']"));
	passwordInput.sendKeys(password);
	
	Thread.sleep(5000);
	
	WebElement clickRecaptcha=driver.findElement(By.xpath("//div[@class='auth-login-widget']//following::div[17]"));
	clickRecaptcha.click();
	
	Thread.sleep(5000);
	
	WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
	loginButton.click();
	
	Giftcardmall_ImageandTextDownload2 imgtxt=new Giftcardmall_ImageandTextDownload2();
	imgtxt.imgandTextDown();
		
		
	}
	
	

}
