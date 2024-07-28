import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequest {
      int id ;

    @Test (priority = 1)
    public void ListUser() {
        when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).body("page", equalTo(2)).log().all();
    }
    @Test
    public void createUser() {
        HashMap data = new HashMap();
        data.put("name", "John");
        data.put("job", "QA");



        given().contentType("application/json").body(data).
        when().post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .log().all();

    }
    @Test (priority = 2)
    public void createUser1() {
        HashMap data = new HashMap();
        data.put("name", "LEO");
        data.put("job", "1");


        id=
        given().contentType("application/json").body(data).
                when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");




    }
    @Test (priority = 3 , dependsOnMethods = {"createUser1"})
    public void UpdateUser() {
        HashMap data = new HashMap();
        data.put("name", "Henry");
        data.put("job", "tester");

                given().contentType("application/json").body(data)
                        .when().put("https://reqres.in/api/users/"+id)
                        .then()
                        .statusCode(200)
                        .log().all();

    }
    @Test (priority = 4)
    public void DeleteUser() {
        given().contentType("application/json")
                .when().delete("https://reqres.in/api/users/"+id)
                .then().statusCode(204).log().all();
    }

}
