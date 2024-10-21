package com.qa.demo.RestAsurd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BasicAuthdemo {

	@Test
	public void basicauth() {
		
		RestAssured.baseURI = "https://postman-echo.com";  //URI
    	RequestSpecification req =  RestAssured.given().auth().preemptive().basic("postman", "password");
    	Response res = req.get("/basic-auth");
    	//Retrieving the response body using getBody() method
		ResponseBody body = res.body();
		//Converting the response body to string object
		String data = body.asString();
		System.out.println(data);
		JsonPath path =res.jsonPath();
		String op = path.getString("authenticated");
		Boolean b = Boolean.valueOf(op);
		Assert.assertTrue(b);
		
	}
	
}
