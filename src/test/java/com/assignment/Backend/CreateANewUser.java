package com.assignment.Backend;

import com.assignment.Backend.dto.NewUserdto;
import com.assignment.Backend.dto.NewUserdto.Result;
import com.assignment.base.BaseClass;
import com.assignment.base.BaseTest;
import com.assignment.utilities.extentreports.ExtentTestManager;
import com.assignment.utilities.restAssured.RestAssuredUtilities;
import com.assignment.utilities.restAssured.Utilities;
import com.aventstack.extentreports.Status;
import com.assignment.pages.CartPage;
import com.assignment.pages.HomePage;
import com.assignment.pages.RegistrationPage;
import io.restassured.response.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;
import java.io.IOException;

public class CreateANewUser extends BaseTest {

	Utilities utilities;
	SoftAssert softAssert;

	@Test(groups = { "Sanity", "Regression" })
	public void RegisterNewUser(Method method) throws IOException, ParseException {
		try {
			ExtentTestManager.startTest(method.getName(), "Register and order an item");
			utilities = new Utilities();
			softAssert = new SoftAssert();
			// open browser
			BaseClass.getBaseDriver().get("https://magento.softwaretestingboard.com/");
			HomePage homePage = new HomePage(browserFactory.getBaseDriver());

			String url = "https://randomuser.me/api/";
			String methodName = "GET";
			Response response = RestAssuredUtilities.doRequest(url, methodName);

			// there are two methods to get JSON details
			// First method to get string/Using json , less number of data is required.

			// String gender = response.jsonPath().getString("results[0].gender");
			// Second method to use DTo class if need all data from JSON

			NewUserdto result = response.getBody().as(NewUserdto.class);
			String firstname = result.results.get(0).name.first;
			String lastname = result.results.get(0).name.last;
			String email = result.results.get(0).email;
			ExtentTestManager.logStatus(Status.PASS, "User Email id: " + email);

			// adding the new password as it is taking 8 char password
			// String password = result.results.get(0).login.password;
			homePage.clickRegistration();
			RegistrationPage registration = new RegistrationPage(browserFactory.getBaseDriver());
			Boolean registration_Status = registration.registerNewUser(firstname, lastname, email, "AnshulMadan@123");
			softAssert.assertTrue(registration_Status, "Registration is not successful");
			if (registration_Status) {
				ExtentTestManager.logStatus(Status.PASS, "User is registered successful");
			} else {
				ExtentTestManager.logStatus(Status.FAIL, "User is registered successful");
			}
			homePage.clickOnlogo();

			CartPage cartPage = new CartPage(browserFactory.getBaseDriver());
			cartPage.clickonAnyProduct();
			cartPage.selectColorAndSize("Purple", "L");
			String TotalPrice = cartPage.addToCart();
			ExtentTestManager.logStatus(Status.PASS, "Total Checkout Price: " + TotalPrice );
			softAssert.assertAll();
		} catch (Exception ex) {
			ExtentTestManager.logStatus(Status.FAIL, "test case is failed" + ex.getMessage());
			softAssert.assertTrue(false, "test case is failed" + ex.getMessage());
			softAssert.assertAll();
		}
	}
}
