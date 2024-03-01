package pageObject;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Common;

public class WindowObject extends Common {

	public WindowObject() {
		PageFactory.initElements(driver, this);
	}

	public String validateWindowTitle() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//a[text()='Open New Seperate Windows']")
	WebElement separateWindow;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement clickbtn;

	
	

	public void multiplewindows() throws InterruptedException {
		separateWindow.click();
		clickbtn.click();
		driver.get("http://demo.automationtesting.in/Windows.html");
		String parent = driver.getWindowHandle();
		Set<String> ls = driver.getWindowHandles();
		Iterator<String> it = ls.iterator();
		while (it.hasNext()) {
			String child = it.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
	}

}
