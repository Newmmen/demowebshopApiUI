package com.tricentis.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.tricentis.demowebshop.attach.WebHelper.*;

public class TestBase {
    DesiredCapabilities capabilities = new DesiredCapabilities();

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



