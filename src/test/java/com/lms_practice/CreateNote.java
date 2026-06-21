package com.lms_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNote {
	
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
		Map<String, Object> fields = new HashMap<>();
		ArrayList<String> tags = new ArrayList<>();
		tags.add("API");
		tags.add("Demo");
		fields.put("title", "API testing");
		fields.put("Content", "Created by Akkshee");
		fields.put("tags", tags);
		fields.put("isPinned", "false");
		fields.put("color","#ffffff");
		fields.put(token, tags);
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + token)
				.body(fields)
				.when()
				.post("https://lms-server-3-wedg.onrender.com/create/notes");
		res.prettyPrint();
		res.then()
		.statusCode(201);
	}
	

}