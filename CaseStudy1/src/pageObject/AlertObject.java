	package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Common;

public class AlertObject extends Common{
	
	public AlertObject(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateAlertTitle() {
		return driver.getTitle();	
		}

	@FindBy(xpath="//button[@class='btn btn-danger']")
	public WebElement e1;			
	@FindBy(xpath="//a[text()='Alert with OK & Cancel ']")
	public WebElement e2;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement e3;
	@FindBy(xpath="//a[text()='Alert with Textbox ']")
	public WebElement e4;
	@FindBy(xpath="//button[@class='btn btn-info']")
	public WebElement e5;
	
	
	public void alertwithok() {
		e1.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertwithokandcancel() {
		e2.click();	
		e3.click();
		Alert alert1= driver.switchTo().alert();
		
		alert1.accept();
	}
	
	public void alertwithtextbox(String arg) {
		e4.click();
		e5.click();
		Alert alert2= driver.switchTo().alert();
		alert2.sendKeys(arg);
		alert2.accept();
	}

}
