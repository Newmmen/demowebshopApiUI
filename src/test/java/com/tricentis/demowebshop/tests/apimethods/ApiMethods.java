package com.tricentis.demowebshop.tests.apimethods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.tests.testbase.TestBase;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


public class ApiMethods extends TestBase {
    String requestVerificationTokenName = "__RequestVerificationToken",
            authCookieName = "NOPCOMMERCE.AUTH";


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

    public void checklogin(TestData userData, String authCookie) {
        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie(authCookieName, authCookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");
        $(".account").shouldHave(Condition.text(userData.email));
    }

    public void editUserInfo(TestData userData) {
        $(".account").click();
        $(".page-body #FirstName").setValue(userData.firstName);
        $(".page-body #LastName").setValue(userData.lastName);
        $(".page-body #Email").setValue(userData.email);
        $(".buttons [name='save-info-button']").click();
        $(".account").shouldHave(Condition.text(userData.email));

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
