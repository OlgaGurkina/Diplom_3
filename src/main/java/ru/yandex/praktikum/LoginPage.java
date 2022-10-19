package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private ElementsCollection inputFields = $$(byClassName("input__textfield"));
    private SelenideElement email =  inputFields.get(0);
    private SelenideElement password =  inputFields.get(1);
    private SelenideElement loginButton = $$(byClassName("button_button__33qZ0")).findBy(Condition.text("Войти"));

    private SelenideElement registrationButton = $$(byClassName("Auth_link__1fOlj")).findBy(Condition.text("Зарегистрироваться"));
    private SelenideElement forgetPassButton = $$(byClassName("Auth_link__1fOlj")).findBy(Condition.text("Восстановить пароль"));


    public void enterEmail(String userEmail){
        email.setValue(userEmail);
    }
    public void enterPassword(String userPass){
        password.setValue(userPass);
    }
    public MainPage pressLoginButton(){
        loginButton.click();
        MainPage mainPage = new MainPage();
        return mainPage;
    }

    public void checkLoginPageIsOpened() {
        registrationButton.exists();
        forgetPassButton.exists();
    }

}