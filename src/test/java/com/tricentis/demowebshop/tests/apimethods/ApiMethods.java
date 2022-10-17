package com.tricentis.demowebshop.tests.apimethods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.tests.testbase.TestBase;
import com.tricentis.demowebshop.tests.testdata.TestData;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class ApiMethods extends TestBase {
    String requestVerificationTokenName = "__RequestVerificationToken",
            verificationHeaderTokenValue = "wGPJsXrZ4IpKQD_EzxPfZND-3MlrlwsqsQLaVio8q97mHn_txyS_Xm4ms-i9FEeC2A30tpWAP5W4lQcvnlhoaYiOIdT5KJStWmEOMUm0o8A1",
            verificationBodyTokenValue = "WsodIlBHxr6KtH62NxgtzZd_PKznpUtKD4tPI5ujUFD9MVn5J-FDxY5N_TqxTf0TCEsIV6D_-FnfCdyw9AzEfTd9ipCmBM_EQqkWVdlnT1s1",
            authCookieName = "NOPCOMMERCE.AUTH";


    public void registerUser(TestData userData) {
        given()
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
                .statusCode(302);
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
                .statusCode(302)
                .extract().cookie(authCookieName);
        System.out.println(authCookie);

        return authCookie;
    }


    public void checklogin(TestData userData) {

        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie(authCookieName, loginUser(userData));
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");
        $(".account").shouldHave(Condition.text(userData.email));
    }

}
