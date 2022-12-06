package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.pages.*;
import com.tricentis.demowebshop.steps.ApiSteps;
import com.tricentis.demowebshop.steps.WebSteps;
import com.tricentis.demowebshop.tests.testdata.TestData;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Demowebshop WEB-positive tests")
public class PositiveTest extends TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());

    TestData editedUserData = new TestData();
    ClientPage clientPage = new ClientPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();
    UserInfoPage userPage = new UserInfoPage();
    ApiSteps apiStep = new ApiSteps();
    WebSteps webSteps = new WebSteps();


    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        apiStep.registerUser();
        webSteps.checklogin();
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        apiStep.registerUser();
        webSteps.checklogin();
        userPage.updateUserInfo(editedUserData);
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Check add product to cart")
    @Test
    public void addProductToCart() {
        apiStep.registerUser();
        webSteps.checklogin();
        apiStep.addToProductCart();
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Check login existing user")
    @Test
    public void loginExistUser() {
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUserEmail(), data.getUserPassword())
                .clickLogIn()
                .checkSuccessLogin(data.getUserEmail());
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Check making order full process")
    @Test
    public void checkOrderProcess() {
        apiStep.registerUser();
        webSteps.checklogin();
        apiStep.addToProductCart();
        cartPage.makeOrder()
                .setDeliverInfo(data.getDeliverCountry(),
                        data.getDeliverState(),
                        data.getDeliverZip(),
                        data.getDeliverAddress(),
                        data.getDeliverPhone(),
                        data.getDeliverCity())
                .confirmShippingAddress()
                .confirmPaymentMethod()
                .confirmPaymentInformation()
                .confirmOrder()
                .checkOrder();
    }

//    @Tags({@Tag("Positive"), @Tag("Web")})
//    @DisplayName("Check displaying order information in my account")
//    @Test
//    public void checkOrderFromMyAccount() {
//        clientPage.registerUser()
//                .checklogin()
//                .addToProductCart();
//        cartPage.makeOrder()
//                .setDeliverInfo(data.getDeliverCountry(),
//                        data.getDeliverState(),
//                        data.getDeliverZip(),
//                        data.getDeliverAddress(),
//                        data.getDeliverPhone(),
//                        data.getDeliverCity())
//                .confirmShippingAddress()
//                .confirmPaymentMethod()
//                .confirmPaymentInformation()
//                .confirmOrder()
//                .checkOrder()
//                .checkAccountOrder();
//    }
}



