package com.assignment.utilities.restAssured;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class RestAssuredUtilities {

	
	//write only this simple method to GET API response
	public static Response doRequest(String url, String method) {

		Response response = given().when().request(method, url);

		return response;
	}
    //it will have all GET,POST,PUT methods, but it is not required as we have response body.
}
