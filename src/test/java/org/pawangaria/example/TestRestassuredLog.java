package org.pawangaria.example;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TestRestassuredLog {

    private static final Logger logger = LogManager.getLogger(TestRestassuredLog.class);

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
