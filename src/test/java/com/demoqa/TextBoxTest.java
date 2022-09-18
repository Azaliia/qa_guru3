package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setUp()
    {
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        String name = "Egor";
        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Some address1");
        $("#permanentAddress").setValue("Some address2");
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text("Egor@egor.com"));
        $("#output #currentAddress").shouldHave(text("Some address1"));
        $("#output #permanentAddress").shouldHave(text("Some address2"));


    }

}
