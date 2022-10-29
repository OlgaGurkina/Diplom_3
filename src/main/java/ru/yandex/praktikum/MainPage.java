package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private SelenideElement loginButton = $$(byClassName("button_button__33qZ0")).findBy(Condition.text("Войти в аккаунт"));
    private SelenideElement orderButton = $$(byClassName("button_button__33qZ0")).findBy(Condition.text("Оформить заказ"));
    private SelenideElement personalAccount = $$(byClassName("AppHeader_header__linkText__3q_va")).findBy(Condition.text("Личный Кабинет"));
    private ElementsCollection ingredientTypeSelectors = $$(byClassName("tab_tab__1SPyG"));
    private SelenideElement bunSelector = ingredientTypeSelectors.get(0);
    private SelenideElement sauceSelector = ingredientTypeSelectors.get(1);
    private SelenideElement fillingSelector = ingredientTypeSelectors.get(2);
    private SelenideElement sauceSelected = $(byXpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']"));
    private SelenideElement fillingSelected = $(byXpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']"));
    private SelenideElement bunSelected = $(byXpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']"));
    private SelenideElement ingredientsList = $(byClassName("BurgerIngredients_ingredients__1N8v2"));

    @Step("login from Main page")
    public LoginPage tryLoginFormMainPage() {
        loginButton.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }

    public void checkUserIsLoggedIn() {
        orderButton.exists();
    }

    public LoginPage enterPersonalAccountNotAuth() {
        personalAccount.click();
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }


    public PersonalAccount enterPersonalAccount() {
        personalAccount.click();
        PersonalAccount personalAccount = new PersonalAccount();
        return personalAccount;
    }

    public void checkIngredientsList() {
        sauceSelector.click();
        sauceSelected.exists();
        fillingSelector.click();
        fillingSelected.exists();
        bunSelector.click();
        bunSelected.exists();
    }

    public void checkPageIsOpened() {
        ingredientsList.click();
    }
}
