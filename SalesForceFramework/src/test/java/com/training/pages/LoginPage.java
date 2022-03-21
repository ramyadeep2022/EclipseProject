
package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;



public class LoginPage extends BasePage {
	
	 public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="Login")
	WebElement loginButton;
	
	@FindBy(name="rememberUn")
	WebElement rememberme;
	
	@FindBy(id="idcard-identity")
	WebElement NewUserName;
	
	
	@FindBy(id="forgot_password_link")
	WebElement ForgotPwd;
	
	@FindBy(id="un")
	WebElement EmailId;
	
	@FindBy(name="continue")
	WebElement Continue;
	
	@FindBy(id="error")
	WebElement ErrorMsg;
	
	String expectedusername="";
	
    public void clickonforgotpassword() {
    	ForgotPwd.click();
    }
    
	public void enterintoUsername(String strUserName) {
		Username.sendKeys(strUserName);
	}


	public void enterintoPassword(String strPassword) {
		Password.sendKeys(strPassword);
	}


	public void clickloginButton() {
		loginButton.click();
	}
	
	
	
	public void validateerror() {
		
		String actualerrmsg=ErrorMsg.getText();
		String expectederrmsg="Please enter your password.";
		validateassertion(actualerrmsg,expectederrmsg);
	}


	public void clearpassword() {
		Password.clear();
	}

    public void clickremembermeradio() {
	rememberme.click();
}
    public void validateafterlogout() {
    	String ActualUrl=driver.getCurrentUrl().toString();
    	String ExpectedUrl="https://login.salesforce.com/";
    	System.out.println(ActualUrl);
    	validateassertion(ActualUrl,ExpectedUrl);
    }
    
    
    
    public void validateusername() {
    	   
    	   
    	    waitdriver(NewUserName);
    	    String actualuser=NewUserName.getText();
    	    expectedusername="ramya@kopp.com";
    	    System.out.println("actualuser : " + actualuser);
    	    System.out.println("expecteduser : " + expectedusername);
    	    validateassertion(actualuser,expectedusername);
    }
    
    public void enteremailid() {
    	EmailId.sendKeys("ramyadeepika1984@gmail.com");
    	
    }
    
    public void clickcontinue() {
    	Continue.click();
    }
    
    public void validateerrorloginmsg() {
    	String actualerrmsg=ErrorMsg.getText();
    	String expectederrmsg="Your login attempt has failed. The username or password may be incorrect, or your location or login time may be restricted. Please contact the administrator at your company for help";
    	System.out.println(actualerrmsg+expectederrmsg);
    	validateassertion(actualerrmsg, expectederrmsg);
    }
    
    public void waituntilelementlocated() {
    	WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idcard-identity")));
    }

	public void enterintousername(String strname) {
		// TODO Auto-generated method stub
		Username.sendKeys(strname);
	}
}
