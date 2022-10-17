package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.tests.apimethods.ApiMethods;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class ApiTest {
    TestData userData = new TestData();
    TestData anotherUserData = new TestData();
    ApiMethods apiMethods = new ApiMethods();

    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        apiMethods.registerUser(userData);
    }

    @DisplayName("Checking new user register and login")
    @Test
    public void checklogin() {
        apiMethods.registerUser(userData);
        apiMethods.checklogin(userData);


    }


}



