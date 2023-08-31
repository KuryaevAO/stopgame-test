package com.kuryaevao.test;

import com.kuryaevao.config.CredentialsConfig;
import com.kuryaevao.main.java.io.qameta.allure.Layer;
import com.kuryaevao.pages.ActionPageUI;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.kuryaevao.test.TestData.*;

@Layer("UI")
@Owner("allure8")
@Issue("HOMEWORK-748")

public class StopGameUITests extends TestBase {

    ActionPageUI actionPageUI = new ActionPageUI();
    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    String siteLogin = credentials.siteLogin();
    String sitePassword = credentials.sitePassword();

    @Test
    @Feature("No login features UI")
    @AllureId("23260")
    @DisplayName("Open site")
    @Tag("test_ui")
    void openSiteTest() {

        actionPageUI.openPage();
        actionPageUI.checkPageHeader();
    }

    @Test
    @Feature("Login features UI")
    @AllureId("23254")
    @DisplayName("Login - Logout")
    @Tag("test_ui")
    void loginLogoutTest() {

        actionPageUI.openPage();
        actionPageUI.openLoginForm();
        actionPageUI.typeLogin(siteLogin);
        actionPageUI.typePassword(sitePassword);
        actionPageUI.typeSubmit();
        actionPageUI.userButton();
        actionPageUI.userPage();
        actionPageUI.userNameCheck(siteLogin);
        actionPageUI.userButton();
        actionPageUI.logOutButton();
        actionPageUI.openLoginForm();
    }

    @ParameterizedTest
    @Feature("No login features UI")
    @AllureId("23261")
    @DisplayName("Searching all")
    @Tag("test_ui")
    @ValueSource(strings = {"San Andreas", "The Legend of Zelda", "Splinter Cell"})
    public void searchTest(String searchString) {

        actionPageUI.openPage();
        actionPageUI.searchBar(searchString);
        actionPageUI.searchCheck(searchString);
    }

    @Test
    @Feature("No login features UI")
    @AllureId("23259")
    @DisplayName("Open About resource page")
    @Tag("test_ui")
    void aboutResourceTest() {

        actionPageUI.openPage();
        actionPageUI.goToHelp();
        actionPageUI.goToAboutProject();
        actionPageUI.aboutProject();
    }

    @Test
    @Feature("No login features UI")
    @AllureId("23258")
    @DisplayName("Checking tags")
    @Tag("test_ui")
    void tagCheckTest() {

        actionPageUI.openPage();
        actionPageUI.searchBar(gameName);
        actionPageUI.proceedToTheGame();
        actionPageUI.platformCheck(platformName);
        actionPageUI.platformTextCheck();
    }

    @Test
    @Feature("No login features UI")
    @AllureId("23256")
    @DisplayName("Checking developers")
    @Tag("test_ui")
    void developerCheckTest() {

        actionPageUI.openPage();
        actionPageUI.searchBar(gameName);
        actionPageUI.proceedToTheGame();
        actionPageUI.developerCheck(developerName);
    }

    @Test
    @Feature("No login features UI")
    @AllureId("23257")
    @DisplayName("Checking last comment")
    @Tag("test_ui")
    void latestCommentTest() {

        actionPageUI.openPage();
        actionPageUI.commentsButtonCheck();
        actionPageUI.latestCommentProceed();
        actionPageUI.latestCommentOnPageCheck();
    }

    @Test
    @Feature("Login features UI")
    @AllureId("23255")
    @DisplayName("Adding the game to the profile")
    @Tag("test_ui")
    void addGameTest() {

        actionPageUI.openPage();
        actionPageUI.openLoginForm();
        actionPageUI.typeLogin(siteLogin);
        actionPageUI.typePassword(sitePassword);
        actionPageUI.typeSubmit();
        actionPageUI.userButton();
        actionPageUI.userPage();
        actionPageUI.pressAddGame();
        actionPageUI.selectAddGame(gameName);
        actionPageUI.setStatusToAddGame();
        actionPageUI.refreshPage();
        actionPageUI.openAddedGame();
        actionPageUI.deleteAddedGame();
        actionPageUI.refreshPage();
        actionPageUI.userButton();
        actionPageUI.logOutButton();
    }

    @Test
    @Feature("No login features UI")
    @AllureId("23262")
    @DisplayName("Searching Users")
    @Tag("test_ui")
    void checkUsersTest() {

        actionPageUI.openPage();
        actionPageUI.searchForUser(fakerUser);
        actionPageUI.searchForUserList();
        actionPageUI.userListCheck(fakerUser);

    }

    @Test
    @Feature("No login features UI")
    @AllureId("23277")
    @DisplayName("Social networks check")
    @Tag("test_ui")
    void checkSocialNetworksTest() {

        actionPageUI.openPage();
        actionPageUI.networkVkCheck();
        actionPageUI.networkSteamCheck();
        actionPageUI.networkTwitchCheck();
    }
}
