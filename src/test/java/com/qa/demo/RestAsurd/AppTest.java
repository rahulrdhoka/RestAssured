package com.qa.demo.RestAsurd;



import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class AppTest {

 
    
	@Test
    public void testGetMethod() {
        
    	RestAssured.baseURI = "https://bookstore.toolsqa.com/";  //URI
    	RequestSpecification req =  RestAssured.given();
    	Response res = req.get("BookStore/v1/Books");
    	
    	System.out.println("Status:"+res.getStatusCode());
    	System.out.println("Response:"+ res.prettyPrint());
    	
    	Assertion assertion = new Assertion();
		assertion.assertEquals(200, res.getStatusCode());
    	System.out.println("Program java with restassured ");
    	System.out.println("Program java with restassured 2 ");
		System.out.println("Rest");
	    System.out.println("RestSOA");
    }
	
	@Test 
	public void IteratingHeaders() 
	{ RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books"; 
	 RequestSpecification httpRequest = RestAssured.given(); 
	 Response response = httpRequest.get(""); 
	 // Get all the headers and then iterate over allHeaders to print each header 
	 Headers allHeaders = response.headers(); 
	 // Iterate over all the Headers 
	 for(Header header : allHeaders) { 
	   System.out.println("Key: " + header.getName() + " Value: " + header.getValue()); 
	 } 
	}
	
	@Test
	public void WeatherMessageBody()
	{
		RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// By using the ResponseBody.asString() method, we can convert the  body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
	}

}
