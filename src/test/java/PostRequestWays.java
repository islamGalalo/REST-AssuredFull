import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestWays {
    int id;

    //1- Post request body using Hashmap
    @Test(priority = 1)
    public void testPostRequestHashMap() {
        HashMap data = new HashMap();
        data.put("name", "Lebron");
        data.put("location", "North America");
        data.put("phone", "343444");
        String[] courseArr = {"c", "c++"};
        data.put("courses", courseArr);

        given().contentType("application/json").body(data)
                .when().post("http://localhost:3000/students")

                .then().statusCode(201)
                .body("name", equalTo("Lebron"))
                .body("location", equalTo("North America"))
                .body("phone", equalTo("343444"))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                .header("Content-Type", "application/json")
                .log().all();
        id =
                given().contentType("application/json").body(data).
                        when().post("https://reqres.in/api/users")
                        .jsonPath().getInt("id");


    }

    @Test(priority = 2)
    void deleteReq() {
        given().
                when().delete("http://localhost:3000/students/" + id)
                .then().statusCode(200);

    }

    // post request using org.json library
    @Test
    void PostReqJSON() {
        JSONObject jsObj = new JSONObject();

        jsObj.put("name", "messi");
        jsObj.put("location", "America");
        jsObj.put("phone", "343444");
        String courses[] = {"java", "C#"};
        jsObj.put("courses", courses);
        given().contentType("application/json").body(jsObj.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name", equalTo("messi"))
                .body("location", equalTo("America"))
                .header("Content-Type", "application/json;charset=uft-8")
                .log().all();

    }

    // post request using POJO class
    @Test
    void postReqPOJO() {
        POJO_PostReq pojo = new POJO_PostReq();
        pojo.setName("leo");
        pojo.setLocation("America");
        pojo.setPhone("343444");
        String courses[] = {"java", "C#"};
        pojo.setCourses(courses);

        given().contentType("application/json").body(pojo)
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name", equalTo("leo"))
                .body("location", equalTo("America"))
                .log().all();

    }


    //  post request using External jsonfile
    @Test
    void postReqExtnalfie() throws FileNotFoundException {

        File f = new File("src/test/java/body.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);







        given().contentType("application/json").body(data.toString())
                .when().post("http://localhost:3000/students")
                .then().statusCode(201)
                .body("name", equalTo("leo"))
                .body("location", equalTo("America"))
                .log().all();

    }
}

