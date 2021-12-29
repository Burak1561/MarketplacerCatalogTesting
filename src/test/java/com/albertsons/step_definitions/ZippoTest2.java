package com.albertsons.step_definitions;

import com.albertsons.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZippoTest2 {
    Response response;

    @Given("User send GET request using path params state {string} and city {string}")
    public void user_send_get_request_using_path_params_state_and_city(String state, String city) {
        response = given().accept(ContentType.JSON)
                .and().pathParam("state",state)
                .and().pathParam("city",city)
                .when().get("/us/{state}/{city}");
    }
    @When("User should get status code {int}")
    public void user_should_get_status_code(Integer int1) {
        assertEquals(200,response.statusCode());
    }
    @Then("User should see content type as application\\/json")
    public void user_should_see_content_type_as_application_json() {

    }

    @Then("User should see content type as {string}")
    public void userShouldSeeContentTypeAs(String contType) {
        assertEquals(contType,response.contentType());
    }
}
