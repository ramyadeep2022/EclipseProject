package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class AccountsPage extends BasePage {

	public AccountsPage(WebDriver driver) {
		super(driver);
		}
	
	
	@FindBy(name="new")
	WebElement NewButton;
	
	@FindBy(xpath="//input[@name='acc2']")
	WebElement AccountName;
	
	@FindBy(xpath="//*[@id='acc6']")
	WebElement TypeDropdown;
	
	@FindBy(xpath="//*[@id='00N8c00000NK0vL']")
	WebElement PriorityDropdown;
	
	@FindBy(name="save")
	WebElement Save;
	
	@FindBy(xpath="//h2[contains(text(),'Rocket2')]")
	WebElement AccountHeadingName;
	
	@FindBy(xpath="//a[contains(text(),'Create New View')]")
	WebElement CreateNewView;
	
	@FindBy(name="fname")
	WebElement ViewName;
	
	@FindBy(name="devname")
	WebElement UniqueName;
	
	@FindBy(name="save")
	WebElement SaveView;
	
	@FindBy(xpath="//*[@name='fcf']")
	WebElement ViewDropdown;
	
	
	public void clicknewbutton() {
		
		NewButton.click();
	}
	
	public void enterintoaccountname() {
		waitdriver(AccountName);
		AccountName.sendKeys("Rocket2");
	}
	
	public void clicktypedropdown() {
		
		TypeDropdown.click();
	}
	
	public void selecttypedropdown() {
		selectdropdown(TypeDropdown,"Technology Partner");
	}
	
	public void selectprioritydropdown() {
		selectdropdown(PriorityDropdown,"High");
	}
	
public void clicksavebutton() {
		Save.click();
	}
public void validateAccountPage() {
	String actualaccountname=AccountHeadingName.getText();
	validateassertion(actualaccountname,"Rocket2");
	
}

public void clickcreatenewview() {
		CreateNewView.click();
}
public void clickviewname() {
	waitdriver(ViewName);
	ViewName.click();
}

public void clickuniquename() {
	UniqueName.click();
}

public void enterintoviewname() {
	ViewName.sendKeys("Rocket2");
}
public void clicksaveviewbutton() {
	SaveView.click();
}
public void validateviewdropdown() {
    waitdriver(ViewDropdown);
	String actualname=getfirstselectfromdropdown(ViewDropdown).getText();
	validateassertion(actualname, "Rocket2"); 
}


}
