package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.restassured.RestAssured;
import java.util.concurrent.TimeUnit;

public class TestRegistration {

    //запуск в ГуглХроме
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.open(Configuration.testSiteRegistrationPage);

    }
    // для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
//    @Before
//    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
//        Selenide.open(Configuration.testSiteRegistrationPage);
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

        //delete created user
        UserJson userJson = new UserJson(newUser.generatedEmail, newUser.generatedPassword);
        String accessToken = RestAssured.with()
                .header("Content-Type", "application/json")
                .baseUri("https://stellarburgers.nomoreparties.site")
                .body(userJson)
                .post("/api/auth/login")
                .then()
                .extract().body().path("accessToken").toString();
        RestAssured.with()
                .header("Content-Type", "application/json")
                .header("Authorization", accessToken)
                .baseUri("https://stellarburgers.nomoreparties.site")
                .delete("/api/auth/user");
    }

    @Test
    @DisplayName("test registration with incorrect pass")
    public void checkRegistrationWithIncorrectPass() {
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
