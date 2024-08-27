package tests.apisPublicas;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
public class PostObject {
    String path ="./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("path");
    @BeforeTest
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }

    @Test
    public void  postobject() {

        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Prueba");
        File postBody = new File("src/main/resources/createObject.json");
        test.log(Status.INFO,"Paso la ruta del archivo del body que es: "+postBody);
        File postbody = new File("src/main/resources/postObject.json");
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(postbody);

        Response response = request
                .when()
                .post();
        test.log(Status.INFO,"Se realiza el consumo del API ");
        response.prettyPrint();
        int statusCode = response.statusCode();
        test.log(Status.INFO,"El status code es: "+statusCode);
        Assert.assertEquals(response.getStatusCode(),200);
        test.log(Status.PASS,"Test Exitoso");
        extent.flush();
    }
}
