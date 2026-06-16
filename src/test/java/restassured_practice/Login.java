package restassured_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login {
	
	@Test
	public void login() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("username", "admin");
		payload.put("password", "admin123");
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post("http://localhost:5000/login");
		res.prettyPrint();
		Assert.assertEquals(res.getStatusCode(),200);	
	}

}