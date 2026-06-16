package JSON_practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutMethod{

	@Test
	public void post_routes() {
		String requestBody =
				"{"
						+ "\"title\":\"Henry Updated\","
						+ "\"body\":\"Learning API\","
						+ "\"userId\":1"
						+ "}";

    Response res = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .put("https://jsonplaceholder.typicode.com/posts/1");

    System.out.println("Status Code : " + res.getStatusCode());

    res.prettyPrint();

    Assert.assertEquals(res.getStatusCode(), 200);
	}
}