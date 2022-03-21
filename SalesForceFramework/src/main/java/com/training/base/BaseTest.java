package com.training.base;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static Logger log = Logger.getLogger(BaseTest.class.getName());
	private WebDriver driver;
	
	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}
	
	public void windowmaximise() {
		driver.manage().window().maximize();
	}
	
	public void closepopup() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement close=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='tryLexDialogX']")));
		close.click();
	}
	
	public static void takeScreenShot(WebDriver driver) {
		log.info("Test Log Message");
		TakesScreenshot screenShot=((TakesScreenshot)driver);
		File srcfile=screenShot.getScreenshotAs(OutputType.FILE);
		Date currdate=new Date();
		String timeStamp=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currdate);
		String fileSeperator=System.getProperty("file.separator");
		String reportFilepath=System.getProperty("user.dir")+fileSeperator+"ScreenShots";
		String reportFileName="Screenshot"+timeStamp+".png";
		String filePath=reportFilepath+fileSeperator+reportFileName;
		File destFile=new File(filePath);
		try {
			FileUtils.copyFile(srcfile, destFile);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
	

}