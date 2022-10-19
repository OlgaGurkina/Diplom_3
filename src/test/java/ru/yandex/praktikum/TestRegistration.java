package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestRegistration {

    //запуск в ГуглХроме
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://stellarburgers.nomoreparties.site/register");

    }

    // для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
//    @Before
//    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
//        Selenide.open("https://stellarburgers.nomoreparties.site/register");
//    }


    @Test
    @DisplayName("test positive case of registration")
    public void checkPositiveRegistration() throws InterruptedException {
        RandomParamsForNewUser newUser = new RandomParamsForNewUser();
        newUser.randomUserEmail();
        newUser.randomUserPass();
        newUser.randomUserName();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterName(newUser.generatedName);
        registrationPage.enterEmail(newUser.generatedEmail);
        registrationPage.enterPassword(newUser.generatedPassword);
        LoginPage loginPage = registrationPage.pressRegisterButton();
        TimeUnit.SECONDS.sleep(2);
        loginPage.enterEmail(newUser.generatedEmail);
        loginPage.enterPassword(newUser.generatedPassword);
        loginPage.pressLoginButton();


    }

    @Test
    @DisplayName("test registration with incorrect pass")
    public void checkRegistrationWithIncorrectPass(){
        RandomParamsForNewUser newUser = new RandomParamsForNewUser();
        newUser.randomUserEmail();
        newUser.randomUserName();
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterName(newUser.generatedName);
        registrationPage.enterEmail(newUser.generatedEmail);
        registrationPage.enterPassword("123");
        registrationPage.seeInputErrorWhenIncorrectPass();

    }

   @After
   public void after() {
       Selenide.closeWebDriver();
   }

}
