package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(name = "email")
	@CacheLookup
    public WebElement username;
	
	@FindBy(name = "password")
	@CacheLookup
	public WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	@CacheLookup
	public WebElement signInButton;
	
	@FindBy(xpath = "//*[@type='scotiabankEn']")
	public WebElement crmLogo;
	
	// Initialization of page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
    //Actions
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
//	public boolean validateScLogo() {
//		return scLogo.isDisplayed();
//	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInButton.click();
		return new HomePage();
	}	
}
