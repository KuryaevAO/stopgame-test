package com.kuryaevao.test;

import com.kuryaevao.main.java.io.qameta.allure.Layer;
import com.kuryaevao.pages.ActionPageMobile;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Layer("Mobile")
@Owner("allure8")
@Issue("HOMEWORK-748")

public class StopGameMobileTests extends TestBaseMobile {

    ActionPageMobile actionPageMobile = new ActionPageMobile();

    @Test
    @Feature("Mobile features")
    //@AllureId("23260")
    @DisplayName("Translation text")
    @Tag("test_mobile")
    void TranslationTest() {

        actionPageMobile.InputTextForTranslate();
        actionPageMobile.TranslationCheck();
    }

    @Test
    @Feature("Mobile features")
    //@AllureId("23260")
    @DisplayName("Switching language")
    @Tag("test_mobile")
    void SwitchingLanguageTest() {

        actionPageMobile.SwitchingLanguage();
        actionPageMobile.LanguageCheck();
    }

    @Test
    @Feature("Mobile features")
    //@AllureId("23260")
    @DisplayName("Open Settings")
    @Tag("test_mobile")
    void OpeningSettingsTest() {

        actionPageMobile.ProceedToSettings();
        actionPageMobile.SettingsCheck();
    }

}
