package restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class InvalidTrainee {

	@Test
	public void invalid_trainee() {
		Response res = RestAssured
				.given()
				.when()
				.get("http://localhost:3000/trainees/35");
		Assert.assertEquals(res.getStatusCode(),404);
	}
}




