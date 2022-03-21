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
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.pages.OpportunitiesPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;



public class LeadsTest extends BaseTest{

WebDriver driver;
CommonUtilities common = new CommonUtilities();
LoginPage login;
HomePage home;
UserMenuPage usermenu;
AccountsPage account;
OpportunitiesPage opty;
LeadsPage lead;
String url;
String username;
String password;
String hometab;
String leadtab;

@BeforeMethod
public void beforeTest() throws IOException {
	
	driver = getDriver(); 
	url = common.getApplicationProperty("url");
	username = common.getApplicationProperty("username");
	password = common.getApplicationProperty("password");
	 hometab=common.getApplicationProperty("hometab");
	 leadtab=common.getApplicationProperty("Leadstab");

	driver.get(url);
	login = new LoginPage(driver);
	home=new HomePage(driver);
	usermenu = new UserMenuPage(driver);
	account=new AccountsPage(driver);
	opty=new OpportunitiesPage(driver);
	lead=new LeadsPage(driver);
	 windowmaximise();
	DOMConfigurator.configure("log4j.xml");
}

@Test
public void validateleadspagelaunched() {
try{
log.info("Testcase 20 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickleadstab();
log.info("Leads Tab is clicked");
closepopup();
log.info("Popup is closed");
lead.isleadpagedisplayed(leadtab);
log.info("Validating if the Leads home page is displayed");

}catch(Exception e) {
	  log.error(e.toString());
}
}
  

@Test
public void validatedropdownview() {
try{
log.info("Testcase 21 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickleadstab();
log.info("Leads Tab is clicked");
closepopup();
log.info("Popup is closed");
lead.isleadpagedisplayed(leadtab);
log.info("Validating if the Leads home page is displayed");
 lead.clickdropdownview();
 log.info("Dropdown view is clicked");
 lead.validatedropdownoptions();
 log.info("Validating the dropdown view options");
}catch(Exception e) {
	  log.error(e.toString());
}
} 
  
@Test
public void checkfunctionalityofgobutton() {
try{
log.info("Testcase 22 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickleadstab();
log.info("Leads Tab is clicked");
closepopup();
log.info("Popup is closed");
lead.isleadpagedisplayed(leadtab);
log.info("Validating if the Leads home page is displayed");
 lead.clickdropdownview();
 log.info("Dropdown view is clicked");
 lead.selectfromdropdown();
 log.info("My Unread Leads option is selected");
 home.clickusermenu();
 log.info("usermenu is clicked");
 home.clicklogout();
 log.info("Logout option is clicked");
  Thread.sleep(3000);
 login.enterintousername(username);
 log.info("enter the username");
 login.enterintoPassword(password);
 log.info("Enter the password");
login.clickloginButton();
log.info("click the login button");
home.clickleadstab();
log.info("Leads Tab is clicked");
lead.isleadpagedisplayed(leadtab);
log.info("Validating if the Leads home page is displayed");
lead.validateselectedoption();
log.info("validating the selected option is selected after logging back to the url again");

lead.clickgobutton();
log.info("click on go button");
}catch(Exception e) {
	  log.error(e.toString());
}
} 

@Test
public void teststuckopportunitiesreport() {
try{
log.info("Testcase 18 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickopportunitiestab();
log.info("Opportunities Tab is clicked");
closepopup();
log.info("Popup is closed");
opty.clickstuckopportunitites();
log.info("Stuck Opportunities link is clicked under reports");
opty.validatestuckoptyreport(); 
log.info("validating Stuck Opportunities report");
 
}catch(Exception e) {
	  log.error(e.toString());
}
} 

@Test
public void testquarterlysummaryreport() {
try{
log.info("Testcase 19 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.ishomepagedisplayed(hometab);
log.info("validating if hometab is displayed");
home.clickopportunitiestab();
log.info("Opportunities Tab is clicked");
closepopup();
log.info("Popup is closed");
opty.selectnextFQ();
log.info("Select NextFQ in the Quartely Summary Interval dropdown");
opty.selectopenopportunities();
log.info("Select Open Opportunities in the Quartely Summary Include dropdown");
opty.clickrunreportbutton();
log.info("Runreport button is clicked");

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
