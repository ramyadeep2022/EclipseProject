package com.training.test;

import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.UserMenuPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;


public class UserMenuTest extends BaseTest {

	WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	HomePage home;
	BasePage BasePage;
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
		BasePage=new BasePage(driver);
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
	  home.validatedropdownmenu();
	  log.info("Validating the actualo dropdownmenu with the expected dropdown menu");
	  
	  }
	 
 @Test
	  
	  public void performmyprofileoptions() {
	  try{
	  log.info("Testcase 6 started");
	  login.enterintoUsername(username);
	  log.info("Username entered");
	  login.enterintoPassword(password);
	  log.info("password entered");
	  login.clickloginButton();
	  log.info("Login button clicked");
	  home.clickusermenu();
	  log.info("Usermenu dropdown clicked");
	  home.clickmyprofileoption();
	  log.info("My Profile option is clicked");
	  usermenu.clickeditbutton();
	  log.info("Edit button is clicked");
	  usermenu.switchtoeditframe();
	  usermenu.clickabouttab();
	  log.info("About tab is clicked");
	  usermenu.updatelastname();
	  log.info("Lastname is changed");
	  usermenu.clicksaveall();
	  log.info("Save All Button clicked");
	  takeScreenShot(driver);
	  usermenu.clickPostcomment();
	  log.info("Post Link clicked");
	  usermenu.switchpostframe();
	  usermenu.enterintoposteditor();
	  log.info("Enter text into the Post Editor");
	  usermenu.clicksharebutton();
	  log.info("Share button is clicked and message is posted");
	  BasePage.waitdriver(usermenu.FileLink);
	  takeScreenShot(driver);
	  usermenu.clickfilelink();
	  log.info("File Link is clicked");
		 
		  usermenu.clickonfileuploadlink();
		  log.info("Upload file from computer link is clicked");
		  usermenu.selectfilefromcomputer(); 
		  log.info("select file from computer");
		  Thread.sleep(2000);
		  usermenu.clicksharebutton();
		  log.info("Share button is clicked and message is posted");
		  takeScreenShot(driver);
		 
	  usermenu.mouseovertophoto();
	  log.info("Moving the mouse to the photo");
	  usermenu.clickupdatebutton();
	  log.info("Update Link is clicked");
	  usermenu.Switchtophotoframe();
	  log.info("Switiching to the Photo upload frame");
	  usermenu.Selectthephoto();
	  log.info("choosephoto is selected");
	  usermenu.clicksavebutton();
	  log.info("Save Button is clicked");
	  usermenu.switchtophotocropframe();
	  log.info("Switchingto photocrop Frame");
	  usermenu.clickphotoeditorsavebutton();
	  log.info("Save Button is clicked after image cropping");
	  }catch(Exception e) {
		  log.error(e.toString());
	  }
	  }
	 
 @Test
 
 public void performmysettingsoptions() {
 try{
 log.info("Testcase 7 started");
 login.enterintoUsername(username);
 log.info("Username entered");
 login.enterintoPassword(password);
 log.info("password entered");
 login.clickloginButton();
 log.info("Login button clicked");
 home.clickusermenu();
 log.info("Usermenu dropdown clicked");
 home.clickmysettingsoption();
 log.info("My Settings option is clicked");
 usermenu.clickpersonaltab();
 log.info("Personal Tab is selected");
 usermenu.clickloginhistorytab();
 log.info("Login History Tab is selected");
 usermenu.clickdownloadhistorylink();
 log.info("Download Login History link is clicked");
 usermenu.clickdisplaylayouttab();
 log.info("Display & Layout Tab is selected");
 usermenu.clickcutomizemytab();
 log.info("Customize My Tab is clicked");
 }catch(Exception e) {
	  log.error(e.toString());
 }
 }

 
@Test
 
 public void performdeveloperconsoleoptions() {
 try{
 log.info("Testcase 8 started");
 login.enterintoUsername(username);
 log.info("Username entered");
 login.enterintoPassword(password);
 log.info("password entered");
 login.clickloginButton();
 log.info("Login button clicked");
 home.clickusermenu();
 log.info("Usermenu dropdown clicked");
 home.clickdeveloperconsoleoption();
 log.info("Developer Console option is clicked");
 usermenu.switchtodeveloperconsolewindow();
 log.info("Switch to Developer Console window");
 usermenu.closedeveloperconsolewindow();
 log.info("Developer Console is closed");
 
 }catch(Exception e) {
	  log.error(e.toString());
 }
 }

@Test

public void performlogoutoption() {
try{
log.info("Testcase 9 started");
login.enterintoUsername(username);
log.info("Username entered");
login.enterintoPassword(password);
log.info("password entered");
login.clickloginButton();
log.info("Login button clicked");
home.clickusermenu();
log.info("Usermenu dropdown clicked");
home.clicklogout();
log.info("Logout option is clicked");
login.validateafterlogout();
log.info("Validation after logout is done");

}catch(Exception e) {
	  log.error(e.toString());
}
}

@AfterMethod
public void teardown() {
	System.out.println("After method");
	takeScreenShot(driver);
	//driver.close();
}
}
