package com.kuryaevao.tests;

import com.kuryaevao.pages.ActionPage;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.kuryaevao.tests.TestData.*;


public class StopGameTests extends TestBase {

    ActionPage actionPage = new ActionPage();
    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    String siteLogin = credentials.siteLogin();
    String sitePassword = credentials.sitePassword();

    @Test
    @Tag("noAuthorizationTest")
    void openSiteTest() {

        actionPage.openPage();
        actionPage.checkPageHeader();
    }

    @Test
    @Tag("AuthorizationTest")
    void loginInTest() {

        actionPage.openPage();
        actionPage.openLoginForm();
        actionPage.typeLogin(siteLogin);
        actionPage.typePassword(sitePassword);
        actionPage.typeSubmit();
        actionPage.userButton();
        actionPage.userPage();
        actionPage.userNameCheck(siteLogin);
    }

    @Test
    @Tag("AuthorizationTest")
    void logOutTest() {

        actionPage.openPage();
        actionPage.openLoginForm();
        actionPage.typeLogin(siteLogin);
        actionPage.typePassword(sitePassword);
        actionPage.typeSubmit();
        actionPage.userButton();
        actionPage.logOutButton();
        actionPage.openLoginForm();
    }

    @ParameterizedTest
    @Tag("noAuthorizationTest")
    @ValueSource(strings = {"San Andreas", "The Legend of Zelda", "Splinter Cell"})
    public void searchTest(String searchString) {

        actionPage.openPage();
        actionPage.searchBar(searchString);
        actionPage.searchCheck(searchString);
    }

    @Test
    @Tag("noAuthorizationTest")
    void aboutResourceTest() {

        actionPage.openPage();
        actionPage.goToHelp();
        actionPage.goToAboutProject();
        actionPage.aboutProject();
    }

    @Test
    @Tag("noAuthorizationTest")
    void tagCheckTest() {

        actionPage.openPage();
        actionPage.searchBar(gameName);
        actionPage.proceedToTheGame();
        actionPage.platformCheck(platformName);
        actionPage.platformTextCheck();
    }

    @Test
    @Tag("noAuthorizationTest")
    void developerCheckTest() {

        actionPage.openPage();
        actionPage.searchBar(gameName);
        actionPage.proceedToTheGame();
        actionPage.developerCheck(developerName);
    }

    @Test
    @Tag("noAuthorizationTest")
    void latestCommentTest() {

        actionPage.openPage();
        actionPage.commentsButtonCheck();
        actionPage.latestCommentProceed();
        actionPage.latestCommentOnPageCheck();
    }

    @Test
    @Tag("AuthorizationTest")
    void addGameTest() {

        actionPage.openPage();
        actionPage.openLoginForm();
        actionPage.typeLogin(siteLogin);
        actionPage.typePassword(sitePassword);
        actionPage.typeSubmit();
        actionPage.userButton();
        actionPage.userPage();
        actionPage.pressAddGame();
        actionPage.selectAddGame(gameName);
        actionPage.setStatusToAddGame();
        actionPage.refreshPage();
        actionPage.openAddedGame();
        actionPage.deleteAddedGame();
    }

    @Test
    @Tag("noAuthorizationTest")
    void checkUsersTest() {

        actionPage.openPage();
        actionPage.searchForUser(fakerUser);
        actionPage.searchForUserList();
        actionPage.userListCheck(fakerUser);

    }
}
