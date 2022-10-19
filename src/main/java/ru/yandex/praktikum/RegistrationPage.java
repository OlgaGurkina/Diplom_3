package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {

private ElementsCollection inputFields = $$(byClassName("input__textfield"));
    private SelenideElement name = inputFields.get(0);
    private SelenideElement email =  inputFields.get(1);
    private SelenideElement password =  inputFields.get(2);
    private SelenideElement registerButton = $$(byClassName("button_button__33qZ0")).findBy(Condition.text("Зарегистрироваться"));
    private SelenideElement incorrectInputPassLabel = $(byClassName("input__error"));
    private SelenideElement loginButton = $$(byClassName("Auth_link__1fOlj")).findBy(Condition.text("Войти"));

    public void enterName(String newName){
        name.setValue(newName);
    }
    public void enterEmail(String newEmail){
        email.setValue(newEmail);
    }
    public void enterPassword(String newPass){
        password.setValue(newPass);
    }
    public LoginPage pressRegisterButton(){
        registerButton.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }
   public void seeInputErrorWhenIncorrectPass(){
        registerButton.click();
        incorrectInputPassLabel.exists();
}
   public LoginPage pressLoginButton(){
        loginButton.scrollTo().click();
        LoginPage loginPage = new LoginPage();
        return  loginPage;
}

}
