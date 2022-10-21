package com.tricentis.demowebshop.tests.apimethods;

import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.Map;

public class ApiActionsMethods {
    ApiMethods apiClientAction = new ApiMethods();
    TestData userData = new TestData();
    TestData anotherUserData = new TestData();

    @Step("Register new user and get cookie")
    public void registerUser(){
        Response cookieResponce = apiClientAction.register();
        String token = cookieResponce.htmlPath().getString("**.find{it.@name == '__RequestVerificationToken'}.@value");

        Response registerNewUser = apiClientAction.registerUser(userData,cookieResponce.cookies(),token);
        Map<String, String> cookies = registerNewUser.cookies();
        System.out.println("Cookies: " + cookies);
        userData.setAuthTokenName(cookies.get("NOPCOMMERCE.AUTH"));
        //attach.addAttachments();
    }
    @Step("Check correction of user registration")
    public void checklogin(){
        apiClientAction.checklogin(userData,userData.getAuthTokenName());
        //attach.addAttachments();

    }
    @Step("Edit user info and check correction of saving it")
    public  void updateUserInfo(){
        apiClientAction.editUserInfo(anotherUserData);
        //attach.addAttachments();


    }







}
