package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.tests.pages.CartPage;
import com.tricentis.demowebshop.tests.pages.LoginPage;
import com.tricentis.demowebshop.tests.pages.MainPage;
import com.tricentis.demowebshop.tests.pages.ClientPage;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ClientPageTest extends TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());

    ClientPage clientPage = new ClientPage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();


    @Owner("kurenkoya")
    @Tag("demowebshop")
    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        clientPage.registerUser();
        clientPage.checklogin();

    }

    @Tag("demowebshop")
    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        clientPage.registerUser();
        clientPage.checklogin();
        clientPage.updateUserInfo();

    }

    @Tag("demowebshop")
    @DisplayName("Check add product to cart")
    @Test
    public void addProductToCart() {
        clientPage.registerUser();
        clientPage.checklogin();
        clientPage.addToProductCart();


    }

    @Test
    public void loginExistUser() {
        mainPage.openLoginPage();
        loginPage.setLoginData(data.getUserEmail(), data.getUserPassword())
                .clickLogIn()
                .checkSuccessLogin(data.getUserEmail());

    }

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
}



