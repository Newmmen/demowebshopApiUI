package com.tricentis.demowebshop.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Web")
@DisplayName("Demowebshop login tests")
public class LoginUserTests extends TestBase {

    @Tags({@Tag("Positive"), @Tag("Login")})
    @DisplayName("Check login existing user")
    @Test
    public void loginExistUser() {
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUserEmail(), data.getUserPassword())
                .clickLogIn()
                .checkSuccessLogin(data.getUserEmail());
    }

    @Test
    @Tags({@Tag("Negative"), @Tag("Login")})
    @DisplayName("Check login with undefined user data")
    public void loginUndefinedUser() {
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUndefinedEmail(), data.getUndefinedPassword())
                .clickLogIn()
                .checkFailureLogin();
    }

    @Test
    @Tags({@Tag("Negative"), @Tag("Login")})
    @DisplayName("Check login with empty user data")
    public void loginEmptyUserData() {
        mainPage.openLoginPage();
        loginPage.clickLogIn()
                .checkFailureLogin();
    }
}
