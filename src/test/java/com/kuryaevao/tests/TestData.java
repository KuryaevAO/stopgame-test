package com.kuryaevao.tests;

import com.github.javafaker.Faker;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.pokemon().name() + "@gmail.com",
            userGender = "Male",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "Maths",
            hobby = "Sports",
            currentAddress = faker.twinPeaks().location(),
            userState = "NCR",
            userCity = "Delhi";
}
