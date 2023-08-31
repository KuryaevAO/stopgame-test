package com.kuryaevao.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.kuryaevao.config.CredentialsConfig;
import com.kuryaevao.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        String remoteUrl = System.getProperty("remoteUrl", "selenoid.autotests.cloud/wd/hub/");
        String pageLoadStrategy = System.getProperty("pageLoadStrategy", "eager");

        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadStrategy = pageLoadStrategy;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://" + login + ":" + password + "@" + remoteUrl;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
