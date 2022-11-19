package com.tricentis.demowebshop.tests.pages;

import com.tricentis.demowebshop.tests.TestBase;
import com.tricentis.demowebshop.tests.models.PojoResponseCart;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ApiMethods extends TestBase {
    String requestVerificationTokenName = "__RequestVerificationToken";
    PojoResponseCart responseCart = new PojoResponseCart();
    MainPage mainPage = new MainPage();



    public Response registerUser(TestData userData, Map<String, String> cookies, String authToken) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .log().all()
                .formParam(requestVerificationTokenName, authToken)
                .formParam("Gender", "M")
                .formParam("FirstName", userData.firstName)
                .formParam("LastName", userData.lastName)
                .formParam("Email", userData.email)
                .formParam("Password", userData.password)
                .formParam("ConfirmPassword", userData.password)
                .cookies(cookies)
                .when()
                .post("/register")
                .then()
                .log().all()
                .statusCode(302)
                .extract()
                .response();

    }

    public void addToCartTest(String userToken, String userAuthToken) {
         responseCart =  given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("Nop.customer", userToken)
                .cookie("NOPCOMMERCE.AUTH", userAuthToken)
                .when()
                .post("https://demowebshop.tricentis.com/addproducttocart/catalog/31/1/1")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract()
                .as(PojoResponseCart.class);

         assertThat(responseCart.getUpdatetopcartsectionhtml()).isEqualTo(mainPage.getCardQty());


    }

    public Response register() {
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/register")
                .then()
                .log().all()
                .extract()
                .response();
    }


}
