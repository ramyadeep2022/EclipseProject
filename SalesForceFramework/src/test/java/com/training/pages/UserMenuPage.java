package com.training.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.BasePage;

public class UserMenuPage extends BasePage{
	
	
	
	public UserMenuPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement About;
	
	@FindBy(id="contactInfoContentId")
	WebElement Frame1;
	
	@FindBy(xpath="//a[contains(@class,'contactInfoLaunch editLink')]//img")
	WebElement EditLink;
	
	@FindBy(id="lastName")
	WebElement LastName;
	
	@FindBy(xpath="//input[@class='zen-btn zen-primaryBtn zen-pas']")
	WebElement SaveAll;
	
	@FindBy(id="publisherAttachTextPost")
	WebElement PostLink;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, publisherRichTextEditor']")
	WebElement PostFrame;
	
	@FindBy(xpath="//html[1]/body[1]")
	WebElement PostEditor;
	
	@FindBy(id="publishersharebutton")
	WebElement ShareAll;
	
	@FindBy(xpath="//span[@class='publisherattachtext '][contains(text(),'File')]")
	public WebElement FileLink;
	
	@FindBy(id="chatterUploadFileAction")
	WebElement UploadfileLink;
	
	@FindBy(id="chatterFile")
	WebElement ChooseFile;
	
	@FindBy(xpath="//*[@class='chatter-photo']")
	WebElement Image;
	
	@FindBy(id="uploadLink")
	WebElement Update;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	WebElement PhotoFrame;
	
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	WebElement ChoosePhoto;
	
	@FindBy(id="j_id0:uploadFileForm:uploadBtn")
	WebElement Save;
	
	@FindBy(id="j_id0:j_id7:save")
	WebElement SaveButton;
	
	@FindBy(xpath="//iframe[@id='uploadPhotoContentId']")
	WebElement UploadPhotoFrame;
	

	@FindBy(xpath="//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('PersonalInfo');\"]")
	WebElement PersonalTab;
	
	@FindBy(id="LoginHistory_font")
	WebElement LoginHistoryTab;
	
	@FindBy(xpath="//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement DownloadLoginHistory;
	
	@FindBy(xpath="//a[@href=\"javascript:HTMLTreeNode.prototype.toggleHTMLTree('DisplayAndLayout');\"]")
	WebElement DisplayandLayoutTab;
	
	@FindBy(id="CustomizeTabs_font")
	WebElement CustomizeMyTab;
	String oldwindow;
	
	
	
	public void clickeditbutton() {
		EditLink.click();
	}
	public void switchtoeditframe() {
		
		switchtoframe(driver, Frame1);
	}
	public void clickabouttab() {
		About.click();
	}
	
	public void updatelastname() {
		LastName.clear();
		LastName.sendKeys("Kopp");
		
	}
	
	public void clicksaveall() {
		SaveAll.click();
	}
	
	public void clickPostcomment() {
		waitdriver(PostLink);
		PostLink.click();
		
	}
	
	public void switchpostframe() {
		waitdriver(PostFrame);
		switchtoframe(driver,PostFrame);
		WebElement el=driver.switchTo().activeElement();
		mousehover(el);
	}
	
	public void enterintoposteditor() {
	
		PostEditor.sendKeys("Hello This is my first post");
	}
	
	public void clicksharebutton() {
		
		driver.switchTo().parentFrame();
		waitdriver(ShareAll);
		ShareAll.click();
	}
	
	public void clickfilelink() {
		waitdriver(FileLink);
		FileLink.click();
	}
	
	public void clickonfileuploadlink() {
		waitdriver(UploadfileLink);
		UploadfileLink.click();
	}
	
	public void selectfilefromcomputer() {
		waitdriver(ChooseFile);
		ChooseFile.sendKeys("C:\\Users\\bhara\\OneDrive\\Desktop\\login details.txt");
	}
	
	public void mouseovertophoto() {
		mousehover(Image);
	}
	public void clickupdatebutton() {
		waitdriver(Update);
		Update.click();
	}
	public void Switchtophotoframe() {
		switchtoframe(driver,PhotoFrame);
	}
	
	public void Selectthephoto() {
		ChoosePhoto.sendKeys("C:\\Users\\bhara\\OneDrive\\Pictures\\Saved pictures\\WP_20160121_001.jpg");
	}
	public void clicksavebutton() {
		Save.click();
	}
	public void clickphotoeditorsavebutton() {
		SaveButton.click();
	}

	public void switchtophotocropframe() {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='uploadPhotoContentId']")));
		switchtoframe(driver,UploadPhotoFrame);
	}
	
	public void clickpersonaltab() {
		waitdriver(PersonalTab);
		mousehover(PersonalTab);
		PersonalTab.click();
	}
	public void clickloginhistorytab() {
		
		mousehover(LoginHistoryTab);
		LoginHistoryTab.click();
}
public void clickdownloadhistorylink() {
		
		mousehover(DownloadLoginHistory);
		DownloadLoginHistory.click();
}
public void clickdisplaylayouttab() {
	mousehover(DisplayandLayoutTab);
	DisplayandLayoutTab.click();
}
public void clickcutomizemytab() {
	mousehover(CustomizeMyTab);
	CustomizeMyTab.click();
	
}
public void switchtodeveloperconsolewindow() {
	oldwindow=driver.getWindowHandle();
	Set<String> allhandles= driver.getWindowHandles();
     String[] allwindows=allhandles.toArray(new String[allhandles.size()]);
	switchtowindow(driver,allwindows[1]);
	
}
public void closedeveloperconsolewindow() {
	driver.close();
	driver.switchTo().window(oldwindow);
}



}




	
 
  
  
	
	


