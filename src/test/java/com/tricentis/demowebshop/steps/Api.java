package com.tricentis.demowebshop.steps;

import com.tricentis.demowebshop.tests.TestBase;
import com.tricentis.demowebshop.tests.pages.MainPage;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.restassured.response.Response;

import java.util.Map;

import static com.tricentis.demowebshop.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Api extends TestBase {
    String requestVerificationTokenName = "__RequestVerificationToken";
    MainPage mainPage = new MainPage();



    public Response registerUser(TestData userData, Map<String, String> cookies, String authToken) {
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
                .spec(registerUserResponse)
                .extract()
                .response();

    }

    public void addToCartTest(String userToken, String userAuthToken) {
         String productQuantity =  given()
                .spec(apiAddProductRequest)
                .cookie("Nop.customer", userToken)
                .cookie("NOPCOMMERCE.AUTH", userAuthToken)
                .when()
                .post("/31/1/1")
                .then()
                .spec(apiAddProductResponse)
                .extract()
                .path("updatetopcartsectionhtml");

         assertThat(productQuantity).isEqualTo(mainPage.getCardQty());


    }

    public Response register() {
        return given()
                .spec(registerRequest)
                .when()
                .get()
                .then()
                .spec(registerResponse)
                .extract()
                .response();
    }


}
