package restassured_practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OptionsTrainee {

    @Test
    public void options_trainee() {

        Response res = RestAssured
                .given()
                .when()
                .options("http://localhost:3000/trainees");
        System.out.println("Status Code : " + res.getStatusCode());
        System.out.println("Headers : " + res.getHeaders());
        res.then()
        .statusCode(204);
    }
}