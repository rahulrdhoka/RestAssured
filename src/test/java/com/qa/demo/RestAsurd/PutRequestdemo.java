package com.qa.demo.RestAsurd;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class PutRequestdemo {

	
	@Test
	public void modify() {
	 
		RestAssured.baseURI = "https://reqres.in/";  //URI
		RequestSpecification req =  RestAssured.given();
		
		JSONObject obj = new  JSONObject () ;
		obj.put("name", "Rahul");
		obj.put("job", "Vice President");
		req.contentType("application/json");
		req.body(obj.toJSONString());
		
		Response res = req.put("api/user/2");
		System.out.println("Status:"+res.getStatusCode());
		System.out.println("Response:"+ res.prettyPrint());
		Assert.assertEquals(200, res.getStatusCode());
		
		JsonPath path =res.jsonPath();
		String data = path.getString("job");
		Assert.assertEquals("Vice President", data);
		System.out.println("Data:"+ res.prettyPrint());
		
	}
}
