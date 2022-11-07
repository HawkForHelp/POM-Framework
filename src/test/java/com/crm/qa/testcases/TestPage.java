package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TestPage extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	String sheetName = "contacts";

	public TestPage() {
		super();
	}
	

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		
		initialization();
		tu = new TestUtil();
		cp = new ContactsPage();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		cp = hp.clickOnContactsLink();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = tu.getTestData(sheetName);
		return data;
	}
	
//	@Test(priority=1)
//	public void verifyContactsPageLabel(){
//		Assert.assertTrue(cp.verifyContactsLabel(), "Contacts label is missing");
//	}
	
	@Test(priority=4)
	public void validateCreateNewContact(String firstName, String lastName, String company){
		hp.clickOnNewContactLink();
		//cp.createNewContact(firstName, lastName, company);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
