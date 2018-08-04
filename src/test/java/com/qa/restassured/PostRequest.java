package com.qa.restassured;


import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	static String url = "https://reqres.in";

	public static void main(String[] args) {
	
		String apiUrl = "/api/users";
	
		// Build JSON Request Parameters
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("name", "morpheus");
		jsonRequest.put("job", "leader");
		 
		System.out.println("\n--------Printing Json Request-------- \n"+jsonRequest);

		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");

		// Add Body / PayLoad
		request.body(jsonRequest.toString());

		// Make a POST Request
		Response response = request.post(apiUrl);
		
		System.out.println("\nStatus Code : "+response.getStatusCode());
		
		String jsonResponseData = response.getBody().asString();
		System.out.println("\n--------Printing Json Response-------- \n"+jsonResponseData);
		
		JSONObject object = new JSONObject(jsonResponseData);
		System.out.println("\n---------Extracting Data from Json Response----------");
		System.out.println("Name 		: "+object.get("name"));
		System.out.println("ID 		: "+object.get("id"));
		System.out.println("Job 		: "+object.get("job"));
		System.out.println("Created At 	: "+object.get("createdAt"));
	
		System.out.println("----------------------------");

	}

}
