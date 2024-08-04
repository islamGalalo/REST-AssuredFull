import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AutheAndAuthorization
{

//Authentication = user valid or not
// authorization = user permission or access


    @Test
    public void Basicauth(){
        given()
                .auth().basic("postmn", "pasword")
                .when().get("https://postmn/auth")
                .then()
                .statusCode(200)
                .body("authentiacated",equalTo(true))
                .log().all();
    }


    @Test
    public void digestauth(){
        given()
                .auth().digest("postmn", "pasword")
                .when().get("https://postmn/auth")
                .then()
                .statusCode(200)
                .body("authentiacated",equalTo(true))
                .log().all();
    }

    @Test
    public void Preemptivetauth(){
        given()
                .auth().preemptive().basic("postmn", "pasword")
                .when().get("https://postmn/auth")
                .then()
                .statusCode(200)
                .body("authentiacated",equalTo(true))
                .log().all();
    }


    @Test
    public void BearerTokenAuth(){
        given()
                .auth().basic("postmn", "pasword")
                .when().get("https://postmn/auth")
                .then()
                .statusCode(200)
                .body("authentiacated",equalTo(true))
                .log().all();
    }





}
