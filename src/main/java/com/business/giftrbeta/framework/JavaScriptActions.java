package com.business.giftrbeta.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptActions{
		
	public void javaClick(WebDriver driver, String element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		WebElement elementtoClick=driver.findElement(By.xpath(element));
		js.executeScript("arguments[0].click()",elementtoClick);	
	}

	public void scrollTobottom(WebDriver driver) {
	((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
}

	public void waitforElement(WebDriver driver, String path) {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",path);
}
}


