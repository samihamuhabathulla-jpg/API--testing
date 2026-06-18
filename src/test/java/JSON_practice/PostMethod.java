package JSON_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMethod {

	@Test
	public void post_routes() {
		String requestBody =
				"{"
				+ "\"title\":\"Henry\","
				+ "\"body\":\"Learning API\","
				+ "\"userId\":1"
				+ "}";
		Response res = RestAssured
		        .given()
		        .header("Content-Type", "application/json")
		        .body(requestBody)
		        .when()
		        .post("https://jsonplaceholder.typicode.com/posts");
		System.out.println("Status Code : "+res.getStatusCode());
		res.then()
		.statusCode(201);
	}
}