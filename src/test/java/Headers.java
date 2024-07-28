import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Headers {
    @Test
    public void test() {
        given().
                when().get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html ;charset=ISO-8859-1")
                .and()
                .header("Content-Encoding", "gzip")
                .and()
                .header("Server", "gws");


    }
    @Test
    public void test2() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
      //  String headerValue = res.getHeader("Content-Type");
     //   System.out.println("the value is "+headerValue);
        // get all headers info
        io.restassured.http.Headers myheaders = res.getHeaders();
        for (Header header : myheaders) {
            System.out.println(header.getName()+":"+header.getValue());
        }

    }
}
