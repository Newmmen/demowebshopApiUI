package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.tests.pages.CartPage;
import com.tricentis.demowebshop.tests.pages.ClientPage;
import com.tricentis.demowebshop.tests.pages.LoginPage;
import com.tricentis.demowebshop.tests.pages.MainPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@DisplayName("Demowebshop WEB-positive tests")
public class PositiveTest extends TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());

    ClientPage clientPage = new ClientPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();


    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        clientPage.registerUser();
        clientPage.checklogin();
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        clientPage.registerUser();
        clientPage.checklogin();
        clientPage.updateUserInfo();
    }

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Check add product to cart")
    @Test
    public void addProductToCart() {
        clientPage.registerUser();
        clientPage.checklogin();
        clientPage.addToProductCart();
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
        clientPage.registerUser()
                .checklogin()
                .addToProductCart();
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

    @Tags({@Tag("Positive"), @Tag("Web")})
    @DisplayName("Check displaying order information in my account")
    @Test
    public void checkOrderFromMyAccount() {
        clientPage.registerUser()
                .checklogin()
                .addToProductCart();
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
                .checkOrder()
                .checkAccountOrder();
    }
}



