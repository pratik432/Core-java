package TestCases;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Lis.listenerdemo;
import TestBase.Common;
import pageObject.AlertObject;


@Listeners(listenerdemo.class)
public class AlertPage extends Common {
	AlertObject Alert;
	public AlertPage(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization("alerturl");
		Alert = new AlertObject();
	}
	@Test
	public void validateAlertwithOK() {
		Alert.alertwithok();
	}
	@Test
	public void validatealertwithokandcancel() throws InterruptedException {
		Alert.alertwithokandcancel();
	}
	@Test
	public void validatealertwithtextbox() {
		Alert.alertwithtextbox("Demo");
	}
	@Test
	public void ValidateAlertPageTitle() {
		String title= Alert.validateAlertTitle();
		Assert.assertEquals(title, "Alerts");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
}
