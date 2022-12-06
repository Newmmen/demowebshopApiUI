package com.tricentis.demowebshop.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps  {
  ApiSteps apiSteps = new ApiSteps();


    private void authorizeWithAddedCookie(String authCookie) {
        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie("NOPCOMMERCE.AUTH", authCookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");

    }
    @Step("Check correction of user registration")
    public WebSteps checklogin() {
        authorizeWithAddedCookie(apiSteps.registerUser().get("NOPCOMMERCE.AUTH"));
        $(".account").shouldHave(Condition.text(apiSteps.userData.email));
        return this;
    }







}
