package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.tests.pages.ClientPage;
import com.tricentis.demowebshop.tests.pages.LoginPage;
import com.tricentis.demowebshop.tests.pages.MainPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NegativeTests extends TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());
    ClientPage clientPage = new ClientPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();


    @Test
    @DisplayName("Check login with undefined user data")
    public void loginUndefinedUser(){
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUndefinedEmail(),data.getUndefinedPassword())
                .clickLogIn()
                .checkFailureLogin();

    }
    @Test
    @DisplayName("Check login with empty user data")
    public void loginEmptyUserData(){
        mainPage.openLoginPage();
        loginPage.clickLogIn()
                .checkFailureLogin();

    }

}
