package com.kuryaevao.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kuryaevao.pages.components.CalendarComponent;
import com.kuryaevao.tests.TestData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ActionPage extends TestData {

    private final String FORM_TITLE = "https://stopgame.ru";

    private SelenideElement
            formTitle = $("._header__logo_1je6x_1"),
            loginThumbnail = $("[aria-label=Войти]"),
            sgLogin = $("[href='#auth/stopgame']"),
            typeLogin = $("[name=login]"),
            typePassword = $("[name=password]"),
            typeSubmit = $("[type=submit]"),
            userButton = $("button._header__profile-btn_1je6x_271"),
            userPage = $("._user-menu__profile_pxt36_101 a span"),
            userLogOut= $("[aria-label='Меню пользователя']").$$("ul li a").findBy(text("Выйти")),
            userNameOnPage = $("._section_n5f0l_3 h1"),
            searchBar = $("[aria-label=Поиск]"),
            searchByText = $("._search-input__input_eolml_1"),
            searchCheck = $("[name=s]");


    public CalendarComponent calendar = new CalendarComponent();

    @Step("Открытие страницы")
    public void openPage() {
        open("https://stopgame.ru/");
        formTitle.getAttribute("href").equals(FORM_TITLE);
    }

    @Step("Проверка заголовка")
    public void checkPageHeader() {
        formTitle.getAttribute("href").equals(FORM_TITLE);
    }

    @Step("Открытие формы ввода логина и пароля")
    public void openLoginForm() {
        loginThumbnail.click();
        sgLogin.click();
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
        userLogOut.click();;
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

