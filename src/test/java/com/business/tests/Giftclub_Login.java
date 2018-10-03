package com.business.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.business.giftrbeta.framework.JavaScriptActions;
import com.business.giftrbeta.framework.PropertyReaderService;
import com.business.giftrbeta.framework.ScriptBase;

import junit.framework.Assert;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;

public class Giftclub_Login extends ScriptBase {
	
	@Test
	public void Login() throws Exception {
		
	String web=PropertyReaderService.websiteTotest();
	driver.get(web);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	String user=PropertyReaderService.getInstance().getProperty("username");
	String password=PropertyReaderService.getInstance().getProperty("password");
	
	Thread.sleep(5000);
	
	JavaScriptActions js=new JavaScriptActions();
	js.javaClick(driver, "//a[contains(text(),'Sign In')]");
	
	WebElement emailInput=driver.findElement(By.xpath("//input[@id='form_login_email']"));
	emailInput.sendKeys(user);
	
	WebElement passwordInput=driver.findElement(By.xpath("//input[@id='form_login_password']"));
	passwordInput.sendKeys(password);
		
	WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
	loginButton.click();
	
	String memberURL=driver.getCurrentUrl();
	System.out.println(memberURL);
	Assert.assertEquals("https://www.giftcards.com/member", memberURL);
	
	Giftclub_ImageandTextDownload load=new Giftclub_ImageandTextDownload();
	load.imgandTextDown(driver);
	
	}
	
	

}
