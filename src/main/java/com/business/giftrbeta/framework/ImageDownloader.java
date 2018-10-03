package com.business.giftrbeta.framework;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.business.tests.Giftclub_ImageandTextDownload;





public class ImageDownloader extends ScriptBase{
	
	public void downloadimage(String xpathforElements,String attribute, String imagename, String imageformat, WebDriver driver) throws IOException, IIOException{
	  
	  List <WebElement> listofItems = driver.findElements(By.xpath(xpathforElements));
	    URL imageURL = null;
	    for(WebElement myElement : listofItems) {
	        String j = myElement.getAttribute(attribute);
	        String z = myElement.getAttribute(imagename);
	        System.out.println(j);
	        imageURL = new URL(j);
	        try {
	        BufferedImage saveImage = ImageIO.read(imageURL);         
			ImageIO.write(saveImage, imageformat, new File(z + "."+imageformat));
			} catch (Exception e) {
				System.out.println("Error found in file: "+z);
				e.printStackTrace();
			}
	  	    }
}
}
