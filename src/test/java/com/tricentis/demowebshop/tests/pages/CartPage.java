package com.tricentis.demowebshop.tests.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public CartPage makeOrder(){
        $("#termsofservice").click();
        $("#checkout").click();
        return this;

    }
    public CartPage setDeliverInfo(String deliverCountry,
                                   String deliverState,
                                   String deliverZip,
                                   String deliverAddress,
                                   String deliverPhone,
                                   String deliverCity){
        $("#BillingNewAddress_CountryId").setValue(deliverCountry);
        $("#BillingNewAddress_StateProvinceId").setValue(deliverState);
        $("#BillingNewAddress_City").setValue(deliverCity);
        $("#BillingNewAddress_ZipPostalCode").setValue(deliverZip);
        $("#BillingNewAddress_Address1").setValue(deliverAddress);
        $("#BillingNewAddress_PhoneNumber").setValue(deliverPhone);
        $("[onclick='Billing.save()']").click();
        return this;
    }

    public CartPage confirmShippingAddress(){
        $("#PickUpInStore").click();
        $("[onclick='Shipping.save()']").click();
        return this;
    }
    public CartPage confirmPaymentMethod(){
        $("[onclick='PaymentMethod.save()']").click();
        return this;
    }
    public CartPage confirmPaymentInformation(){
        $("[onclick='PaymentInfo.save()']").click();
        return this;
    }
    public CartPage confirmOrder(){
        $("[onclick='ConfirmOrder.save()']").click();
        return this;
    }
    public CartPage checkOrder(){
        $(".order-completed .title").shouldHave(Condition.text("Your order has been successfully processed!"));
        return this;
    }
}
