package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBase.Common;

public class RegisterObject extends Common {

	public RegisterObject() {
		PageFactory.initElements(driver, this);
	}

	public String validateRegTitle() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public WebElement FirstN;
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public WebElement LastN;
	@FindBy(xpath = "//textarea[@rows='3']")
	public WebElement Address;
	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;
	@FindBy(xpath = "//input[@type='tel']")
	public WebElement tel;
	@FindBy(xpath = "//input[@value='Male']")
	public WebElement malegender;
	@FindBy(xpath = "//input[@id='checkbox1']")
	public WebElement hobbies1;
	@FindBy(xpath = "//input[@id='checkbox2']")
	public WebElement hobbies2;
	@FindBy(xpath = "//input[@id='checkbox3']")
	public WebElement hobbies3;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul")
	public List<WebElement> Language;
	@FindBy(xpath = "//select[@placeholder='Year']")
	public WebElement Year;
	@FindBy(xpath = "//select[@placeholder='Month']")
	public WebElement Month;
	@FindBy(xpath = "//select[@placeholder='Day']")
	public WebElement Day;
	@FindBy(xpath = "//input[@id='firstpassword']")
	public WebElement firstPassword;
	@FindBy(xpath = "//input[@id='secondpassword']")
	public WebElement secondpassword;

	public void enterName(String arg1,String arg2) {
		FirstN.sendKeys(arg1);
		LastN.sendKeys(arg2);
	}
	public void enteraddress(String arg1) {
		Address.sendKeys(arg1);
	}

	public void enteremail(String arg1) {
		email.sendKeys(arg1);
	}

	public void enterTel(String string) {
		tel.sendKeys(string);
	}

	public void entergender(String arg1) {
		malegender.click();
	}

	public void enterfirstpassword(String arg1) {
		firstPassword.sendKeys(arg1);
	}

	public void entersecondpassword(String arg1) {
		secondpassword.sendKeys(arg1);
	}

	public void EnterDOB(String year, String month, String day) {
		Year.sendKeys(year);
		Month.sendKeys(month);
		Day.sendKeys(day);
	}

	public void enterCountry(String arg1) throws InterruptedException {
		searchByClass1("selection");
		Thread.sleep(3000);
		searchByClass2("select2-search__field", arg1);
		searchByClass_click("select2-search__field");

	}

	public void searchbyid(String arg1) {
		driver.findElement(By.id(arg1));
	}

	private void searchByClass1(String arg1) {
		driver.findElement(By.className(arg1)).sendKeys(Keys.ENTER);
	}

	public void searchByClass2(String arg1, String arg2) {
		driver.findElement(By.className(arg1)).sendKeys(arg2);
	}

	public void searchByClass_click(String arg1) {
		driver.findElement(By.className(arg1)).sendKeys(Keys.ENTER);
	}

	public void clickonsubmit() {
		searchbyid("submitbtn");
	}

	public void Hobbiescheckbox(String s) {
		if (s == "Cricket")
			hobbies1.click();
		else if (s == "Movies")
			hobbies2.click();
		else
			hobbies3.click();
	}

	public void Enter_Language(int n) {
		driver.findElement(By.id("m")).click();
		List<WebElement> li = Language;
		li.get(n).sendKeys(Keys.ENTER);

	}

	public void Enter_skill() {
		Select se = new Select(driver.findElement(By.id("Skills")));
		se.selectByValue("Java");
	}
	
}
