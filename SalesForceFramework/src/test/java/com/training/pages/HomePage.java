package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Log;
import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@title='Home Tab']")
	WebElement HomeTab;
	
	@FindBy(id="Opportunity_Tab")
	WebElement OpportunitiesTab;
	
	@FindBy(xpath="//a[@title='Accounts Tab']")
	WebElement AccountsTab;
	
	@FindBy(xpath="//a[contains(text(),'Leads')]")
	WebElement LeadsTab;
	
	@FindBy(id="userNav")
	WebElement Usermenu;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement MyProfile;
	
	@FindBy(xpath="//a[contains(text(),'My Settings')]")
	WebElement MySettings;
	
	@FindBy(xpath="//a[contains(text(),'Developer Console')]")
	WebElement DeveloperConsole;
	
	@FindBy(xpath="//a[contains(text(),'Switch to Lightning Experience')]")
	WebElement Switchto;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement Logout;
	
	@FindBy(xpath="//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('PersonalInfo');\"]//span[@class='accordionIcon expand_icon']")
	WebElement PersonalTab;
	
	public void ishomepagedisplayed(String actualhomepage) {
		waitdriver(HomeTab);
		String expectedhomepage=HomeTab.getText();
		validateassertion(actualhomepage,expectedhomepage);
	}
	
	public void clickusermenu(){
		waitdriver(Usermenu);
    	Usermenu.click();
	}   
	
	public void clicklogout() {
    	Logout.click();
    }
	
	public void clickopportunitiestab() {
		OpportunitiesTab.click();
	}
	
	public void clickaccountstab() {
		AccountsTab.click();
	}
	
	
	public void validatedropdownmenu() {
		String actualmenu1=MyProfile.getText();
		String expectedmenu1="My Profile";
		validateassertion(actualmenu1,expectedmenu1);
		String actualmenu2=MySettings.getText();
		String expectedmenu2="My Settings";
		validateassertion(actualmenu2,expectedmenu2);
		String actualmenu3=DeveloperConsole.getText();
		String expectedmenu3="Developer Console";
		validateassertion(actualmenu3,expectedmenu3);
		String actualmenu4=Switchto.getText();
		String expectedmenu4="Logout";
		validateassertion(actualmenu4,expectedmenu4);
		String actualmenu5=Switchto.getText();
		String expectedmenu5="Switch to Lightning Experience";
		validateassertion(actualmenu5,expectedmenu5);
	}
	
	public void clickmyprofileoption() {
		MyProfile.click();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'File')]")));
	}
	
	public void clickmysettingsoption() {
		MySettings.click();
		
	}
    
	public void clickdeveloperconsoleoption() {
		DeveloperConsole.click();
		
	}

	public void clickleadstab() {
		LeadsTab.click();
		
	}
}
