package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.Condition;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class UserInfoPage {
    @Step("Update user data  and check correction of saving it")
    public void updateUserInfo(TestData userData) {
        $(".account").click();
        $(".page-body #FirstName").setValue(userData.firstName);
        $(".page-body #LastName").setValue(userData.lastName);
        $(".page-body #Email").setValue(userData.email);
        $(".buttons [name='save-info-button']").click();
        $(".account").shouldHave(Condition.text(userData.email));
    }

}
