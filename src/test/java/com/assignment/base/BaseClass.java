package com.assignment.base;


import org.openqa.selenium.WebDriver;


public class BaseClass {
	
	
private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	
	
	public static WebDriver getBaseDriver() {
		return webDriver.get();
	}
	
	public  void setDriver(WebDriver driver) throws Exception {

		webDriver.set(driver);

	}
	
}
