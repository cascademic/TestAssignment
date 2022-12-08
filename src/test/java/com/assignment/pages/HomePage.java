package com.assignment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {

	@FindBy(xpath = "(//a[text()='Create an Account'])")
	public WebElement Create_Account_Link;

	@FindBy(xpath = "//a[@class='logo']")
	public WebElement logo;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 4), this);
	}

	public void clickRegistration() {
		Create_Account_Link.click();
	}

	public void clickOnlogo() {
		logo.click();
	}

}
