package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.GeolocationComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private GeolocationComponent geolocationComponent = new GeolocationComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            pictureInput = $("#uploadPicture");;

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public PracticeFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }
    public PracticeFormPage setMobile(String value){
        mobileInput.setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setLocation(String state, String city) {
        $("#state").scrollIntoView(true);
        geolocationComponent.setGeolocation(state, city);

        return this;
    }

    public PracticeFormPage clickSubmit() {
        $("#submit").click();

        return this;
    }

    public PracticeFormPage checkResult(String key, String info) {
        resultsTableComponent.resultsIsVisible(key, info);

        return this;
    }

}
