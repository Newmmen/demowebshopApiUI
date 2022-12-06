package com.tricentis.demowebshop.pages;

import com.codeborne.selenide.Condition;
import com.tricentis.demowebshop.models.PojoToken;
import com.tricentis.demowebshop.steps.ApiSteps;
import com.tricentis.demowebshop.steps.WebSteps;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class ClientPage {
    WebSteps WebSteps = new WebSteps();
    ApiSteps apiStep = new ApiSteps();


//    @Step("Check correction of user registration")
//    public ClientPage checklogin() {
//
//        WebSteps.authorizeWithAddedCookie(userToken.getCookies().get("NOPCOMMERCE.AUTH"));
//        $(".account").shouldHave(Condition.text();
//        return this;
//    }



}








