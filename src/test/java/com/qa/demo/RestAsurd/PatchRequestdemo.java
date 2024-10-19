package com.qa.demo.RestAsurd;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequestdemo {
	
	@Test
	public void modifyUsingpatch() {
	 
		RestAssured.baseURI = "https://reqres.in/";  //URI
		RequestSpecification req =  RestAssured.given();
		
		JSONObject obj = new  JSONObject () ;
		obj.put("name", "Rahul");
		obj.put("job", "Sr.Engineer");
		req.contentType("application/json");
		req.body(obj.toJSONString());
		
		Response res = req.patch("api/user/2");
		System.out.println("Status:"+res.getStatusCode());
		System.out.println("Response:"+ res.prettyPrint());
		Assert.assertEquals(200, res.getStatusCode());
		
		JsonPath path =res.jsonPath();
		String data = path.getString("job");
		Assert.assertEquals("Sr.Engineer", data);
		System.out.println("Data:"+ res.prettyPrint());
		
	}

}
