package restassured_practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateTrainee {
	
	@Test
	public void create_post() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "SamihaMuhabathulla");
		payload.put("email", "abcd@gmail.com");
		payload.put("company", "Cognizant");
		payload.put("id", "1");
		
		Response res = RestAssured
				.given()
				.contentType(ContentType.JSON)
                .body(payload)
				.when()
				.post("http://localhost:3000/trainees");
		res.prettyPrint();
	   System.out.println(res.getStatusCode());
	   Assert.assertEquals(res.getStatusCode(),201);
	   Assert.assertEquals(res.jsonPath().getString("company"),"Cognizant");
	}

}
