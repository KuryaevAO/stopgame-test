package com.kuryaevao.pages;

import com.codeborne.selenide.Condition;
import com.kuryaevao.test.TestBaseMobile;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ActionPageMobile extends TestBaseMobile {

    @Step("Ввод текста для перевода")
    public void InputTextForTranslate() {
        $(MobileBy.id("ru.yandex.translate:id/et_input_field")).setValue("game");
    }

    @Step("Проверка перевода текста")
    public void TranslationCheck() {
        $(MobileBy.id("ru.yandex.translate:id/tv_translation")).shouldHave(Condition.text("игра"));
    }

    @Step("Выбор другого языка")
    public void SwitchingLanguage() {
        $(MobileBy.id("ru.yandex.translate:id/tv_translate_target_lang")).click();
        $(MobileBy.id("ru.yandex.translate:id/inputField")).setValue("German");
        $(MobileBy.id("ru.yandex.translate:id/tv_title_lang")).click();
    }

    @Step("Проверка смены языка")
    public void LanguageCheck() {
        $(MobileBy.id("ru.yandex.translate:id/tv_translate_target_lang")).shouldHave(Condition.text("German"));
    }

    @Step("Переход в настройки")
    public void ProceedToSettings() {
        $(MobileBy.id("ru.yandex.translate:id/settingsButton")).click();
    }

    @Step("Проверка настроек")
    public void SettingsCheck() {
        $(MobileBy.id("ru.yandex.translate:id/tv_title")).shouldHave(Condition.text("Settings"));
    }
}

