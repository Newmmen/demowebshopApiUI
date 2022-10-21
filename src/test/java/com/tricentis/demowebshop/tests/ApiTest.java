package com.tricentis.demowebshop.tests;

import com.tricentis.demowebshop.tests.apimethods.ApiActionsMethods;
import com.tricentis.demowebshop.tests.testbase.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApiTest extends TestBase {

    ApiActionsMethods apiActionsMethods = new ApiActionsMethods();

    @DisplayName("Checking new user register")
    @Test
    public void checkUserRegister() {
        apiActionsMethods.registerUser();
        apiActionsMethods.checklogin();

    }

    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        apiActionsMethods.registerUser();
        apiActionsMethods.checklogin();
        apiActionsMethods.updateUserInfo();


    }
}



