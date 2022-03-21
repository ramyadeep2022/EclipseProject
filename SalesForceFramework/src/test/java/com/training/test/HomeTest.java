package com.training.test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest {

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	UserMenuPage usermenu;
	String url;
	String username;
	String password;
	
	@BeforeMethod
	public void beforeTest() throws IOException {
		
		driver = getDriver(); 
		url = common.getApplicationProperty("url");
		username = common.getApplicationProperty("username");
		password = common.getApplicationProperty("password");
		driver.get(url);
		login = new LoginPage(driver);
		home=new HomePage(driver);
		usermenu = new UserMenuPage(driver);
		 windowmaximise();
		DOMConfigurator.configure("log4j.xml");
	}
	
	  @Test
	  
	  public void validatusermenudropdown() {
	  log.info("Testcase 5 started");
	  login.enterintoUsername(username);
	  log.info("Username entered");
	  login.enterintoPassword(password);
	  log.info("password entered");
	  login.clickloginButton();
	  log.info("Login button clicked");
	  home.clickusermenu();
	  log.info("Usermenu dropdown clicked");
	 try {
		 home.validatedropdownmenu();
		 log.info("Validating the actualo dropdownmenu with the expected dropdown menu");
	 }catch(Exception e) {
	  log.error(e.toString());
	  
	  }
	  }
	 

		@AfterMethod
		public void teardown() {
			System.out.println("After method");
			takeScreenShot(driver);
			driver.close();
		}
}
