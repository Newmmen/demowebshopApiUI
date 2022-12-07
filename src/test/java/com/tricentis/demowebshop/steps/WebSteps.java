package com.tricentis.demowebshop.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.tricentis.demowebshop.steps.ApiSteps.trueToken;
import static com.tricentis.demowebshop.steps.ApiSteps.userEmail;

public class WebSteps {

    private void setCookieToWebDriver(String authCookie) {
        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie("NOPCOMMERCE.AUTH", authCookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");

    }

    @Step("Authorize with added cookie")
    public WebSteps authorizeWithCookie() {
        setCookieToWebDriver(trueToken.get("NOPCOMMERCE.AUTH"));
        $(".account").shouldHave(Condition.text(userEmail));
        return this;

    }


}
