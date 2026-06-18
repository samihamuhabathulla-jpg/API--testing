package com.lms_practice;
   
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login {
	@Test
	public void loginTest() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("email", "sam@gmail.com");
		payload.put("password", "123");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post("https://lms-server-3-wedg.onrender.com/user/login");
		response.prettyPrint();
		String token = response.jsonPath().getString("token");
		System.out.println("Token : "+token);
		response.then()
		.statusCode(201);
	}

}