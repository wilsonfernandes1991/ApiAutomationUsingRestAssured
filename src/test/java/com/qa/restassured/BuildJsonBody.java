package com.qa.restassured;

import org.json.JSONArray;
import org.json.JSONObject;

public class BuildJsonBody {

	public static void main(String[] args) {
	
	//Create Simple JSON Request Body
		 JSONObject simpleRequest = new JSONObject();
		 simpleRequest.put("Name", "Wilson");
		 simpleRequest.put("City", "Udupi");	 
		 
		 String requestData = simpleRequest.toString();
		 System.out.println(requestData);
		 
		 
	//Create JSON Array Request Body
		 JSONObject simpleRequest1 = new JSONObject();
		 simpleRequest1.put("id", 1);
		 simpleRequest1.put("name", "Wilson");
		 
		 JSONObject simpleRequest2 = new JSONObject();
		 simpleRequest2.put("id", 2);
		 simpleRequest2.put("name", "Ashwith");
		 
		 JSONArray array = new JSONArray();
		 array.put(simpleRequest1);
		 array.put(simpleRequest2);
		 
		 JSONObject mainRequest = new JSONObject();
		 mainRequest.put("page", 3);
		 mainRequest.put("total_pages", 4);
		 mainRequest.put("data", array);
		 
 
		 System.out.println("\n---------Printing Final Json Array Request----------\n"+mainRequest);

	}

}
