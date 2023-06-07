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
            formTitle = $("._header__logo_1je6x_1"),
            loginThumbnail = $("[aria-label=Войти]"),
            sgLogin = $("[href='#auth/stopgame']"),
            typeLogin = $("[name=login]"),
            typePassword = $("[name=password]"),
            typeSubmit = $("[type=submit]"),
            userButton = $("button._header__profile-btn_1je6x_271"),
            userPage = $("._user-menu__profile_pxt36_101 a span"),
            userLogOut = $("[aria-label='Меню пользователя']").$$("ul li a").findBy(text("Выйти")),
            userNameOnPage = $("._section_n5f0l_3 h1"),
            searchBar = $("[aria-label=Поиск]"),
            searchByText = $("._search-input__input_eolml_1"),
            searchCheck = $("[name=s]"),
            helpPage = $("[aria-label='Разделы сайта']").$$("ul li a").findBy(text("Помощь")),
            aboutProjectPage = $(".subnav").$$("ul li a").findBy(text("О проекте")),
            aboutProjectText = $(".main-content .article").$$("p").findBy(text("StopGame — коллектив авторов, который (вопреки своему названию) уже десять лет рассказывает всем желающим о видеоиграх.")),
            wayToTheGame = $("#w0 [data-key='0'] ._title_sh7r2_151 a"),
            wayToTheDataInTheGame = $("._card_sh7r2_4 ._info-grid_sh7r2_186"),
            platformText = $("._content_dmef8_299 h1"),
            commentsButton = $("[aria-label='Последние комментарии']"),
            latestComment = $$("._live-comments__scrollable-container_ye4jv_1 a ._live-comment__content_15e65_1").first(),
            commentCheck = $("#comments"),
            addGameButton = $("button._primary_1a370_100"),
            addGameName = $("input._input_lqk7q_1"),
            addGameResult = $$("button._game_1seij_32").first(),
            addGameStatus = $("._buttons_1oyf3_27"),
            addedGameStatus = $("._last-added-grid_n5f0l_582 ._card_13hsk_1 ._status-button_13hsk_92"),
            userSearch = $$("._search-categories_eolml_176 button").findBy(text("Пользователи")),
            fullUserSearch = $(byText("Смотреть все")),
            userList = $("._items-grid_1t2u7_33"),
            socialNetworkLinks = $("[aria-label='Мы в соц.сетях']");

    @Step("Открытие страницы")
    public void openPage() {
        open("https://stopgame.ru/");
        formTitle.getAttribute("href").equals(FORM_TITLE);
        sleep(5000);
    }

    @Step("Проверка заголовка")
    public void checkPageHeader() {
        formTitle.getAttribute("href").equals(FORM_TITLE);
    }

    @Step("Открытие формы ввода логина и пароля")
    public void openLoginForm() {
        loginThumbnail.click();
        sgLogin.click();
        sleep(5000);
    }

    @Step("Ввод имени")
    public void typeLogin(String value) {
        typeLogin.setValue(value);
    }

    @Step("Ввод фамилии")
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
        wayToTheDataInTheGame.$$("._info-grid__value_sh7r2_200 a").findBy(text(value));
    }

    @Step("Проверка перехода на платформу")
    public void platformCheck(String value) {
        wayToTheDataInTheGame.$$("._info-grid__value_sh7r2_200 a").findBy(text(value)).click();
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
        sleep(5000);
        actions().sendKeys(Keys.SPACE);
        sleep(2000);
        addGameResult.click();
    }

    @Step("Проставление статуса")
    public void setStatusToAddGame() {
        addGameStatus.$$("._button_1oyf3_27").findBy(text("Пройдено")).click();
    }

    @Step("Обновление страницы")
    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    @Step("Проверка наличия игры")
    public void openAddedGame() {
        addedGameStatus.click();
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
        sleep(5000);
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









    /*@Step("Ввод почты")
    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    @Step("Ввод номера телефона")
    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    @Step("Ввод текущего адрес")
    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    @Step("Ввод пола")
    public void selectGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    @Step("Ввод предмета")
    public void selectSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    @Step("Ввод хобби")
    public void selectHobbies(String value) {
        hobbieWrapper.$(byText(value)).click();
    }

    @Step("Ввод штата")
    public void selectState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
    }

    @Step("Ввод города")
    public void selectCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
    }

    @Step("Отправка формы")
    public void submitForm() {
        submitInput.scrollTo().pressEnter();
    }

    @Step("Сверка введенных данных с полученной таблицей")
    public void createTable() {
        SelenideElement createdTable = $(byClassName("table-responsive"));

        createdTable.shouldHave(text(firstName + " " + lastName));
        createdTable.shouldHave(text(userEmail));
        createdTable.shouldHave(text(userGender));
        createdTable.shouldHave(text(userNumber));
        createdTable.shouldHave(text("25 December,1997"));
        createdTable.shouldHave(text(subject));
        createdTable.shouldHave(text(hobby));
        createdTable.shouldHave(text(currentAddress));
        createdTable.shouldHave(text(userState + " " + userCity));*/
}

