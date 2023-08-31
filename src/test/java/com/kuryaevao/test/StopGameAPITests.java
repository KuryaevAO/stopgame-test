package com.kuryaevao.test;

import com.kuryaevao.main.java.io.qameta.allure.Layer;
import com.kuryaevao.pages.ActionPageAPI;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Layer("API")
@Owner("allure8")
@Issue("HOMEWORK-748")

public class StopGameAPITests {

    ActionPageAPI actionPageAPI = new ActionPageAPI();

    @Test
    @Feature("API features")
    @AllureId("#25559")
    @DisplayName("Login via API")
    @Tag("test_api")
    void loginViaApiTest() {

        actionPageAPI.LoginInViaApi();
    }

    @Test
    @Feature("API features")
    @AllureId("25560")
    @DisplayName("Add the game via API - authorized")
    @Tag("test_api")
    void AddTheGameViaApiTest() {

        actionPageAPI.AddGameViaApiAuthorizationOn();
        actionPageAPI.DeleteGameViaApiAuthorizationOn();
    }

    @Test
    @Feature("API features")
    @AllureId("25558")
    @DisplayName("Add the game via API - not authorized")
    @Tag("test_api")
    void AddTheGameViaApiNoAuthTest() {

        actionPageAPI.AddGameViaApiAuthorizationOff();
    }

    @Test
    @Feature("API features")
    @AllureId("25556")
    @DisplayName("Add the news to favourite via API - authorized")
    @Tag("test_api")
    void AddToFavouritesViaApiAuthTest() {

        actionPageAPI.AddToFavouriteViaApiAuthorizationOn();
        actionPageAPI.DeleteFromFavouriteViaApiAuthorizationOn();
    }

    @Test
    @Feature("API features")
    @AllureId("25557")
    @DisplayName("Add the news to favourite via API - not authorized")
    @Tag("test_api")
    void AddToFavouritesViaApiNoAuthTest() {

        actionPageAPI.AddToFavouriteViaApiAuthorizationOff();
    }
}
