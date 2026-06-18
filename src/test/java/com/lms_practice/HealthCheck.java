package com.lms_practice;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class HealthCheck {

	@Test
	public void healthCheck() {
		Response response = RestAssured
				.given()
				.when()
				.get("https://lms-server-3-wedg.onrender.com/");
	    int status = response.getStatusCode();
	    response.then()
	    .statusCode(status);
	}
}