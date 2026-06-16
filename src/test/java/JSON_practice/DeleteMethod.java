package JSON_practice;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class DeleteMethod {

	    @Test
	    public void deletePost() {

	        Response res = RestAssured
	                .given()
	                .when()
	                .delete("https://jsonplaceholder.typicode.com/posts/1");
	        System.out.println("Status Code : " + res.getStatusCode());
	        res.prettyPrint();
	        assertEquals(res.getStatusCode(), 200);
	    }
	}

