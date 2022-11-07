package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	
	@FindBy(xpath = "//span[@class='user-display']")
	//@CacheLookup
	public WebElement userNameLbl;
			
	@FindBy(id = "main-nav")
	public WebElement sideBar;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	public WebElement contactsLink;
	
	@FindBy(xpath = "//body/div[@id='ui']/div[@class='ui fluid container']/div[@id='main-nav']/div[3]/button[1]")
	public WebElement newContactLink;
	

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	public WebElement dealsLink;

	@FindBy(xpath = "//span[contains(text(),'Tasks')]")
	public WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyCorrectUserName(){
		return userNameLbl.getText();
	}
	
	public ContactsPage clickOnContactsLink() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(sideBar).build().perform();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(sideBar).build().perform();
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(sideBar).build().perform();
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(sideBar).build().perform();
		newContactLink.click();
		
	}
	
	
}
