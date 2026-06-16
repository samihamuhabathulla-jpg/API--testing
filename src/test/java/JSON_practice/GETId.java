package JSON_practice;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETId {

	@Test
	public void posts_routes() {
		Response res = RestAssured
				.given()
				.when()
				.get("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println("Status : "+res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(), 200);
		int id = res.jsonPath().getInt("id");
		Assert.assertEquals(id, 1);
	}
}


