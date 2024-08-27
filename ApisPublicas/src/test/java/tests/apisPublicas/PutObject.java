package tests.apisPublicas;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PutObject {

    @BeforeTest
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }

    @Test
    public void  putObject() {

        File putbody = new File("src/main/resources/putObject.json");
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(putbody);

        Response response = request
                .when()
                .put("/ff80818190ee49c90190f08fbe0c0694");

        response.prettyPrint();
        int statusCode = response.statusCode();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}

