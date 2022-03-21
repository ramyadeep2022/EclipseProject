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
import com.training.pages.OpportunitiesPage;
import com.training.pages.UserMenuPage;
import com.training.utilities.CommonUtilities;

public class OpportunitiesTest extends BaseTest {

WebDriver driver;
CommonUtilities common = new CommonUtilities();
LoginPage login;
HomePage home;
UserMenuPage usermenu;
AccountsPage account;
OpportunitiesPage opty;
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
	opty=new OpportunitiesPage(driver);
	 windowmaximise();
	DOMConfigurator.configure("log4j.xml");
}

@Test
public void validateopportunitiesdropdown() {
try{
log.info("Testcase 15 started");
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
opty.clickoptydropdown();
log.info("Opportunities dropdown is clicked");
opty.validateoptydropdown();
log.info("Validating the Opportunities dropdown options");
}catch(Exception e) {
	  log.error(e.toString());
}
}
  

@Test
public void createnewopportunity() {
try{
log.info("Testcase 16 started");//notdonecompletely
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
opty.clicknewbutton();
log.info("New button is clicked to create new opportunity");
opty.enterintoopportunityname(); 
log.info("Opportunity Name is clicked");
 opty.enterintoaccountname();
 log.info("Account Name is entered");
 
}catch(Exception e) {
	  log.error(e.toString());
}
} 
  
@Test
public void testopportunitypipelinereport() {
try{
log.info("Testcase 17 started");
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
opty.clickopportunitypipeline();
log.info("Opportunity Pipeline link is clicked under reports");
opty.validateOptypipelinereport(); 
log.info("validating Opportunity Pipeline report");
 
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
