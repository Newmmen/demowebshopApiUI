package com.tricentis.demowebshop.tests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public void openLoginPage(){
        open("");
        $("[href='login']").click();
    }

    @Step("Login validation for existing user")
    public void loginExistingUser(){
        $("#Email").setValue("");
        $("#Password").setValue("");
        $("[value='Log in']").click();

    }
    @Step("Login validation for existing user")
    public void checkSuccessLogin(String existUserEmail){
        $(".account").shouldHave(Condition.text(existUserEmail));
    }

    public String getCardQty(){
        $("[class='cart-qty']").click();
        return $("[class='cart-qty']").getText();
    }



}
