package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        String name = "Ivan";
        String lastName = "Ivanov";
        String email = "ivan@test.ru";
        String mobile = "3246758909";
        String subject = "English";
        String address = "test street";
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $("[class*='day--011']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/main/resources/1.png"));
        $("#currentAddress").setValue(address);
        $("#state .css-19bqh2r").click();
        $(byText("NCR")).click();
        $("#city .css-19bqh2r").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $("#output #name").shouldHave(text(name));
    }
}
