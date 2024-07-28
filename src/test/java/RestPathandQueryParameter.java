import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestPathandQueryParameter {
    @Test
    public void test() {
        //https://reqres.in/api/users?page=2&id=5
         given().pathParams("mypath","users") //path parameters
                 .queryParam("page",2) // query parameters
                 .queryParam("id",5) //query parameters
                 .when()
                 .get("https://reqres.in/api/{mypath}")
                       .then()
                 .statusCode(200)
                 .log().all();

    }
}
