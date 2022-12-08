package com.assignment.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends BaseClass {
	
//	private static BrowserFactory instance = null;
	private  ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
//	protected BrowserFactory() {
//
//	}
//
//	public static BrowserFactory getInstance() {
//		if (instance == null) {
//			instance = new BrowserFactory();
//	
//		}
//		return instance;
//	}

	public  void setDriver(WebDriver driver) throws Exception {

		webDriver.set(driver);

	}

	public void changeImplicitWaits(int seconds) {
		System.out.println(getDriver());
		getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public  WebDriver getDriver() {
		return webDriver.get();
	}

//	public void highlightElement(WebElement element,String color){
//		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//		jse.executeScript("arguments[0].style.border='4px solid "+color+"'", element);
//	}
//	
//	public void click(WebElement Element,String ElementName) {
//		try{
//			waitForLocatorToBeClickable(Element);
//			highlightElement(Element,"yellow");
//			Element.click();
//			testPass("Successfully Clicked on "+ElementName);
//		}
//		catch(org.openqa.selenium.StaleElementReferenceException e){
//			waitForElementPresence(Element);
//			Element.click();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			testFail(e.getClass().getName()+" click method failed ");
//		}
//	}

}