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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.business.giftrbeta.framework.ExcelReader;
import com.business.giftrbeta.framework.ExcelWriter;
import com.business.giftrbeta.framework.ImageDownloader;
import com.business.giftrbeta.framework.PropertyReaderService;
import com.business.giftrbeta.framework.ScriptBase;

import junit.framework.Assert;

public class Giftcardmall_ImageandTextDownload2 extends Giftcardmall_Login{
	
	
	
	@Test
	public void imgandTextDown() throws Exception {
	
	driver.get("https://www.giftcardmall.com/store-card-gallery?page=1&sort=orderingField_desc&itemsPerPageDropDown=800");
	
	System.out.println(driver.getCurrentUrl());
		
	WebDriverWait wait = new WebDriverWait(driver, 50);
//	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='rd-offer-photo-img lazyload']")));
	
	WebElement norton=driver.findElement(By.xpath("//img[@alt='Norton Secuered']"));
	((JavascriptExecutor) driver)
    .executeScript("arguments[0].scrollIntoView(true);",norton);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
	
	
	List<WebElement> imagename=driver.findElements(By.xpath("//h2[contains(text(),'Gift Card')]"));
	int number=imagename.size();
	System.out.println("Total number of Gift card names found= "+number);
	
	java.util.Iterator<WebElement> im = imagename.iterator();
	while(im.hasNext()) {
	    WebElement row = im.next();
	    String names=row.getText();
	    System.out.println(names);
	
	    ExcelWriter eWriter=new ExcelWriter();
	    eWriter.ExcelWriter(names);
	}
//	
	ImageDownloader imageDownloader=new ImageDownloader();
	imageDownloader.downloadimage("//img[contains(@alt,'Gift Card')]", "src","alt","png",driver);
	
	
        
//	List<WebElement> imagefile=driver.findElements(By.xpath("//img[contains(@alt,'Gift Card')]"));
//	Assert.assertEquals(number, imagefile.size());
//	for(WebElement imageFromList:imagefile){
//	     String ImageUrl=imageFromList.getAttribute("src");
//	     System.out.println(ImageUrl); //will get you all the image urls on the page
//   
    
	
	}
	}




