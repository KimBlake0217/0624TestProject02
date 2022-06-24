package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//import javax.xml.xpath.XPath;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import pageObjects.Skyfall_LoginPage;

public class Skyfall_Steps_01 extends Skyfall_BaseClass {
	
	@Before
	public void setup() throws IOException
	{		
		//Logger
		logger=Logger.getLogger("Skyfall-PCS"); //Added logger
		PropertyConfigurator.configure("Log4j.properties"); //Added logger
		
		//Reading properties
		configProp=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configProp.load(configPropfile);
				
		String br=configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
		driver = new FirefoxDriver();
		}	
		else if(br.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
		driver = new InternetExplorerDriver();
		}		
		
		logger.info("***** Launching browser *****");
	}
	
	@Given("^User Launch Chrome browser$")
	public void user_launch_chrome_browser() {
		//No more use because of Hook
//		logger=Logger.getLogger("nopCommerce"); //Added logger
//		PropertyConfigurator.configure("Log4j.properties"); //Added logger
//		
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		logger.info("***** Launching browser *****");
		Slp = new Skyfall_LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		logger.info("***** Opening URL *****");
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}

	@And("User enters Username as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String password) {
		logger.info("***** Providing login details *****");
		Slp.setUserName2(uname);
		Slp.setPassword(password);

	}

	@And("Click on Login")
	public void click_on_login() throws InterruptedException {
		logger.info("***** Started login *****");
		Slp.clickLogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Log in to your account using ID & password.")) {
			driver.close();
			Thread.sleep(3000);
			logger.info("***** Login failed *****");			
			Assert.assertTrue(false);
			//Assert.assertTrue("Verification failed: title is not same.",title.equals(driver.findElement(By.xpath("/html/head/title")).getText()));
			//Assert.assertNotEquals(title, driver.getTitle());
			//driver.close();
		} else {
			logger.info("***** Login passed *****");
			Assert.assertEquals(title, driver.getTitle());
	
			
		}
		Thread.sleep(3000);
	}
	
	@When("User click on User Image")
	public void user_click_on_user_image() throws InterruptedException {
		logger.info("***** Click on User Image *****");
		Slp.clickUser();
		Thread.sleep(1000);
	}

//	@Then("User click on Logout")
//	public void user_click_on_log_out_link() throws InterruptedException {
//		logger.info("***** Click on logout link *****");
//		Slp.clickLogout();
//		Thread.sleep(3000);
//		Assert.assertSame(driver.findElement(By.xpath("/html/body/div/div[2]")), driver.findElement(By.xpath("/html/body/div/div[2]")));
//	
//	}
	
	
	@Then("User click on Logout")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("***** Click on logout link *****");
		
		try {
			Slp.clickLogout();
			Thread.sleep(3000);
		} catch (Exception e) {
			
			System.err.println("...There is an error at Slp.clickLogout()...");
			
		}
//		Assert.assertSame(driver.findElement(By.xpath("/html/body/div/div[2]")), driver.findElement(By.xpath("/html/body/div/div[2]")));
	
	}
	
	

	@And("close browser")
	public void close_browser() {
		logger.info("***** closing browser *****");
		driver.quit();
	}

	// Customers feature step
	// definitions..............................................

//	@Then("USer can view Dashboard")
//	public void user_can_view_Dashboard() {
//
//		addCust = new AddcustomerPage(driver);
//		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
//	}
//
//	@When("User click on customers Menu")
//	public void user_click_on_customers_Menu() throws InterruptedException {
//		Thread.sleep(3000);
//		addCust.clickOnCustomersMenu();
//	}
//
//	@When("click on customers Menu Item")
//	public void click_on_customers_Menu_Item() throws InterruptedException {
//		Thread.sleep(2000);
//		addCust.clickOnCustomerMenuItem();
//	}
//
//	@When("click on Add new button")
//	public void click_on_Add_new_button() throws InterruptedException {
//		addCust.clickOnAddnew();
//		Thread.sleep(2000);
//	}
//
//	@Then("User can view Add new customer page")
//	public void user_can_view_Add_new_customer_page() {
//		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
//	}
//
//	@When("User enter customer info")
//	public void user_enter_customer_info() throws InterruptedException {
//		
//		logger.info("***** Adding new customer *****");
//		logger.info("***** Providing customer details *****");
//		String email = randomstring() + "@gmail.com";
//		addCust.setEmail(email);
//		addCust.setPassword("test123");
//		// Registered - default
//		// The customer cannot be in both 'Guest' and 'Registered' customer roles
//		// Add the customer to 'Guest' or 'Registered' customer role
//		//driver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
//		addCust.setCustomerRoles("Guest");
//		Thread.sleep(3000);
//
//		addCust.setManagerOfVendor("Vendor 2");
//		addCust.setGender("Male");
//		addCust.setFirstName("Pavan");
//		addCust.setLastName("Kumar");
//		addCust.setDob("7/05/1985"); // Format: D/MM/YYYY
//		addCust.setCompanyName("busyQA");
//		addCust.setAdminContent("This is for testing........");
//
//	}
//
//	@When("click on Save button")
//	public void click_on_Save_button() throws InterruptedException {
//		logger.info("***** Saving customer data *****");
//		addCust.clickOnSave();
//		Thread.sleep(2000);
//	}
//
//	@Then("User can view confirmation message {string}")
//	public void user_can_view_confirmation_message(String msg) {
//		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
//				.contains("The new customer has been added successfully."));
//	}
//
//	// steps for searching a customer using Email ID...
//	@When("Enter customer EMail")
//	public void enter_customer_EMail() {
//		
//		logger.info("***** Searching customer by email id *****");
//		searchCust = new SearchCustomerPage(driver);
//		searchCust.setEmail("victoria_victoria@nopCommerce.com");
//	}
//
//	@When("Click on search button")
//	public void click_on_search_button() throws InterruptedException {
//		searchCust.clickSearch();
//		Thread.sleep(3000);
//	}
//
//	@Then("User should found Email in the Search table")
//	public void user_should_found_Email_in_the_Search_table() {
//		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
//		Assert.assertEquals(true, status);
//	}
//	
//	//steps for searching a customer by using First Name & Last Name
//
//	@When("Enter customer FirstName")
//	public void enter_customer_FirstName() {
//		
//		logger.info("***** Searching customer by Name *****");
//		searchCust = new SearchCustomerPage(driver);
//		searchCust.setFirstName("Victoria");
//	}
//
//	@When("Enter customer LastName")
//	public void enter_customer_LastName() {
//		searchCust.setLastName("Terces");
//	}
//
//	@Then("User should found Name in the Search table")
//	public void user_should_found_Name_in_the_Search_table() {
//		boolean status=searchCust.searchCustomerByName("Victoria Terces");
//		Assert.assertEquals(true, status);
//		
//	}
//	
}
