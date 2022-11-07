package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();// it will call super class constructor before running anything else
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();//object of login page class
		log.info("Entering URL");
		log.warn("Hey this just a warning message");
		log.fatal("Fatal error occured");
		log.debug("This is debug message");
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = lp.validateLoginPage();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
//	@Test(priority = 2)
//	public void ScotiaLogoTest() {
//		boolean flag = lp.validateScLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority = 3)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//driver.findElement(By.)
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Broswer is closed");
	}
}
