package restassured_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateTrainee {
	
	@Test
	public void update_trainee() {
		Map<String,Object> payload = new HashMap<>();
		payload.put("name", "samihaM");
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(payload)
				.when()
				.put("http://localhost:3000/trainees/1");
		res.prettyPrint();
		res.then()
		.statusCode(200);
	}

}