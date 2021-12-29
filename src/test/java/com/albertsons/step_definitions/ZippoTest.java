package com.albertsons.step_definitions;

import com.albertsons.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class ZippoTest {
    Response response;

    @Given("User use zipcode {int} as a path param on the GET request")
    public void user_use_zipcode_as_a_path_param_on_the_get_request(int zipCode) {
        response = given().accept(ContentType.JSON)
                .and().pathParam("zipcode",zipCode)
                .when().get("/us/{zipcode}");
    }
    @When("Status code must be {int}")
    public void status_code_must_be(int code) {
       assertEquals(code,response.statusCode());
    }

    @Then("Content type must be {string}")
    public void contentTypeMustBe(String contentType) {
       assertEquals(contentType,response.contentType());
    }
}
