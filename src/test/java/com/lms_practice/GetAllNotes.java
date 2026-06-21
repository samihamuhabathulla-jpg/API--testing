package com.lms_practice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllNotes {
	
	@Test
	public void createNote() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post("https://lms-server-3-wedg.onrender.com/user/login");
		String token = response.jsonPath().getString("token");
		
		Response res = RestAssured
				.given()
				.queryParam("page (1), limit (50), search, tags, isPinned, sortBy (lastEdited/title), sortOrder (asc/desc)")
				.header("Authorization", "Bearer " + token)
				.when()
				.get("https://lms-server-3-wedg.onrender.com/getAll/notes?limit=2&sortOrder=desc");
		res.prettyPrint();
		res.then()
		.statusCode(200);
	}
	

}