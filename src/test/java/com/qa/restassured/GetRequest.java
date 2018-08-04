package com.qa.restassured;

import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	static String url = "https://reqres.in";
	
	public static void main(String[] args) {

		String apiUrl = "/api/users?page=2";

		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");

		// Make a GET Request
		Response response = request.get(apiUrl);
		
		System.out.println("\nStatus Code : "+response.getStatusCode());
		
		String jsonResponseData = response.getBody().asString();		
		System.out.println("\n--------Printing Json Response-------- \n"+jsonResponseData);
				
		System.out.println("\n---------Extracting Data from Json Response----------");
		JSONObject object = new JSONObject(jsonResponseData);
		System.out.println("Page 		: "+object.get("page"));
		System.out.println("Total 		: "+object.get("total"));
		System.out.println("Total Pages 	: "+object.get("total_pages"));
	
		
		//To get data inside an Array
		System.out.println("\n---------Extracting Data from Json Array[0]----------");
		JSONArray jsonArray = new JSONArray(object.get("data").toString());		
				
		System.out.println("ID 		: "+jsonArray.getJSONObject(0).get("id"));
		System.out.println("First Name 	: "+jsonArray.getJSONObject(0).get("first_name"));
		System.out.println("Last Name 	: "+jsonArray.getJSONObject(0).get("last_name"));
		
		System.out.println("\n---------Extracting Data from Json Array[2]----------");
		System.out.println("ID 		: "+jsonArray.getJSONObject(2).get("id"));
		System.out.println("First Name 	: "+jsonArray.getJSONObject(2).get("first_name"));
		System.out.println("Last Name 	: "+jsonArray.getJSONObject(2).get("last_name"));

		System.out.println("\nTotal Length of Array : "+jsonArray.length());
		
		System.out.println("----------------------------");
		
	}

}
