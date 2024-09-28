package com.qa.demo.RestAsurd;



import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.response.Response;
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
}
