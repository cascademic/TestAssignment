package com.assignment.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {

	@FindBy(xpath = "(//*[@class='product-item-link'])")
	public WebElement Product_Link;
	@FindBy(xpath = "(//*[@class='swatch-option text'])")
	public List<WebElement> size_Select;
	@FindBy(xpath = "(//*[@class='swatch-option color'])")
	public List<WebElement> color_Select;
	@FindBy(xpath = "(//button[@title='Add to Cart'])")
	public WebElement AddToCart;
	@FindBy(xpath = "//a[text()='shopping cart']")
	public WebElement shoopingCart;

	@FindBy(xpath = "//li//button[@title='Proceed to Checkout']")
	public WebElement ProceedToCheckout;

	@FindBy(xpath = "//td[@data-th='Order Total']//span[@class='price']")
	public WebElement OrderTotal;

	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 4), this);
	}

	public void clickonAnyProduct() {
		Product_Link.click();
	}

	public void selectColorAndSize(String color, String size) {
		boolean selectColor = false;
		boolean selectSize = false;
		for (int i = 0; i < color_Select.size(); i++) {
			if (color_Select.get(i).getAttribute("aria-label").equalsIgnoreCase(color)) {
				color_Select.get(i).click();
				selectColor = true;
			} // default color

		}
		if (!selectColor) {
			color_Select.get(0).click();
		}

		for (int i = 0; i < size_Select.size(); i++) {
			if (size_Select.get(i).getAttribute("aria-label").equalsIgnoreCase(size)) {
				size_Select.get(i).click();
				selectSize = true;
			}

		}
		if (!selectSize) {
			size_Select.get(0).click();
		}

	}

	public String addToCart() {
		AddToCart.click();
		shoopingCart.click();
		String totalPrice = OrderTotal.getText();
		ProceedToCheckout.click();
		return totalPrice;

	}

}
