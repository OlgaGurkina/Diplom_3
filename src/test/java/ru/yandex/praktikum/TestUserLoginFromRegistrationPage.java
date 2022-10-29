package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestUserLoginFromRegistrationPage {

    //    //запуск в ГуглХроме
//    @Before
//    public void startUp() {
//        WebDriverManager.chromedriver().setup();
//        Selenide.open(Configuration.testSiteRegistrationPage);
//    }
    //  для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
        Selenide.open(Configuration.testSiteRegistrationPage);
    }

    @Test
    @DisplayName("press Войти on Registration page")
    public void checkLoginFromRegistrationPage() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage();
        LoginPage loginPage = registrationPage.pressLoginButton();
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
