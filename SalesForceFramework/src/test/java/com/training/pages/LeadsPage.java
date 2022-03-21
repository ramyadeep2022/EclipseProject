package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver) {
		super(driver);
		}
	
	  @FindBy(xpath="//h1[contains(text(),\"Leads\")]")
	  WebElement LeadsHomePage;
	  
	  @FindBy(xpath="//*[@id='fcf']")
	  WebElement DropdownView;
	  
	  @FindBy(name="go")
	  WebElement GoButton;
	  
	  public void isleadpagedisplayed(String expectedleadpage) {
			waitdriver(LeadsHomePage);
			String actualleadpage=LeadsHomePage.getText();
			System.out.println(expectedleadpage);
			validateassertion(actualleadpage,expectedleadpage);
		}



	public void clickdropdownview() {
		
		DropdownView.click();
	}



	public void validatedropdownoptions() {
		String[] expecteddropdown= {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads"};
		Select select=new Select(DropdownView);
		List<WebElement> option=select.getOptions();
		if(option.size()!=expecteddropdown.length) {
			//driver.close();
			Assert.fail("The count of dropdown values does not match with actual ones");
			
		}else {
		
		for (int j = 0; j < option.size(); j++) {
				 validateassertion(option.get(j).getText(),expecteddropdown[j]);
			    }
		}
	}



	public void selectfromdropdown() {
		selectdropdown(DropdownView,"My Unread Leads");
	}



	public void validateselectedoption() {
		// TODO Auto-generated method stub
		
		Select s1=new Select(DropdownView);
		String expectedselection="My Unread Leads";
	   String currselection=s1.getFirstSelectedOption().getText();
		validateassertion(currselection, expectedselection);	
		
	}



	public void clickgobutton() {
		// TODO Auto-generated method stub
		waitdriver(GoButton);
		GoButton.click();
	}
	  
		

}

