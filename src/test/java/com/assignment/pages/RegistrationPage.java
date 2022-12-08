package com.assignment.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assignment.base.BaseTest;

public class RegistrationPage extends BaseTest {

	@FindBy(id = "firstname")
	public WebElement firstname;
	@FindBy(id = "lastname")
	public WebElement lastname;
	@FindBy(id = "email_address")
	public WebElement email_address;
	@FindBy(id = "password")
	public WebElement User_password;
	@FindBy(id = "password-confirmation")
	public WebElement confirmed_Password;
	@FindBy(xpath = "//button[@type='submit']//span[text()='Create an Account']")
	public WebElement CreateAccount_Button;
	@FindBy(xpath = "//*[text()='Thank you for registering with Fake Online Clothing Store.']")
	public WebElement Successful_Message;
	
	// a[@class='logo']

	// Thank you for registering with Fake Online Clothing Store.
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 4), this);
	}

	public boolean registerNewUser(String firstName, String lastName, String emailAddress, String password)
			throws InterruptedException {
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		email_address.sendKeys(emailAddress);
		User_password.sendKeys(password);
		confirmed_Password.sendKeys(password);
		Thread.sleep(1000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();", CreateAccount_Button);
		// CreateAccount_Button.submit();
		CreateAccount_Button.click();
		Thread.sleep(1000);

		return Successful_Message.isDisplayed();
	}

}
