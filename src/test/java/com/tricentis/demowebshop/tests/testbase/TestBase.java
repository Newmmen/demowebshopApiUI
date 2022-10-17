package com.tricentis.demowebshop.tests.testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    @BeforeEach
            public void configure(){
        Configuration.baseUrl = "https://demowebshop.tricentis.com/";
        RestAssured.baseURI = "https://demowebshop.tricentis.com/";

    }



}
