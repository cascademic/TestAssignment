package com.assignment.base;

import com.assignment.utilities.extentreports.ExtentTestManager;
import com.assignment.utilities.logs.*;
import com.assignment.utilities.restAssured.RestAssuredUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends ExtentTestManager {

	// public WelcomePage welcomepage;
	RemoteWebDriver RwbDriver;
	EventFiringWebDriver driver;
	protected BaseClass browserFactory;

	@BeforeClass
	@Parameters({ "test.env" })
	public void testInit(String env) {

	}

	@BeforeMethod
	public void beforeMethod(Method method) throws Exception {
		browserFactory = new BaseClass();
		WebDriverManager.chromedriver().setup();
		RwbDriver = new ChromeDriver();
		driver = new EventFiringWebDriver(RwbDriver);
		browserFactory.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void teardown() {
		driver.quit();
		Log.info("Tests are ending!");
	}
}
