package com.training.test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	
	
	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	String url;
	String username;
	String password;
	String hometab;
	
	@BeforeMethod
	public void beforeTest() throws IOException {
		
		 driver = getDriver(); 
		 url = common.getApplicationProperty("url");
		 username = common.getApplicationProperty("username");
		 password = common.getApplicationProperty("password");
		 hometab=common.getApplicationProperty("hometab");
		 driver.get(url);
		 login = new LoginPage(driver);
		 home=new HomePage(driver);
		 windowmaximise();
		 DOMConfigurator.configure("log4j.xml");
	}
	
	@Test(priority=1)
	public void validateLoginerrorbypassworderror() {
		try{
		log.info("Testcase1 started");
		login.enterintoUsername(username);
		log.info("username entered");
		login.clearpassword();
		log.info("password cleared");
		login.clickloginButton();
		log.info("login button clicked");
		login.validateerror();
		}catch(Exception e) {
		log.error(e.toString());
		}
	}
	
	
	@Test(priority=2)
	public void validateLoginenterintoapplication() {
		try{
			log.info("Testcase2 started");
		 	login.enterintoUsername(username);
		    log.info("username entered");
	    	login.enterintoPassword(password);
		    log.info("password entered");
		    login.clickloginButton();
		    log.info("login button clicked");
		    log.info("Login Successful");
		    home.ishomepagedisplayed(hometab);
		}catch(Exception e) {
			log.error(e.toString());
		}
	}
	
	@Test(priority=3)
	public void testremembermebuttonclicked() throws InterruptedException {
		try{
		log.info("Testcase3 Started");
		login.enterintoUsername(username);
		login.enterintoPassword(password);
		log.info("username and password entered");
		login.clickremembermeradio();
		log.info("rememeberme box checked");
		login.clickloginButton();
		log.info("login button clicked");
		home.ishomepagedisplayed(hometab);
		log.info("Checking if homepage is displayed");
		home.clickusermenu();
		log.info("home page opened and usermenu clicked");
		home.clicklogout();
		log.info("logout clicked");
		login.waituntilelementlocated();
		login.validateusername();
		log.info("old username is compared with new username");
		}catch(Exception e) {
			log.error(e.toString());
		}
		
	}
	
	@Test(priority=4)
	public void testforgotpassword() {
		try{
			log.info("Testcase 4a started");
		
		login.enterintoUsername(username);
		log.info("username entered");
		login.clickonforgotpassword();
		log.info("forgot password link clicked");
		log.info("password reset page opened");
		login.enteremailid();
		log.info("Email Id entered");
		login.clickcontinue();
		log.info("continue button clicked");
		}catch(Exception e) {
			log.error(e.toString());
		}
	}
	
	@Test(priority=5)
	public void validateloginerrormessage() {
		try{
			log.info("Testcase 4b started");
		login.enterintoUsername("123");
		log.info("wrong username entered");
		login.enterintoPassword("22131");
		log.info("wrong password entered");
		login.clickloginButton();
		log.info("login button clicked");
		login.validateerrorloginmsg();
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

