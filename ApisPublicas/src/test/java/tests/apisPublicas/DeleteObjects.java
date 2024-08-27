package tests.apisPublicas;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class DeleteObjects {

    @BeforeTest
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }
        @Test
        public void getObjects(){
            RequestSpecification request = given()
                    .baseUri("https://api.restful-api.dev")
                    .basePath("/objects");

            Response response = request
                    .when()
                    .delete("/ff80818190ee49c90190f08ede340693");

            response.prettyPrint();
            int statusCode = response.getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }
