package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class PracticeFormTest {

    Faker faker = new Faker(new Locale("de"));

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){

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

        practiceFormPage
                .openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbie)
                .setPicture(picterUrl)
                .setAddress(address)
                .setLocation(state, city)
                .clickSubmit();

        practiceFormPage.checkResult("Student Name", (name + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", "1.png")
                .checkResult("Address", address)
                .checkResult("State and City", state+ " " + city);

    }
}
