package com.tricentis.demowebshop.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.tricentis.demowebshop.specs.CustomListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class ApiSpecs {
    public static RequestSpecification apiAddProductRequest = with()
            .filter(withCustomTemplates())
            .baseUri("https://demowebshop.tricentis.com")
            .basePath("/addproducttocart/catalog")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification registerRequest = with()
            .filter(withCustomTemplates())
            .baseUri("https://demowebshop.tricentis.com")
            .basePath("/register")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification registerUserRequest = with()
            .filter(withCustomTemplates())
            .baseUri("https://demowebshop.tricentis.com")
            .basePath("/register")
            .log().all()
            .contentType("application/x-www-form-urlencoded");

    public static ResponseSpecification apiAddProductResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification registerResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification registerUserResponse = new ResponseSpecBuilder()
            .expectStatusCode(302)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();

}
