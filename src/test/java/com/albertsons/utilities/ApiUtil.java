package com.albertsons.utilities;

import com.albertsons.step_definitions.Hook;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiUtil extends Hook {



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
