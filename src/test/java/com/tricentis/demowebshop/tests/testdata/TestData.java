package com.tricentis.demowebshop.tests.testdata;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            password = faker.internet().password();
    private String authTokenName;

    public void setAuthTokenName(String authTokenName) {
        this.authTokenName = authTokenName;
    }

    public String getAuthTokenName() {
        return authTokenName;
    }
}

