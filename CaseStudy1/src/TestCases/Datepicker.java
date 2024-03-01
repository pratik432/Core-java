package TestCases;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Lis.listenerdemo;
import TestBase.Common;
import pageObject.DateObject;

@Listeners(listenerdemo.class)
public class Datepicker extends Common {
	public DateObject Date;
	Datepicker(){
		super();
	}
	@BeforeClass
	public void setUp() {
		initialization("Dateurl");
		Date=new DateObject();
	}
	
	@Test
	public void validateDateTitle() {
		String title=Date.validateDateTitle();
		Assert.assertEquals(title, "Datepicker","Datepicker title is incorrect ");
	}	
	@Test
	public void Validatedatepicker() throws ParseException, InterruptedException {
		
		Date.EnterDate("15/06/2021");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}