package com.kuryaevao.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kuryaevao.tests.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ActionPage extends TestData {

    private final String FORM_TITLE = "https://stopgame.ru";
    String commentText;

    private SelenideElement
            formTitle = $("._header__logo_nqpt8_1"),
            loginThumbnail = $("[aria-label=Войти]"),
            sgLogin = $("[href='#auth/stopgame']"),
            typeLogin = $("[name=login]"),
            typePassword = $("[name=password]"),
            typeSubmit = $("[type=submit]"),
            userButton = $("._header__profile-btn_nqpt8_259"),
            userPage = $("._user-menu__profile_pxt36_101 a span"),
            userLogOut = $("[aria-label='Меню пользователя']").$$("ul li a").findBy(text("Выйти")),
            userNameOnPage = $("._username-row_1ggfy_209"),
            searchBar = $("[aria-label=Поиск]"),
            searchByText = $("._search-input__input_1ner1_1"),
            searchCheck = $("[name=s]"),
            helpPage = $("[aria-label='Разделы сайта']").$$("ul li a").findBy(text("Помощь")),
            aboutProjectPage = $(".subnav").$$("ul li a").findBy(text("О проекте")),
            aboutProjectText = $(".main-content .article").$$("p").findBy(text("StopGame — коллектив авторов, который (вопреки своему названию) уже десять лет рассказывает всем желающим о видеоиграх.")),
            wayToTheGame = $("#w0 [data-key='0'] ._image-container_99wqg_31"),
            wayToTheDataInTheGame = $("._card_fcjhe_4 ._info-grid_fcjhe_200"),
            platformText = $("._h1_v95ji_1"),
            commentsButton = $("[aria-label='Последние комментарии']"),
            latestComment = $$("._live-comments__scrollable-container_hfk3j_1 a ._live-comment__content_15e65_1").first(),
            commentCheck = $("#comments"),
            addGameButton = $("button._primary_9mrzr_108"),
            addGameName = $("input._input_160th_1"),
            addGameResult = $$("button._game_6103z_32").first(),
            addGameStatus = $("._buttons_1oyf3_27"),
            addedGameStatus = $("._last-added-grid_1ggfy_582 ._card_1no86_1 ._status-button_1no86_97"),
            userSearch = $("._search-categories_1ner1_176").$("[type='button']", 1),
            fullUserSearch = $(byText("Смотреть все")),
            userList = $("._items-grid_1t2u7_33"),
            socialNetworkLinks = $("[aria-label='Мы в соц.сетях']");

    @Step("Открытие страницы")
    public void openPage() {
        open("https://stopgame.ru/");
        sleep(2000);
    }

    @Step("Проверка заголовка")
    public void checkPageHeader() {
        formTitle.getAttribute("href").equals(FORM_TITLE);
    }

    @Step("Открытие формы ввода логина и пароля")
    public void openLoginForm() {
        loginThumbnail.click();
        sgLogin.click();
        sleep(2000);
    }

    @Step("Ввод логина")
    public void typeLogin(String value) {
        sleep(1000);
        typeLogin.setValue(value);
    }

    @Step("Ввод пароля")
    public void typePassword(String value) {
        typePassword.setValue(value);
    }

    @Step("Подтверждение отправки")
    public void typeSubmit() {
        typeSubmit.click();
    }

    @Step("Переход в меню юзера")
    public void userButton() {
        userButton.click();
    }

    @Step("Переход в меню юзера")
    public void userPage() {
        userPage.click();
    }

    @Step("Выход из профиля")
    public void logOutButton() {
        userLogOut.click();
    }

    @Step("Проверка имени юзера на странице юзера")
    public void userNameCheck(String value) {
        userNameOnPage.shouldHave(Condition.text(value));
    }

    @Step("Поиск по названию")
    public void searchBar(String value) {
        searchBar.click();
        searchByText.setValue(value).pressEnter();
    }

    @Step("Сверка поиска с результатом")
    public void searchCheck(String value) {
        searchCheck.shouldHave(Condition.value(value));
    }

    @Step("Переход в раздел Помощь")
    public void goToHelp() {
        helpPage.click();
    }

    @Step("Переход в раздел О проекте")
    public void goToAboutProject() {
        aboutProjectPage.click();
    }

    @Step("Проверка информации О проекте")
    public void aboutProject() {
        aboutProjectText.shouldBe(visible);
    }

    @Step("Открытие игры")
    public void proceedToTheGame() {
        wayToTheGame.click();
    }

    @Step("Проверка разработчика")
    public void developerCheck(String value) {
        wayToTheDataInTheGame.$$("._info-grid__value_fcjhe_226").findBy(text(value));
    }

    @Step("Переход на платформу")
    public void platformCheck(String value) {
        wayToTheDataInTheGame.$$("[href='/games/PC']").findBy(text(value)).click();
    }

    @Step("Проверка платформы")
    public void platformTextCheck() {
        platformText.shouldHave(text("Недавно добавленные игры на ПК (PC)"));
    }

    @Step("Нажатие кнопок с последними комментариями")
    public void commentsButtonCheck() {
        commentsButton.click();
    }

    @Step("Выбор последнего комментария")
    public void latestCommentProceed() {
        commentText = latestComment.getText();
        latestComment.click();
    }

    @Step("Проверка комментария на странице новости")
    public void latestCommentOnPageCheck() {
        commentCheck.$$("._comment__body_1eedu_1").findBy(text(commentText));
    }

    @Step("Нажатие на Добавить игру")
    public void pressAddGame() {
        addGameButton.click();
    }

    @Step("Выбор игры")
    public void selectAddGame(String value) {
        addGameName.setValue(value);
        sleep(2000);
        actions().sendKeys(Keys.SPACE);
        sleep(2000);
        addGameResult.click();
    }

    @Step("Проставление статуса")
    public void setStatusToAddGame() {
        addGameStatus.$$("._button_1oyf3_27").findBy(text("Пройдено")).click();
        sleep(1000);
    }

    @Step("Обновление страницы")
    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    @Step("Проверка наличия игры")
    public void openAddedGame() {
        addedGameStatus.click();
        sleep(1000);
    }

    @Step("Удаление игры")
    public void deleteAddedGame() {
        addGameStatus.$$("._button_1oyf3_27").findBy(text("Пройдено")).click();
    }

    @Step("Поиск юзеров")
    public void searchForUser(String value) {
        searchBar.click();
        userSearch.click();
        searchByText.setValue(value);
        sleep(2000);
    }

    @Step("Открытие полного списка юзеров")
    public void searchForUserList() {
        fullUserSearch.click();
    }

    @Step("Проверка наличия имени в результате")
    public void userListCheck(String value) {
        userList.$$("div").findBy(text(value));
    }

    @Step("Проверка наличия ссылки ВК")
    public void networkVkCheck() {
        socialNetworkLinks.scrollTo();
        socialNetworkLinks.$$("li a").findBy(text("Группа StopGame Вконтакте"));
        socialNetworkLinks.$$("li a").findBy(text("https://vk.com/stopgameru"));
    }

    @Step("Проверка наличия ссылки Steam")
    public void networkSteamCheck() {
        socialNetworkLinks.$$("li a").findBy(text("Коммьюнити StopGame в Steam"));
        socialNetworkLinks.$$("li a").findBy(text("https://steamcommunity.com/groups/stopgamecommunity"));
    }

    @Step("Проверка наличия ссылки Twitch")
    public void networkTwitchCheck() {
        socialNetworkLinks.$$("li a").findBy(text("Канал StopGame в Twitch"));
        socialNetworkLinks.$$("li a").findBy(text("https://www.twitch.tv/stopgameru/"));
    }
}

