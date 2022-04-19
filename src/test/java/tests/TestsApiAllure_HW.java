package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class TestsApiAllure_HW extends TestBase
{

    // №1----------------------------------------------------------------
    @Test
    void registerNewUserTest200() {
        /*
        ВХОДНЫЕ ДАННЫЕ:

        request: https://reqres.in/api/register

        data:
        {
        "email": "eve.holt@reqres.in",
        "password": "pistol"
        }

        response:
        {
        "id": 4,
        "token": "QpwL5tke4Pnpja7X4"
        }
         */

        String registerData = "{\"email\": \"eve.holt@reqres.in\",\n" +
                "\"password\": \"pistol\"}";

        given()
                .body(registerData)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

// ---------------------------------------------№2

    @Test
    void updateUserTest() {
        String data = "{\"name\": \"morpheus2\", \"job\": \"zion resident1\"}";
        given()
                .body(data)
                .contentType(JSON)
                .when()
                .put("https://reqres.in/api/users")//put
                .then()
                .body("name", is("morpheus2"))
                .body("job", is("zion resident1"));
    }
}
