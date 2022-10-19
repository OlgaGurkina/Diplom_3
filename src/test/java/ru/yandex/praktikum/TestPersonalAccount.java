package ru.yandex.praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPersonalAccount {
    //запуск в ГуглХроме
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://stellarburgers.nomoreparties.site");
    }

    // для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
//    @Before
//    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
//        Selenide.open("https://stellarburgers.nomoreparties.site");
//    }

    @Test
    @DisplayName("check entering PersonalAcc from main page for logged user")
    public void checkPersAccEntering(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.tryLoginFormMainPage();
        loginPage.enterEmail(Configuration.testUserEmail);
        loginPage.enterPassword(Configuration.testUserPass);
        MainPage loggedUserMainPage = loginPage.pressLoginButton();
        loggedUserMainPage.checkUserIsLoggedIn();
        loggedUserMainPage.enterPersonalAccount().checkCurrentUserInfo(Configuration.testUserName, Configuration.testUserEmail);
    }

    @Test
    @DisplayName("go to MainPage with ConstructorButton")
    public void checkEnterMainPageViaConstructorButton(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.tryLoginFormMainPage();
        loginPage.enterEmail(Configuration.testUserEmail);
        loginPage.enterPassword(Configuration.testUserPass);
        MainPage loggedUserMainPage = loginPage.pressLoginButton();
        PersonalAccount personalAccount = loggedUserMainPage.enterPersonalAccount();
        personalAccount.pressConstructorButton().checkPageIsOpened();
    }

    @Test
    @DisplayName("go to MainPage with LogoButton")
    public void checkEnterMainPageViaLogoButton(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.tryLoginFormMainPage();
        loginPage.enterEmail(Configuration.testUserEmail);
        loginPage.enterPassword(Configuration.testUserPass);
        MainPage loggedUserMainPage = loginPage.pressLoginButton();
        PersonalAccount personalAccount = loggedUserMainPage.enterPersonalAccount();
        personalAccount.pressLogoButton();
    }

    @Test
    @DisplayName("check logout")
    public void checkLogOut(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.tryLoginFormMainPage();
        loginPage.enterEmail(Configuration.testUserEmail);
        loginPage.enterPassword(Configuration.testUserPass);
        MainPage loggedUserMainPage = loginPage.pressLoginButton();
        PersonalAccount personalAccount = loggedUserMainPage.enterPersonalAccount();
        personalAccount.logout();
    }


    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
