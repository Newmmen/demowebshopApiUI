package com.tricentis.demowebshop.steps;

import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static com.tricentis.demowebshop.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;


public class ApiSteps {

    public static Map<String, String> trueToken = new HashMap<>();
    public static String userEmail;
    TestData userData = new TestData();
    String requestVerificationTokenName = "__RequestVerificationToken";

    private Response registerNewUser(TestData userData, Map<String, String> cookies, String authToken) {
        return given()
                .spec(registerUserRequest)
                .formParam(requestVerificationTokenName, authToken)
                .formParam("Gender", "M")
                .formParam("FirstName", userData.firstName)
                .formParam("LastName", userData.lastName)
                .formParam("Email", userData.email)
                .formParam("Password", userData.password)
                .formParam("ConfirmPassword", userData.password)
                .cookies(cookies)
                .when()
                .post()
                .then()
                .statusCode(302)
                .spec(responseSpec)
                .extract()
                .response();

    }


    private void addToCartTest(Map<String, String> cookies) {
        given()
                .spec(requestSpec)
                .cookies(cookies)
                .when()
                .post("/addproducttocart/catalog/31/1/1")
                .then()
                .statusCode(200)
                .spec(responseSpec);

    }

    private Response register() {
        return given()
                .spec(requestSpec)
                .when()
                .get("/register")
                .then()
                .statusCode(200)
                .spec(responseSpec)
                .extract()
                .response();
    }

    public void registerUser() {
        Response cookieResponse = register();
        String token = cookieResponse.htmlPath().getString("**.find{it.@name == '__RequestVerificationToken'}.@value");
        Response registerNewUser = registerNewUser(userData, cookieResponse.cookies(), token);
        trueToken = registerNewUser.cookies();
        userEmail = userData.email;

    }

    @Step("Add product to cart")
    public ApiSteps addToProductCart() {
        addToCartTest(trueToken);
        return this;
    }

}
