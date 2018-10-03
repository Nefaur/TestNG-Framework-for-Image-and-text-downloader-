package com.business.giftrbeta.framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertyReaderService {
	
	private static PropertyReaderService instance = null;
	private Properties properties = new Properties();
	private Map<String, String> envVariable = System.getenv();
	
	private PropertyReaderService() {
		load();
	}
	
	public static PropertyReaderService getInstance() {
		if(instance == null) {
			instance = new PropertyReaderService();
		}
		return instance;
	}

	public String getProperty(String key) {
		String value = properties.getProperty(key);
		return value;
	}
	public String getEnvProperty(String key) {
		String value = null;
		if(envVariable.containsKey(key)) {
			value = envVariable.get(key);
		}
		return value;
	}
	private void load(){	
		
		InputStream input = null;

		try {

			input = new FileInputStream("I:\\eclipse-workspace\\GiftRbeta\\Resources\\Config.properties");
			// load a properties file
			properties.load(input);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}
	public static String browserTorun() {
	PropertyReaderService startbrowser=PropertyReaderService.getInstance();
	String selbrowser=startbrowser.getProperty("browser");
    return selbrowser;
	}

	public static String websiteTotest() {
		PropertyReaderService testURL=PropertyReaderService.getInstance();
		String selURL=testURL.getProperty("testUrl");
	    return selURL;
	}
	
	public static String excelFile() {
		PropertyReaderService exceltestfile=PropertyReaderService.getInstance();
		String testfile=exceltestfile.getProperty("excelfile");
	    return testfile;
	}
	
	public static String excelFiletowrite() {
		PropertyReaderService excelwritefile=PropertyReaderService.getInstance();
		String testfile=excelwritefile.getProperty("excelfiletowrite");
	    return testfile;
	}
	
	public static String filename() {
		PropertyReaderService filename=PropertyReaderService.getInstance();
		String testfile=filename.getProperty("excelfilename");
	    return testfile;
	    
	}
	
	public static String writefilename() {
		PropertyReaderService filename=PropertyReaderService.getInstance();
		String testfile=filename.getProperty("excelwritefilename");
	    return testfile;
	    
	}
}

