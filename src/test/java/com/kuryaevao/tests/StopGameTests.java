package com.kuryaevao.tests;

import com.kuryaevao.pages.ActionPage;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class StopGameTests extends TestBase {

    ActionPage actionPage = new ActionPage();
    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    String siteLogin = credentials.siteLogin();
    String sitePassword = credentials.sitePassword();

    @Test
    @Tag("testBaseTest")
    void openSiteTest() {

        actionPage.openPage();
        actionPage.checkPageHeader();
    }

    @Test
    @Tag("testBaseTest")
    void loginInTest() {

        actionPage.openPage();
        actionPage.openLoginForm();
        actionPage.typeLogin("userTest");
        actionPage.typePassword("x6Yngdeb");
        actionPage.typeSubmit();
        actionPage.userButton();
        actionPage.userPage();
        actionPage.userNameCheck("userTest");
    }

    @Test
    @Tag("testBaseTest")
    void logOutTest() {

        actionPage.openPage();
        actionPage.openLoginForm();
        actionPage.typeLogin("userTest");
        actionPage.typePassword("x6Yngdeb");
        actionPage.typeSubmit();
        actionPage.userButton();
        actionPage.logOutButton();
        actionPage.openLoginForm();
    }

    @ParameterizedTest
    @ValueSource(strings = {"San Andreas", "The Legend of Zelda", "Splinter Cell"})
    public void searchTest(String searchString) {

        actionPage.openPage();
        actionPage.searchBar(searchString);
        actionPage.searchCheck(searchString);
    }
}
