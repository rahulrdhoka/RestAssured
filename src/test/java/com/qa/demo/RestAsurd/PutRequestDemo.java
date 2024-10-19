package com.qa.demo.RestAsurd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestDemo {

	
	
	@Test
    public void testGetMethod() {
	RestAssured.baseURI = "https://reqres.in/";  //URI
	RequestSpecification req =  RestAssured.given();
	req.header("Content-Type" ,"application/Json");
	JSONObject obj = new  JSONObject () ;
	obj.put("name", "Rahul");
	obj.put("job", "leader");
	req.body(obj.toJSONString());
	Response res = req.post("api/users");
	System.out.println("Status:"+res.getStatusCode());
	System.out.println("Response:"+ res.prettyPrint());
	
	}
	
}
