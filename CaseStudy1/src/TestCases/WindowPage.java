package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Lis.listenerdemo;
import TestBase.Common;
import pageObject.WindowObject;


@Listeners(listenerdemo.class)
public class WindowPage extends Common {
	WindowObject window;
	WindowPage(){
		super();
	}
	@BeforeClass
	public void setUp() {
		initialization("Windowurl");
		window=new WindowObject();
	}
	@Test
	public void validateWindowTitle() {
		String title=window.validateWindowTitle();
		Assert.assertEquals(title, "Frames & windows");
	}
	

	@Test
	public void validatemultiplewindowTest() throws InterruptedException {
		window.multiplewindows();
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
