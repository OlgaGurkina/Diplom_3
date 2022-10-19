package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$$;

public class ForgotPasswordPage {

    private SelenideElement loginButton = $$(byClassName("Auth_link__1fOlj")).findBy(Condition.text("Войти"));


    public LoginPage pressLoginFromForgerPassPage(){
        loginButton.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }


}
