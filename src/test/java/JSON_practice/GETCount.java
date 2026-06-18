package JSON_practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETCount {
	
	@Test
	public void post_resources() {
		Response res = RestAssured
				.given()
				.when()
				.get("https://jsonplaceholder.typicode.com/posts");
		System.out.println("Ststus code : "+res.getStatusCode());
		res.prettyPrint();
		int count = res.jsonPath().getList("$").size();
		System.out.println(count);
		res.then()
		.statusCode(200);
		Assert.assertEquals(count,100);
	}

}