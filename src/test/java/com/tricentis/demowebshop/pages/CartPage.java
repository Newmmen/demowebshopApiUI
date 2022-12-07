package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    @Step("Make order")
    public CartPage makeOrder() {
        $(".cart-label").click();
        $("#termsofservice").click();
        $("#checkout").click();
        return this;
    }

    @Step("Set deliver information")
    public CartPage setDeliverInfo(String deliverCountry,
                                   String deliverState,
                                   String deliverZip,
                                   String deliverAddress,
                                   String deliverPhone,
                                   String deliverCity) {
        $("#BillingNewAddress_CountryId").setValue(deliverCountry);
        $("#BillingNewAddress_StateProvinceId").setValue(deliverState);
        $("#BillingNewAddress_City").setValue(deliverCity);
        $("#BillingNewAddress_ZipPostalCode").setValue(deliverZip);
        $("#BillingNewAddress_Address1").setValue(deliverAddress);
        $("#BillingNewAddress_PhoneNumber").setValue(deliverPhone);
        $("[onclick='Billing.save()']").click();
        return this;
    }

    @Step("Confirm shipping address")
    public CartPage confirmShippingAddress() {
        $("#PickUpInStore").click();
        $("[onclick='Shipping.save()']").click();
        return this;
    }

    @Step("Confirm payment method")
    public CartPage confirmPaymentMethod() {
        $("[onclick='PaymentMethod.save()']").click();
        return this;
    }

    @Step("Confirm payment information")
    public CartPage confirmPaymentInformation() {
        $("[onclick='PaymentInfo.save()']").click();
        return this;
    }

    @Step("Confirm order")
    public CartPage confirmOrder() {
        $("[onclick='ConfirmOrder.save()']").click();
        return this;
    }

    @Step("Check order")
    public CartPage checkOrder() {
        $(".order-completed .title").shouldHave(Condition.text("Your order has been successfully processed!"));
        return this;
    }

    @Step("Check account order")
    public CartPage checkAccountOrder() {
        String orderDetails = $(".order-completed .details li").getText();
        $(".account").click();
        $(".block-account-navigation").find(byText("Orders")).click();
        $(".order-item .title").shouldHave(Condition.text(orderDetails));
        return this;
    }
}
