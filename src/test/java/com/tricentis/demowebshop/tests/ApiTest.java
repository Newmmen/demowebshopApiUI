package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.tests.apimethods.ApiActionsMethods;
import com.tricentis.demowebshop.tests.testbase.TestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ApiTest extends TestBase {

    ApiActionsMethods apiActionsMethods = new ApiActionsMethods();

    @Owner("kurenkoya")
    @Tag("demowebshop")
    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        apiActionsMethods.registerUser();
        apiActionsMethods.checklogin();

    }

    @Tag("demowebshop")
    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        apiActionsMethods.registerUser();
        apiActionsMethods.checklogin();
        apiActionsMethods.updateUserInfo();

    }
}



