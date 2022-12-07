package com.tricentis.demowebshop.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Web")
@DisplayName("Demowebshop edit user info tests")
public class UserInfoTests extends TestBase {

    @Tags({@Tag("Positive"), @Tag("Info")})
    @DisplayName("Edit registered user data")
    @Test
    public void editUserData() {
        apiStep.registerUser();
        webSteps.checklogin();
        userPage.updateUserInfo(editedUserData);
    }
}
