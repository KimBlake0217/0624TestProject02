package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Skyfall_LoginPage;

public class Skyfall_BaseClass {
	
	public WebDriver driver;
	public Skyfall_LoginPage Slp;
	public static Logger logger;
	public Properties configProp;
	
	//Created for generating random string for Unique email
	public static String randomstring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	// WebDriverManager
//	public static void wdManager(String url) {
//		ChromeOptions co = new ChromeOptions();
//		co.setHeadless(true);
//		WebDriver driver = WebDriverManager.chromedriver().create();
//		driver.get(url);
//	}
	
}
