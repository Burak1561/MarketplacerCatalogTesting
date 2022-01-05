package com.albertsons.step_definitions;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZippoTest2 {
    Response response;

    @Given("User send GET request using path params state {string} and city {string}")
    public void user_send_get_request_using_path_params_state_and_city(String state, String city) {
        response = Hook.get("/us/{state}/{city}","state",state,"city",city);
    }
    @When("User should get status code {int}")
    public void user_should_get_status_code(Integer int1) {
        assertEquals(200,response.statusCode());
    }

    @Then("User should see content type as {string}")
    public void userShouldSeeContentTypeAs(String contType) {
        assertEquals(contType,response.contentType());
    }

    @And("User should see latitude equal {string}")
    public void userShouldSeeLatitudeEqual(String latitude) {
        JsonPath jsonPath = response.jsonPath();
        assertEquals(latitude,jsonPath.getString("places[0].latitude"));
    }
}
