package com.albertsons.step_definitions;

import com.albertsons.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

public class Hook {


    @BeforeAll
    @Given("User connected with api baseUrl")
    public void user_connected_with_api_base_url() {
        baseURI = ConfigurationReader.getProperty("zippoUrl");
    }

    @AfterAll
    public static void close() {
        reset();
    }

}
