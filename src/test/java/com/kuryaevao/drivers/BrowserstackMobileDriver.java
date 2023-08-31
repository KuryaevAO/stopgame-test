package com.kuryaevao.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.kuryaevao.config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    public static URL getBrowserStackUrl() {
        try {
            return new URL(browserstackConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", browserstackConfig.user());
        desiredCapabilities.setCapability("browserstack.key", browserstackConfig.key());
        desiredCapabilities.setCapability("app", browserstackConfig.baseUrl());
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserStackUrl(), desiredCapabilities);
    }
}