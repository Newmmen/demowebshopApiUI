package com.tricentis.demowebshop.tests.steps;

import com.tricentis.demowebshop.tests.models.PojoToken;
import com.tricentis.demowebshop.tests.pages.ApiMethods;
import com.tricentis.demowebshop.tests.pages.UserInfo;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

public class ClientSteps {
    UserInfo userInfo = new UserInfo();
    ApiMethods apiClientAction = new ApiMethods();
    TestData userData = new TestData();
    TestData anotherUserData = new TestData();
    PojoToken userToken = new PojoToken();

    @Step("Register new user and get cookie")
    public void registerUser(){
        Response cookieResponce = apiClientAction.register();
        String token = cookieResponce.htmlPath().getString("**.find{it.@name == '__RequestVerificationToken'}.@value");

        Response registerNewUser = apiClientAction.registerUser(userData,cookieResponce.cookies(),token);
        Map<String, String> cookies = registerNewUser.cookies();
        System.out.println("Cookies: " + cookies);
        userToken.setAuthToken(cookies.get("NOPCOMMERCE.AUTH"));
        userToken.setUserToken(cookies.get("Nop.customer"));
    }

    @Step("Check correction of user registration")
    public void checklogin() {
        userInfo.checklogin(userData, userToken.getAuthToken());
    }

    @Step("Check correction of user registration")
    public void addToCartTest(){
            apiClientAction.addToCartTest(userToken.getUserToken(), userToken.getAuthToken());
        }


    @Step("Edit user info and check correction of saving it")
    public  void updateUserInfo(){
        userInfo.editUserInfo(anotherUserData);
    }



}








