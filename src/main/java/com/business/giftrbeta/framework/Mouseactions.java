package com.business.giftrbeta.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mouseactions {

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions mhover=new Actions(driver);
		mhover.moveToElement(element).click().build().perform();
	}
	
}
