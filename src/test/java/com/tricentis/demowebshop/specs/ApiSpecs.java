package com.tricentis.demowebshop.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.tricentis.demowebshop.specs.CustomListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class ApiSpecs {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .baseUri("https://demowebshop.tricentis.com")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification registerUserRequest = with()
            .filter(withCustomTemplates())
            .baseUri("https://demowebshop.tricentis.com")
            .basePath("/register")
            .log().all()
            .contentType("application/x-www-form-urlencoded");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

}
