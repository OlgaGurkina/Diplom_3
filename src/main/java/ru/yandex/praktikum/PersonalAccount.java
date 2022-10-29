package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalAccount {
    private SelenideElement logOut = $$(byClassName("Account_button__14Yp3")).findBy(Condition.text("Выход"));
    private ElementsCollection personalInfoFields = $$(byClassName("input__textfield"));
    private SelenideElement currentName = personalInfoFields.get(0);
    private SelenideElement currentEmail = personalInfoFields.get(1);
    private SelenideElement constructorButton = $$(byClassName("AppHeader_header__linkText__3q_va")).findBy(Condition.text("Конструктор"));
    private SelenideElement logoButton = $(byClassName("AppHeader_header__logo__2D0X2"));

    @Step("log out from PersonalAccount page")
    public LoginPage logout() {
        logOut.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }

    @Step("check user info")
    public void checkCurrentUserInfo(String name, String email) {
        Assert.assertEquals(name, currentName.getValue());
        Assert.assertEquals(email, currentEmail.getValue());
    }

    @Step("press Constructor button")
    public MainPage pressConstructorButton() {
        constructorButton.click();
        MainPage mainPage = new MainPage();
        return mainPage;
    }

    @Step("press logout button on PersonalAccount page")
    public MainPage pressLogoButton() {
        logoButton.click();
        MainPage mainPage = new MainPage();
        return mainPage;
    }
}
