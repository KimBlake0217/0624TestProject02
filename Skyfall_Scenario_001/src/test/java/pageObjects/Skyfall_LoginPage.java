package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Skyfall_LoginPage {
	public WebDriver ldriver;
	ChromeOptions co = new ChromeOptions();
	
//	public Skyfall_LoginPage(WebDriver rdriver)
//	{
//		ldriver=rdriver;
//		PageFactory.initElements(rdriver, this);
//	}	
	
	public Skyfall_LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		ChromeOptions co = new ChromeOptions();
		co.setHeadless(true);	
		
	}
		
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "/html/body/app-root/mi-login-main/mi-login/div/div[1]/div/form/nz-form-item[1]/nz-form-control/div/div/nz-input-group/input")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath = "/html/body/app-root/mi-login-main/mi-login/div/div[1]/div/form/nz-form-item[2]/nz-form-control/div/div/nz-input-group/input")
	@CacheLookup
	WebElement txtPassword;
	
	//@FindBy(xpath="//input[@value='Log In']")
	@FindBy(xpath = "/html/body/app-root/mi-login-main/mi-login/div/div[1]/div/form/button/span")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/app-root/div/div/nz-tabset/nz-tabs-nav/div[2]/mi-global-header-item/div/nz-avatar[1]")
	@CacheLookup
	WebElement btnUser;
	
	@FindBy(xpath = "//*[@id=\"cdk-overlay-5\"]/div/ul") 
	WebElement lnkLogout;
	
	
	public void setUserName(String uname) {
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setUserName2(String uname2) {
		userName.clear();
		userName.sendKeys(uname2);
	}
	
	public void setPassword(String pwd) {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickUser() {
		btnUser.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
}
