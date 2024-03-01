package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Common;

public class FramesObject extends Common {
	

	public FramesObject() {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath ="//input[@type='text']")
	public WebElement e1;
	@FindBy(xpath ="//a[contains(text(),'Iframe with in an Iframe')]")
	public WebElement e2;
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/iframe[1]")
	public WebElement e3;
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/iframe[1]")
	public WebElement e4;
	@FindBy(xpath="//input[@type='text']")
	public WebElement e5;
	@FindBy(xpath="//img[@src='original.png']")
	public WebElement logo;
	public String validateFrameTitle() {
		return driver.getTitle();	
		}
		
	public  WebDriver frameSwitch(String FrameName) {
		
		return driver.switchTo().frame(FrameName);
	}
	
	public WebDriver frameSwitch2(WebElement FrameName) {
		
		return driver.switchTo().frame(FrameName);
	}
      
	public void test() throws InterruptedException {
		
		frameSwitch("singleframe");
		e1.sendKeys("Hello");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		e2.click();
		frameSwitch2(e3);
		frameSwitch2(e4);
		e5.sendKeys("Hello");
		Thread.sleep(2000);
	  }

	public boolean validateLogoimg() {
		return logo.isDisplayed();
		
	}
	
	
}
