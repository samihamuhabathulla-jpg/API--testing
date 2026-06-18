package restassured_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PartialUpdate {

	@Test
	public void partial_update() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("mail", "yxz@gmail.com");
		Response res = RestAssured
				.given()
				.when()
				.patch("http://localhost:3000/trainees/1");
		res.prettyPrint();
		res.then()
		.statusCode(200);
	}
}