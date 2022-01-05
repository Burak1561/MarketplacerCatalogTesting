package com.albertsons.step_definitions;

import com.albertsons.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

public class Hook {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    public static RequestSpecification userSpec;
    public static String requestJsonBody;

    @BeforeAll
    @Given("User connected with api baseUrl")
    public static void user_connected_with_api_base_url() {
        baseURI = ConfigurationReader.getProperty("zippoUrl");

        requestSpec = given().accept(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .log().all();
        responseSpec = expect().statusCode(200)
                .and().contentType(ContentType.JSON)
                .logDetail(LogDetail.ALL);
        userSpec =given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("user", "user")
                .log().all();

    }
    @AfterAll
    public static void close() {
        reset();
    }
    //================== Reusable HTTP Requests =================//
    // GET Request
    public static Response get(String endPoint) {
        return given().spec(requestSpec)
                .when().get(endPoint);
    }

    public static Response get(String endPoint, String paramPath, Object paramValue) {
        return given().spec(requestSpec).and()
                .pathParam(paramPath,paramValue)
                .when().get(endPoint);
    }

    public static Response get(String endPoint, String paramPath, Object paramValue,String paramPath1, Object paramValue1) {
        return given().spec(requestSpec).and()
                .pathParam(paramPath,paramValue)
                .pathParam(paramPath1,paramValue1)
                .when().get(endPoint);
    }

    // POST Request
    public static Response post(String endPoint) {
        return given().spec(requestSpec).and()
                .body(requestJsonBody)
                .when().post(endPoint);
    }

    // PUT Request
    public static Response put(String endPoint, int id) {
        return given().spec(requestSpec).and()
                .body(requestJsonBody).and()
                .pathParam("id",id)
                .when().put(endPoint);
    }

    // PATCH Request
    public static Response patch(String endPoint, int id) {
        return given().spec(requestSpec).and()
                .body(requestJsonBody).and()
                .pathParam("id",id)
                .when().patch(endPoint);
    }

    // DELETE Request
    public static Response delete(String endPoint, int id) {
        return given().spec(requestSpec).and()
                .pathParam("id",id)
                .when().delete(endPoint);
    }
}
