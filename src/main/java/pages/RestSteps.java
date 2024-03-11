package pages;

import io.restassured.response.Response;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class RestSteps {

    public void getApi(String baseUri, int statusCode){
    Response response = given()
//                .header("Content-type","application/json")
                .baseUri(baseUri)
                .get()
                .then()
                .log().all()
                .assertThat()
                .statusCode(statusCode)
            .extract().response();
    }

    public void postApi(String baseUri, String postUri, String body, int statusCode){

       Response response =  given()
                .header("Content-type","application/json")
                .header("charset","utf-8")
                .baseUri(baseUri)
                .body(body)
                .when()
                .post(postUri)
                .then()
                .statusCode(statusCode)
                .log().body()
                .extract().response();

        System.out.println(Optional.ofNullable(response.body().path("name")));
    }
}
