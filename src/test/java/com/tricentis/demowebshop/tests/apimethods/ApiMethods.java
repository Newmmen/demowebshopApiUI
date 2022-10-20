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
import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;

public class ApiMethods extends TestBase {
    String requestVerificationTokenName = "__RequestVerificationToken",
            verificationHeaderTokenValue = "IP4jfNRksVWo0-GqirtkFoj8qlQRP_wKLTF_eiraVLaw2r2QcldG5nHRxkj8EOKrwcb2A0JMgunzuQEukv0Fe1BUcmjE_ZQxYhbnQgCX8bo1",
            verificationBodyTokenValue = "vw5kENKh-fmRgG-hMCwUE_-YX7OpEOhzADZkTbADncdxPGOI7Yc4kJxfn2rNpunLUn0u0MHXPpJ4Y8rRCo9uAuwM82VkDt5VgbcaLI6MHy01",
            authCookieName = "NOPCOMMERCE.AUTH",
            nopCookieName = "Nop.customer";


    public String register(TestData userData) {
        String nopCookie = given()
                .contentType("application/x-www-form-urlencoded")
                .log().all()
                .formParam(requestVerificationTokenName, verificationBodyTokenValue)
                .formParam("Gender", "M")
                .formParam("FirstName", userData.firstName)
                .formParam("LastName", userData.lastName)
                .formParam("Email", userData.email)
                .formParam("Password", userData.password)
                .formParam("ConfirmPassword", userData.password)
                .cookie(requestVerificationTokenName, verificationHeaderTokenValue)
                .when()
                .post("/register")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie(nopCookieName);
        return nopCookie;
    }

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

    public void updateUserData(TestData userData) {

    }

    public String loginUser(TestData userData) {
        String authCookie = given()
                .contentType("application/x-www-form-urlencoded")
                .log().all()
                .formParam("Email", userData.email)
                .formParam("Password", userData.password)
                .cookie(requestVerificationTokenName, verificationHeaderTokenValue)
                .when()
                .post("/login")
                .then()
                .log().all()
                //    .statusCode(302)
                .extract().cookie(authCookieName);
        System.out.println(authCookie);

        return authCookie;
    }


    public void checklogin(TestData userData, Map<String, String> cookies) {

        String authCookie = cookies.get(authCookieName);

        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie(authCookieName, authCookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");
        $(".account").shouldHave(Condition.text(userData.email));
    }


    public Response register() {
        // @formatter:off
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/register")
                .then()
                .log().all()
                .extract()
                .response();
        // @formatter:on
    }
}
