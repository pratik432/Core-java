package TestCases;



import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Lis.listenerdemo;
import TestBase.Common;
import pageObject.RegisterObject;

@Listeners(listenerdemo.class)
public class RegisterPage extends Common {

	public RegisterObject RegObj;

	public RegisterPage() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization("Regurl");
		RegObj = new RegisterObject();
	}
	@Test
	public void validateRegTitle() {
		String title=RegObj.validateRegTitle();
		Assert.assertEquals(title, "Register");
	}
	@Test
	public void validateFirstLastNameTest() {
		RegObj.enterName("Pratik", "Singh");
	}
	
	@Test
	public void validateEmailTest() {
		RegObj.enteremail("abc@gmail");
	}
	@Test
	public void Validategender() {
		RegObj.entergender("Male");
	}
	//@Test
	public void validate_language() {
		
		RegObj.Enter_Language(1);
	}
	@Test
	public void Validateaddress() {
		RegObj.enteraddress("City,state,pincode");
	}
	@Test
	public void ValidateTel() {
		RegObj.enterTel("999945263");
	}
	//@Test
	public void ValidateCountry() throws InterruptedException {
		RegObj.enterCountry("India");
	}
	@Test
	public void ValidateFirstPassword() {
		RegObj.enterfirstpassword("-------");
	}
	@Test
	public void ValidateSecondPassword() {
		RegObj.entersecondpassword("-------------------");
	}
	@Test
	public void Validate_DOB() {
		RegObj.EnterDOB("2012", "May", "15");
	}
	@Test
	public void Validate_Hobbies() {
		RegObj.Hobbiescheckbox("Cricket");
		RegObj.Hobbiescheckbox("Movies");
		RegObj.Hobbiescheckbox("Hockey");
	}
	@Test
	public void Validate_Skill() {
		RegObj.Enter_skill();
	}
	@Test
	public void Validate_Submit_button() {
		RegObj.clickonsubmit();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
