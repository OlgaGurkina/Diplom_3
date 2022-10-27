package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {

    private ElementsCollection inputFields = $$(byClassName("input__textfield"));
    private SelenideElement name = inputFields.get(0);
    private SelenideElement email = inputFields.get(1);
    private SelenideElement password = inputFields.get(2);
    private SelenideElement registerButton = $$(byClassName("button_button__33qZ0")).findBy(Condition.text("Зарегистрироваться"));
    private SelenideElement incorrectInputPassLabel = $(byClassName("input__error"));
    private SelenideElement loginButton = $$(byClassName("Auth_link__1fOlj")).findBy(Condition.text("Войти"));

    @Step("enter user Name")
    public void enterName(String newName) {
        name.setValue(newName);
    }

    @Step("enter user Email")
    public void enterEmail(String newEmail) {
        email.setValue(newEmail);
    }

    @Step("enter user Password")
    public void enterPassword(String newPass) {
        password.setValue(newPass);
    }

    @Step("press Registration button")
    public LoginPage pressRegisterButton() {
        registerButton.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }

    @Step("check Input Error message if wrong password ws entered")
    public void seeInputErrorWhenIncorrectPass() {
        registerButton.click();
        incorrectInputPassLabel.exists();
    }

    @Step("press login button on registration page")
    public LoginPage pressLoginButton() {
        loginButton.scrollTo().click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }
}
