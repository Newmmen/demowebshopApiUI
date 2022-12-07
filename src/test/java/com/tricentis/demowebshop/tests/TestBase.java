package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.tricentis.demowebshop.config.DataConfig;
import com.tricentis.demowebshop.pages.CartPage;
import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.pages.MainPage;
import com.tricentis.demowebshop.pages.UserInfoPage;
import com.tricentis.demowebshop.steps.ApiSteps;
import com.tricentis.demowebshop.steps.WebSteps;
import com.tricentis.demowebshop.tests.testdata.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.tricentis.demowebshop.attach.WebHelper.*;

public class TestBase {
    static DataConfig data = ConfigFactory.create(DataConfig.class, System.getProperties());
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    TestData editedUserData = new TestData();
    CartPage cartPage = new CartPage();
    UserInfoPage userPage = new UserInfoPage();
    ApiSteps apiStep = new ApiSteps();
    WebSteps webSteps = new WebSteps();

    @BeforeEach
    public void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demowebshop.tricentis.com/";

        Configuration.browserCapabilities = capabilities;
        if (System.getProperty("selenide.remote") != null) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = System.getProperty("selenide.remote");
        }
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

    }

    @AfterEach
    public void addAttachment() {
        takeScreenShot();
        addPageSource();
        if (System.getProperty("selenide.remote") != null) {
            addVideo();
        }
        browserConsoleLog();
    }

}



