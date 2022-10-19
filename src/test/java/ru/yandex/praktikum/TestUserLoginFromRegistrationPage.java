package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestUserLoginFromRegistrationPage {

//    //запуск в ГуглХроме
//    @Before
//    public void startUp() {
//        WebDriverManager.chromedriver().setup();
//        Selenide.open("https://stellarburgers.nomoreparties.site/register");
//    }

   //  для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
        Selenide.open("https://stellarburgers.nomoreparties.site/register");
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
