package pageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.Common;

public class DateObject extends Common {

	public DateObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='imgdp']")
	public WebElement image;
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	public WebElement year;
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	public WebElement month;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
	public WebElement next;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement previous;
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr")
	public List<WebElement> tr;

	public void EnterDate(String d) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		image.click();
		Thread.sleep(2000);
		String[] date = d.split("/");

		// check year
		if (date[2].equals(year.getText())) {

			boolean flag = true;

			while (flag == true) {
				// change month format
				SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(inputFormat.parse(month.getText()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				SimpleDateFormat o = new SimpleDateFormat("MM");
				if (Integer.parseInt(date[1]) == Integer.parseInt(o.format(c.getTime()))) {
					for (int i = 0; i < tr.size(); i++) {
						List<WebElement> col = tr.get(i).findElements(By.xpath("//td/a"));
						for (int j = 0; j < col.size(); j++) {
							if (!col.get(j).getText().isBlank() && date[0].equals(col.get(j).getText())) {
								col.get(j).click();
								Thread.sleep(2000);
								flag = false;
								break;

							}
						}
					}

				}

				else if ((Integer.parseInt(date[1])) > Integer.parseInt(o.format(c.getTime()))) {
					previous.click();
					
				} else if ((Integer.parseInt(date[1])) < Integer.parseInt(o.format(c.getTime()))) {
					next.click();
					
				}
			}

		}
	}

	public String validateDateTitle() {
		return driver.getTitle();
	}

}
