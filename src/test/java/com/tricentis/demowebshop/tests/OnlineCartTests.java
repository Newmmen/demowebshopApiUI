package com.tricentis.demowebshop.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Web")
@DisplayName("Demowebshop online cart tests")
public class OnlineCartTests extends TestBase {

    @Tags({@Tag("Positive"), @Tag("Cart")})
    @DisplayName("Check full process making an order")
    @Test
    public void checkOrderProcess() {
        apiStep.registerUser();
        webSteps.authorizeWithCookie();
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

    @Tags({@Tag("Positive"), @Tag("Cart")})
    @DisplayName("Check displaying order information in my account")
    @Test
    public void checkOrderFromMyAccount() {
        apiStep.registerUser();
        webSteps.authorizeWithCookie();
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
                .checkOrder()
                .checkAccountOrder();
    }

    @Tags({@Tag("Positive"), @Tag("Cart")})
    @DisplayName("Check add product to cart")
    @Test
    public void addProductToCart() {
        apiStep.registerUser();
        webSteps.authorizeWithCookie();
        apiStep.addToProductCart();
    }

}
