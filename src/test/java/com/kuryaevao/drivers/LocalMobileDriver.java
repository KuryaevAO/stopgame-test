package com.kuryaevao.drivers;

import com.codeborne.selenide.WebDriverProvider;
import com.kuryaevao.config.LocalConfig;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalMobileDriver implements WebDriverProvider {

    static final LocalConfig localConfig =
            ConfigFactory.create(LocalConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(localConfig.baseUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Nonnull
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", localConfig.platformName());
        desiredCapabilities.setCapability("deviceName", localConfig.deviceName());
        desiredCapabilities.setCapability("version", localConfig.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "ru.yandex.translate");
        desiredCapabilities.setCapability("appActivity", "ru.yandex.translate.ui.activities.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath("apk/yandex.translate.apk"));


        return new AndroidDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}