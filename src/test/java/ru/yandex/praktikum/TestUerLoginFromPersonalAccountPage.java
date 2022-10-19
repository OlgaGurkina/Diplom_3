package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUerLoginFromPersonalAccountPage {

    //запуск в ГуглХроме
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://stellarburgers.nomoreparties.site/");
    }

    // для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
//    @Before
//    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
//        Selenide.open("https://stellarburgers.nomoreparties.site/");
//    }


    @Test
    @DisplayName("check user can login from Personal Account")
    public void checkLoginFromPersonalAcc() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.enterPersonalAccountNotAuth();
        loginPage.enterEmail(Configuration.testUserEmail);
        loginPage.enterPassword(Configuration.testUserPass);
        MainPage loggedUserMainPage = loginPage.pressLoginButton();
        loggedUserMainPage.checkUserIsLoggedIn();
        loggedUserMainPage.enterPersonalAccount().logout();

    }

    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
