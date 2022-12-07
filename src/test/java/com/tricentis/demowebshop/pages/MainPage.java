package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step("Open login page")
    public MainPage openLoginPage() {
        open("");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        Selenide.refresh();
        $("[href='/login']").click();
        return this;
    }
}
