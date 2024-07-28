import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SchemaValidation {

    /*
    json/xml schema validations
    response validation = data
    schema validations = type of data
    response validate to schema
     */
    @Test
    public void JsonSchemaValidation() {
        given()
                .when()
                .get("http://localhost:3000/book")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("scema.json"));


    }
    @Test
    public void XMLSchemaValidation() { //xml schema validation is not applicable in postman
        given()
                .when()
                .get("https://ws.appointment-plus.com/Locations/GetLocations")
                .then()
                .assertThat()
                .body(RestAssuredMatchers.matchesDtdInClasspath("scema.xsd"));

    }

}
