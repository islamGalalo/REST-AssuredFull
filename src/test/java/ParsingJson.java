import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class ParsingJson {
    @Test
    public void parseJson() {
        given()
                .contentType("ContentType.JSON")
                .when().get("http://localhost:3000/book")
                .then().statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                .body("book[0].title", equalTo("the man how create football history"))
                .log().all  ();
    }
}
