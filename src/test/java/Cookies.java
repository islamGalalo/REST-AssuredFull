import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Cookies
{
    @Test
    public void cooke (){
        given().
                when().get("https://www.google.com/")
                .then()
                .cookie("AEC" ,"AVYB7couFzI0iDiZEbpbVSR2e20im4mMFWILQs2e2PZI8Alka6B7_nuQ73Y")
                .log().all();
    }
    @Test
    public void getCookiesinfo (){
        Response res = given()
                .when().get("https://www.google.com/");

      String cookie_value= res.getCookie("AEC");
      System.out.println("the cookies value is "+cookie_value);


      // get all cookies info
        Map <String,String> allCookies = res.getCookies();
         System.out.println("the cookies map is "+allCookies);








    }

}
