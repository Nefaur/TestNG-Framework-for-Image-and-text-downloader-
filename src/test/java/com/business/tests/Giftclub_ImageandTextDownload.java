package com.business.tests;

import static org.junit.Assert.assertArrayEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.business.giftrbeta.framework.ExcelReader;
import com.business.giftrbeta.framework.ExcelWriter;
import com.business.giftrbeta.framework.ImageDownloader;
import com.business.giftrbeta.framework.JavaScriptActions;
import com.business.giftrbeta.framework.PropertyReaderService;
import com.business.giftrbeta.framework.ScriptBase;

import junit.framework.Assert;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;

public class Giftclub_ImageandTextDownload extends Giftclub_Login{
	

	@Test
	public void imgandTextDown(WebDriver driver) throws Exception {
	Thread.sleep(5000);
	JavaScriptActions js=new JavaScriptActions();
	js.javaClick(driver,"//span[@class='hidden-tab']");
		
	System.out.println(driver.getCurrentUrl());
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='link-gray']")));
		
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	js.scrollTobottom(driver);
			
	List<WebElement> imagename=driver.findElements(By.xpath("//a[@class='link-gray']"));
	int number=imagename.size();
	System.out.println("Total number of Gift card names found= "+number);
	
	java.util.Iterator<WebElement> im = imagename.iterator();
	while(im.hasNext()) {
	    WebElement row = im.next();
	    String names=row.getText();
	    System.out.println(names);
	
//	    ExcelWriter eWriter=new ExcelWriter();
//	    eWriter.ExcelWriter(names);
	}
//	
	ImageDownloader imageDownloader=new ImageDownloader();
	imageDownloader.downloadimage("//img[contains(@alt,'Gift Card')]", "data-src","alt","png",driver);
	
    
	
	}
	}




