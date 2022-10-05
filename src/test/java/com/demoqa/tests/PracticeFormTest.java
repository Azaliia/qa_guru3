package com.demoqa.tests;

import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest(){

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
