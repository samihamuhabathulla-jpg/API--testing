package restassured_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class InvalidLogin {
	
	@Test
	public void login() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("username", "wrong");
		payload.put("password", "wrong");
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.post("http://localhost:5000/login");
		res.prettyPrint();
		Assert.assertEquals(res.getStatusCode(),401);	
	}

}