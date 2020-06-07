package org.pawangaria.example;

import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestassuredLog {

    private final static Log logger = LogFactory.getLog(TestRestassuredLog.class);

    @Test
    public void makingRestAssuredLogsNoFilter() {
        String getUrl = "http://dummy.restapiexample.com/api/v1/employees";
        Response response = given().log().all().when().get(getUrl).then()
                .extract().response();
        System.out.println(response.prettyPrint());
    }

    @Test
    public void makingRestAssuredLogsToLogFileWithFilter() {
        String getUrl = "http://dummy.restapiexample.com/api/v1/employees";
        Response response = given().filter(new RestAssuredRequestFilter()).when().get(getUrl).then()
                .extract().response();
    }
}
