package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.tests.pages.LoginPage;
import com.tricentis.demowebshop.tests.pages.MainPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Demowebshop WEB-negative tests")
public class NegativeTests extends TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @Test
    @Tags({@Tag("Negative"), @Tag("Web")})
    @DisplayName("Check login with undefined user data")
    public void loginUndefinedUser() {
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUndefinedEmail(), data.getUndefinedPassword())
                .clickLogIn()
                .checkFailureLogin();
    }

    @Test
    @Tags({@Tag("Negative"), @Tag("Web")})
    @DisplayName("Check login with empty user data")
    public void loginEmptyUserData() {
        mainPage.openLoginPage();
        loginPage.clickLogIn()
                .checkFailureLogin();
    }

}
