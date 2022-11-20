package com.tricentis.demowebshop.tests.pages;

import com.tricentis.demowebshop.models.PojoToken;
import com.tricentis.demowebshop.steps.Api;
import com.tricentis.demowebshop.steps.UserInfo;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

public class ClientPage {
    UserInfo userInfo = new UserInfo();
    Api apiClientAction = new Api();
    TestData userData = new TestData();
    TestData anotherUserData = new TestData();
    PojoToken userToken = new PojoToken();

    @Step("Register new user and get cookie")
    public ClientPage registerUser() {
        Response cookieResponse = apiClientAction.register();
        String token = cookieResponse.htmlPath().getString("**.find{it.@name == '__RequestVerificationToken'}.@value");

        Response registerNewUser = apiClientAction.registerUser(userData, cookieResponse.cookies(), token);
        Map<String, String> cookies = registerNewUser.cookies();
        userToken.setCookies(cookies);
        return this;
    }

    @Step("Check correction of user registration")
    public ClientPage checklogin() {
        userInfo.checklogin(userData, userToken.getCookies().get("NOPCOMMERCE.AUTH"));
        return this;
    }

    @Step("Check correction of user registration")
    public ClientPage addToProductCart() {
        apiClientAction.addToCartTest(userToken.getCookies());
        return this;
    }

    @Step("Edit user info and check correction of saving it")
    public void updateUserInfo() {
        userInfo.editUserInfo(anotherUserData);
    }
}








