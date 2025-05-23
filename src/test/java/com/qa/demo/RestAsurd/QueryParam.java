package com.qa.demo.RestAsurd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.response.ResponseBody;
	import io.restassured.specification.RequestSpecification;

	public class QueryParam {
		
		@Test
		public void queryParameter() {
			//Defining the base URI
			RestAssured.baseURI= "https://bookstore.toolsqa.com/BookStore/v1";
			RequestSpecification req = RestAssured.given();
			//Passing the resource details
			Response res = req.queryParam("ISBN","9781449325862").get("/Book");
			//https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862
			//Retrieving the response body using getBody() method
			ResponseBody body = res.body();
			//Converting the response body to string object
			String rbdy = body.asString();
			//Creating object of JsonPath and passing the string response body as parameter
			JsonPath jpath = new JsonPath(rbdy);
			//Storing publisher name in a string variable
			String title = jpath.getString("title");
			System.out.println("The book title is - "+title);
			System.out.println("Details of Book"+res.prettyPrint());
		}

	}

	
	
	

