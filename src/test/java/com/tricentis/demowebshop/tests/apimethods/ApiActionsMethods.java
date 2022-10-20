package com.tricentis.demowebshop.tests.apimethods;

import com.tricentis.demowebshop.tests.testdata.TestData;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiActionsMethods {
    ApiMethods apiClientAction = new ApiMethods();
    TestData userData = new TestData();


    public Map<String, String> registerUser(){
        Response cookieResponce = apiClientAction.register();
        String token = cookieResponce.htmlPath().getString("**.find{it.@name == '__RequestVerificationToken'}.@value");

        Response registerNewUser = apiClientAction.registerUser(userData,cookieResponce.cookies(),token);

        Map<String, String> cookies = registerNewUser.cookies();
        System.out.println("Cookies: " + cookies);

        return cookies;

    }
    public void checklogin(){
        apiClientAction.checklogin(userData,registerUser());


    }







}
