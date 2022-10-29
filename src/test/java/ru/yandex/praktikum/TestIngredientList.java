package ru.yandex.praktikum;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIngredientList {
    //запуск в ГуглХроме
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        Selenide.open(Configuration.testSiteMainPage);
    }
    // для запуска тестов в ЯндексБраузере (скачала яндекс драйвер для работы с селенидом, сделалала файл испоняемым)
//    @Before
//    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Olga/github/OlgaGurkina/Diplom_3/yandexdriver");
//        Selenide.open("Configuration.testSiteMainPage");
//    }

    @Test
    @DisplayName("check user can change IngredientsList by clicking different tabs")
    public void checkIngredientsList() {
        MainPage mainPage = new MainPage();
        mainPage.checkIngredientsList();
    }

    @After
    public void after() {
        Selenide.closeWebDriver();
    }
}
