package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

public class BaseTest {
    Faker faker = new Faker(new Locale("de"));

    String
            name = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Female",
            mobile = faker.phoneNumber().subscriberNumber(10),
            day = "08",
            month = "August",
            year = "1990",
            subject = "English",
            address = faker.address().fullAddress(),
            hobbie = "Reading",
            picterUrl = "1.png",
            state = "NCR",
            city = "Delhi"
                    ;

    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
