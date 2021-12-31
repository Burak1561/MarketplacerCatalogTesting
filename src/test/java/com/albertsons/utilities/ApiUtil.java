package com.albertsons.utilities;

import com.albertsons.step_definitions.Hook;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiUtil extends Hook {
    // GET Request
    public static Response GET(String endPoint) {
        return given().spec(requestSpec)
                .get(endPoint);
    }

    public static Response GET(String endPoint, String paramPath, Object paramValue) {
        return given().spec(requestSpec).and()
                .pathParam(paramPath,paramValue)
                .get(endPoint);
    }

    public static Response GET(String endPoint, String paramPath, Object paramValue,String paramPath1, Object paramValue1) {
        return given().spec(requestSpec).and()
                .pathParam(paramPath,paramValue)
                .pathParam(paramPath1,paramValue1)
                .get(endPoint);
    }

    // POST Request
    public static Response POST(String endPoint) {
        return given().spec(requestSpec).and()
                .get(endPoint);
    }

    public static Response POST(String endPoint, String paramPath, String paramValue) {
        return given().spec(requestSpec).and()
                .pathParam(paramPath,paramValue)
                .get(endPoint);
    }
}
