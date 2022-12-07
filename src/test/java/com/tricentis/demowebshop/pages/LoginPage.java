package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Login validation for existing user")
    public LoginPage setLoginData(String userEmail, String userPassword) {
        $("#Email").setValue(userEmail);
        $("#Password").setValue(userPassword);
        return this;
    }

    @Step("Click Log-in")
    public LoginPage clickLogIn() {
        $("[value='Log in']").click();
        return this;
    }

    @Step("Login validation for existing user")
    public LoginPage checkSuccessLogin(String existUserEmail) {
        $(".account").shouldHave(Condition.text(existUserEmail));
        return this;
    }

    @Step("Check failure login")
    public LoginPage checkFailureLogin() {
        $(".validation-summary-errors")
                .shouldHave(Condition.text("Login was unsuccessful. Please correct the errors and try again."));
        return this;
    }
}
