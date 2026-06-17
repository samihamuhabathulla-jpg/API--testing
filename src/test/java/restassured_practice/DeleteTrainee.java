package restassured_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTrainee {
	
	@Test
	public void delete_trainee() {
		Response res = RestAssured
				.given()
				.when()
				.delete("http://localhost:3000/trainees/apTEHQHjhCw");
		Assert.assertEquals(res.getStatusCode(),200);
	}
}
