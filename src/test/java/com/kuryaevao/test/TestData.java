package com.kuryaevao.test;

import com.github.javafaker.Faker;

public class TestData {

    public static final String FORM_TITLE = "https://stopgame.ru";
    static Faker faker = new Faker();

    public static String
            fakerUser = faker.name().firstName(),
            gameName = "Deus Ex",
            developerName = "Ion Storm",
            platformName = "PC";
}
