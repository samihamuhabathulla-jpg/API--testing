package com.lms_practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllInstitutions {
	
	@Test
	public void getAllInstitutions() {
		Response response = RestAssured
				.given()
				.when()
				.get("https://lms-server-3-wedg.onrender.com/getAll/institution");
		response.prettyPrint();
		response.then()
	    .statusCode(200);
	}

}