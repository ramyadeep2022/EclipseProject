package com.training.test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.AccountsPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class AccountsTest extends BaseTest{


WebDriver driver;
CommonUtilities common = new CommonUtilities();
LoginPage login;
HomePage home;
UserMenuPage usermenu;
AccountsPage account;
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
	usermenu = new UserMenuPage(driver);
	account=new AccountsPage(driver);
	 windowmaximise();
	DOMConfigurator.configure("log4j.xml");
}

@Test
public void performaccountsoptions() {
try{
log.info("Testcase 10 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickaccountstab();
log.info("Accounts Tab is clicked");
closepopup();
log.info("Popup is closed");
account.clicknewbutton();
log.info("New Button on Account page is clicked");
account.enterintoaccountname();
log.info("Account Name is entered");
account.clicktypedropdown();
log.info("Type dropdown is clicked");
account.selecttypedropdown();
log.info("Type dropdown value is selected");
account.selectprioritydropdown();
log.info("Priority dropdown value is selected");
account.clicksavebutton();
log.info("Save Button is clicked");
account.validateAccountPage();
log.info("Validating the account page is displayed with the new account name");
}catch(Exception e) {
	  log.error(e.toString());
}
}
  

@Test
public void createnewaccountsview() {
try{
log.info("Testcase 11 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickaccountstab();
log.info("Accounts Tab is clicked");
closepopup();
log.info("Popup is closed");
account.clickcreatenewview();
log.info("Create New view link on Accounts page is clicked");
account.clickviewname();
log.info("View Name is clicked");
account.enterintoviewname();
log.info("View Name is entered");
account.clickuniquename();
log.info("Unique Name is clicked");
account.clicksaveviewbutton();
log.info("Save Button is clicked");
account.validateviewdropdown();
log.info("Validating the new view name is displayed in the view dropdown ");
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

