package com.lms_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetNoteById {

	@Test
	public void getNoteById() {

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
				.header("Authorization", "Bearer " + token)
				.when()
				.get("https://lms-server-3-wedg.onrender.com/getById/notes/PUT_NOTE_ID_HERE");
		res.prettyPrint();
		res.then()
		.statusCode(200);
		String title = res.jsonPath().getString("data.title");
		System.out.println("Title : " + title);
	}
}