package com.albertsons.step_definitions;

import com.albertsons.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

public class Hook {

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;
    public static RequestSpecification userSpec;

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

}
