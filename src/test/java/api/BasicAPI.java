package api;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class BasicAPI {

    @Test
    public void apiBasic_1(){
        given()
                .when()
                .get("http://dummy.restapiexample.com")
                .then()
                .statusCode(200);
    }


}
