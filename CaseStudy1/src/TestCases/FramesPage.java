package TestCases;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Lis.listenerdemo;
import TestBase.Common;
import pageObject.FramesObject;

@Listeners(listenerdemo.class)
public class FramesPage extends Common {
	public FramesObject frameObj;
	
	static ExtentTest test;
	static ExtentReports report;
	
	static final Logger logger =LogManager.getLogger(FramesPage.class.getName()); 
	
	public FramesPage() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		logger.info("--------------------------------------------------");
		logger.info("Test had started");
		Logger log=Logger.getLogger("sampleLog");
		initialization("Frameurl");
		frameObj=new FramesObject();
		log.warn("URL launch");
		}
	@Test
	public void validateFrameTitle() {
		String title=frameObj.validateFrameTitle();
		Assert.assertEquals(title, "Frames");
		report =new ExtentReports("src//ExtentReportResults.html");
		test=report.startTest("ExtentDemo");
		
		if(driver.getTitle().equals("Frames")) {
			test.log(LogStatus.PASS,"Navigate to the specified url");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
		report.endTest(test);
		report.flush();
	}
	@Test
	public void ValidateFramePagelogo() {
		boolean flag=frameObj.validateLogoimg();
		Assert.assertTrue(flag);	
	}
	@Test
	public void validateFrames() throws InterruptedException {
		frameObj.test();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
