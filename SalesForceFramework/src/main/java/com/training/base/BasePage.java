package com.training.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	protected WebDriver driver;
	
	
	public BasePage(WebDriver driver1) {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
	public void waitdriver(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(Element));
	} 
	
	public void mousehover(WebElement Element) {
		Actions Action=new Actions(driver);
		Action.moveToElement(Element).build().perform();
	}
	
	public void validateassertion(String actual,String expected) {
	    Assert.assertEquals(actual, expected,"Assertion done");
	}
	
	public void switchtoframe(WebDriver driver1,WebElement frame1) {
		String oldwindow=driver.getWindowHandle();
		driver.switchTo().frame(frame1);
	}
	
	public void switchtowindow(WebDriver driver1,String window1) {
		driver.switchTo().window(window1);
	}
	
	public void selectdropdown(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public WebElement getfirstselectfromdropdown(WebElement element) {
		Select select=new Select(element);
		WebElement actualoption=select.getFirstSelectedOption();
		return actualoption;
	}
	
}
