package com.kuryaevao.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.kuryaevao.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        CredentialsConfig credentials =
                ConfigFactory.create(CredentialsConfig.class);

        String login = credentials.login();
        String password = credentials.password();

        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String browserVersion = System.getProperty("browserVersion", "100");
        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        String remoteUrl =  System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub/");

        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadTimeout = 600000;
        Configuration.baseUrl = baseUrl;
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        /*
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://"+login+":"+password+"@"+remoteUrl;
        */
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
