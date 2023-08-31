package com.kuryaevao.pages;

import com.kuryaevao.config.CredentialsConfig;
import com.kuryaevao.test.TestData;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static com.kuryaevao.helpers.Specs.request;
import static com.kuryaevao.helpers.Specs.responseSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ActionPageAPI extends TestData {

    CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);
    String siteLogin = credentials.siteLogin();
    String sitePassword = credentials.sitePassword();
    String userToken = credentials.userToken();

    @Step("Логин через API")
    public void LoginInViaApi() {

        given()
                .log().all()
                .param("login", siteLogin)
                .param("password", sitePassword)
                .when()
                .post("https://stopgame.ru/ajax/auth/login")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("success", is(true));
    }

    @Step("Добавление игры через API - пользователь авторизован")
    public void AddGameViaApiAuthorizationOn() {

        given()
                .spec(request)
                .cookie(userToken)
                .body("{\"gameId\":9205,\"status\":2}")
                .post("https://stopgame.ru/ajax/favourite/watch-game")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("success", is(true), "message", is("Игра добавлена в «Пройдено»"));

    }

    @Step("Добавление игры через API - пользователь не авторизован")
    public void AddGameViaApiAuthorizationOff() {

        given()
                .spec(request)
                .accept("application/json")
                .body("{\"gameId\":9205,\"status\":2}")
                .post("https://stopgame.ru/ajax/favourite/watch-game")
                .then()
                .log().all()
                .body("name", is("Forbidden"), "message", is("Требуется вход."));

    }

    @Step("Удаление игры через API - пользователь авторизован")
    public void DeleteGameViaApiAuthorizationOn() {

        given()
                .spec(request)
                .cookie(userToken)
                .body("{\"gameId\":9205,\"status\":2}")
                .post("https://stopgame.ru/ajax/favourite/watch-game")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("success", is(true), "message", is("Игра удалена из библиотеки"));
    }

    @Step("Добавление в закладки через API - пользователь авторизован")
    public void AddToFavouriteViaApiAuthorizationOn() {

        given()
                .spec(request)
                .cookie(userToken)
                .body("{\"type\":\"news\",\"id\":\"53900\"}")
                .post("https://stopgame.ru/ajax/favourite/change")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("type", is("success"), "message", is("Добавлено в закладки"));
    }

    @Step("Удаление из закладок через API - пользователь авторизован")
    public void DeleteFromFavouriteViaApiAuthorizationOn() {

        given()
                .spec(request)
                .cookie(userToken)
                .body("{\"type\":\"news\",\"id\":\"53900\"}")
                .post("https://stopgame.ru/ajax/favourite/change")
                .then()
                .log().all()
                .spec(responseSpec)
                .body("type", is("warning"), "message", is("Удалено из закладок"));
    }


    @Step("Добавление в закладки через API - пользователь не авторизован")
    public void AddToFavouriteViaApiAuthorizationOff() {

        given()
                .spec(request)
                //.cookie(userToken)
                .accept("application/json")
                .body("{\"type\":\"news\",\"id\":\"53900\"}")
                .post("https://stopgame.ru/ajax/favourite/change")
                .then()
                .log().all()
                .body("name", is("Forbidden"), "message", is("Требуется вход."));
    }
}

