package com.tricentis.demowebshop.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.tricentis.demowebshop.tests.testdata.TestData;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UserInfo {

    public void checklogin(TestData userData, String authCookie) {
        open("/Themes/DefaultClean/Content/images/logo.png");
        Cookie cookie = new Cookie("NOPCOMMERCE.AUTH", authCookie);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("");
        $(".account").shouldHave(Condition.text(userData.email));
    }

    public void editUserInfo(TestData userData) {
        $(".account").click();
        $(".page-body #FirstName").setValue(userData.firstName);
        $(".page-body #LastName").setValue(userData.lastName);
        $(".page-body #Email").setValue(userData.email);
        $(".buttons [name='save-info-button']").click();
        $(".account").shouldHave(Condition.text(userData.email));
    }

}
