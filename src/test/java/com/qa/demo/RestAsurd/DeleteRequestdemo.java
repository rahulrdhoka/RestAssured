package com.qa.demo.RestAsurd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequestdemo {

	@Test
	public void delete() {
	
		RestAssured.baseURI = "https://reqres.in/";  //URI
		RequestSpecification req =  RestAssured.given();
		Response res = req.delete("api/users/2");
		System.out.println("Status:"+res.getStatusCode());
		System.out.println("Response:"+ res.prettyPrint());
		Assert.assertEquals(204, res.getStatusCode());
	}
}
