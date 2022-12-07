package com.tricentis.demowebshop.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Web")
@DisplayName("Demowebshop user registration tests")
public class UserRegistrationTests extends TestBase {

    @Tags({@Tag("Positive"), @Tag("Registration")})
    @DisplayName("Checking new user registration")
    @Test
    public void checkUserRegister() {
        apiStep.registerUser();
        webSteps.authorizeWithCookie();
    }
}
