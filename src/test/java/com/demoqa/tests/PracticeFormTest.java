package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

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
                name = "Ivan",
                lastName = "Ivanov",
                email = "ivan@test.ru",
                gender = "Female",
                mobile = "3246758909",
                subject = "English",
                address = "test street",
                hobbie = "Reading",
                picterUrl = "1.png";

        practiceFormPage
                .openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate("08", "August", "1990")
                .setSubject(subject)
                .setHobbies(hobbie)
                .setPicture(picterUrl)
                .setAddress(address)
                .setLocation("NCR", "Delhi")
                .clickSubmit();

        practiceFormPage.checkResult("Student Name", (name + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", "08 August,1990")
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", "1.png")
                .checkResult("Address", address)
                .checkResult("State and City", "NCR Delhi");

    }
}
