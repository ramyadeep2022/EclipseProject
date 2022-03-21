package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;
public class OpportunitiesPage extends BasePage {

	public OpportunitiesPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(xpath="//*[@id='fcf']")
	WebElement OptyDropdown;
	
	
	  @FindBy(name="new") WebElement NewButton;
	  
	  @FindBy(id="opp3") WebElement OpportunityName;
	  @FindBy(id="opp4") WebElement AccountName;
	  
	  @FindBy(xpath="//h1[normalize-space()='Opportunity Pipeline']") 
	  WebElement OptyPipelineTitle;
	  
	  @FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]") 
	  WebElement OpportunityPipeline;
	  
	  @FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]") 
	  WebElement StuckOpportunitiesLink;
	  
	  @FindBy(xpath="//h1[normalize-space()='Stuck Opportunities']") 
	  WebElement StuckOptyTitle;
	  
	  @FindBy(xpath="//*[@name='quarter_q']") 
	  WebElement QuarterlySummaryIntervalDropdown;
	  
	  @FindBy(xpath="//*[@name='open']") WebElement QuarterlySummaryIncludeDropdown;
	  
	  @FindBy(xpath="//input[@title='Run Report']") 
	  WebElement RunReportButton;
	  
	  
	  public void clicknewbutton() {
	  
	  NewButton.click();
	  }
	  
		 
public void validateoptydropdown() {
    	String[] expecteddropdown= {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New This Week","Recently Viewed Opportunities","Won"};
	Select select=new Select(OptyDropdown);
	List<WebElement> option=select.getOptions();
	for (int j = 0; j < option.size(); j++) {
      validateassertion(option.get(j).getText(),expecteddropdown[j]);
}
}

public void clickoptydropdown() {
	OptyDropdown.click();
	
}

public void clickrunreportbutton() {
	RunReportButton.click();
	
}


public void enterintoopportunityname() {
	waitdriver(OpportunityName);
	OpportunityName.sendKeys("WXYZ");
	
}
public void enterintoaccountname() {
	AccountName.sendKeys("ABCD");
	
}


public void clickopportunitypipeline() {
	OpportunityPipeline.click();
	
}


public void validateOptypipelinereport() {
	
	String actualtitle=OptyPipelineTitle.getText();
	String expectedtitle="Opportunity Pipeline";
	//System.out.println("actual"+actualtitle);
	validateassertion(actualtitle,expectedtitle);
}

public void clickstuckopportunitites() {
	StuckOpportunitiesLink.click();
	
}


public void validatestuckoptyreport() {
	
	String actualtitle=StuckOptyTitle.getText();
	String expectedtitle="Stuck Opportunities";
	//System.out.println("actual"+actualtitle);
	validateassertion(actualtitle,expectedtitle);
}


public void selectnextFQ() {
	selectdropdown(QuarterlySummaryIntervalDropdown,"Next FQ");
		
}
public void selectopenopportunities() {
	selectdropdown(QuarterlySummaryIncludeDropdown,"Open Opportunities");
		
}


}

