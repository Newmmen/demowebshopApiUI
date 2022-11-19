package com.tricentis.demowebshop.tests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    public MainPage openLoginPage(){
        open("");
        $("[href='/login']").click();
        return this;
    }



    public String getCardQty(){
        $("[class='cart-qty']").click();
        return $("[class='cart-qty']").getText();
    }



}
