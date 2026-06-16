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
		payload.put("mail", "abcd@gmail.com");
		Response res = RestAssured
				.given()
				.when()
				.patch("http://localhost:3000/trainees/mNJqwbLot-Y");
		res.prettyPrint();
		Assert.assertEquals(res.getStatusCode(),200);
	}
}