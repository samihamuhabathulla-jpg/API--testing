package com.lms_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteNoteById {

	@Test
	public void deleteNote() {
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
				.delete("https://lms-server-3-wedg.onrender.com/delete/notes/6a337a4c026d1fff76738368");
		res.prettyPrint();
		res.then()
			.statusCode(200);
	}
}